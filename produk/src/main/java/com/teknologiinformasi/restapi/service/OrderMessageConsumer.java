package com.teknologiinformasi.restapi.service;

import com.teknologiinformasi.restapi.config.ProductRabbitConfig;
import com.teknologiinformasi.restapi.event.OrderCreatedEvent;
import com.teknologiinformasi.restapi.model.Produk;
import com.teknologiinformasi.restapi.repository.ProdukRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderMessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderMessageConsumer.class);

    private final ProdukRepository productRepository;

    public OrderMessageConsumer(ProdukRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RabbitListener(queues = ProductRabbitConfig.ORDER_QUEUE)
    public void receiveOrderEvent(OrderCreatedEvent event) {
        logger.info("Product Service menerima OrderCreatedEvent: {}", event);

        try {
            // Cari produk berdasarkan productId dari event
            Optional<Produk> productOpt = productRepository.findById(event.getProductId());
            if (productOpt.isPresent()) {
                Produk product = productOpt.get();

                // Validasi dan konversi stok ke integer
                int currentStock;
                try {
                    currentStock = Integer.parseInt(product.getStok());
                } catch (NumberFormatException e) {
                    logger.error("Stok produk ID {} tidak valid: {}", product.getId(), product.getStok());
                    return;
                }

                // Hitung stok baru
                int newStock = currentStock - event.getQuantity();

                // Validasi: stok tidak boleh negatif
                if (newStock < 0) {
                    logger.warn("Stok tidak cukup untuk produk ID {}: Stok saat ini {}, Pesanan membutuhkan {}",
                            product.getId(), currentStock, event.getQuantity());
                } else {
                    // Update stok produk
                    product.setStok(String.valueOf(newStock));
                    productRepository.save(product);
                    logger.info("Stok untuk produk ID {} diperbarui: {}", product.getId(), newStock);
                }
            } else {
                logger.warn("Produk dengan ID {} tidak ditemukan.", event.getProductId());
            }
        } catch (Exception e) {
            logger.error("Terjadi kesalahan saat memproses OrderCreatedEvent: {}", e.getMessage(), e);
        }
    }
}