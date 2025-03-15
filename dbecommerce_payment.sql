-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2025 at 05:26 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbecommerce_payment`
--

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `id` bigint(20) NOT NULL,
  `order_number` varchar(255) NOT NULL,
  `amount` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `payment_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`id`, `order_number`, `amount`, `status`, `payment_date`) VALUES
(2, 'ORD-001', 150.75, 'PENDING', '2025-02-25 07:30:00'),
(3, 'ORD-003', 300, 'PENDING', '2025-02-25 07:30:00'),
(5, 'ORD-002', 200, 'PAID', '2025-02-25 07:30:00'),
(7, 'ORD-077', 700, 'PAID', '2025-02-25 07:30:00'),
(8, 'ORD-008', 250.75, 'PENDING', '2025-02-25 07:30:00'),
(9, 'ORD-008', 250.75, 'PENDING', '2025-02-25 07:30:00'),
(10, 'ORD-008', 250.75, 'PENDING', '2025-02-25 07:30:00'),
(11, 'ORD-008', 250.75, 'PENDING', '2025-02-25 07:30:00'),
(12, 'ORD-008', 250.75, 'PENDING', '2025-02-25 07:30:00'),
(13, 'ORD-008', 250.75, 'PENDING', '2025-02-25 07:30:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
