# Customer API

## Create Customer
Endpoint : POST /api/Customer

request body: 
```json
{
    "nama" :"Customer a",
    "harga" : "230000",
    "deskripsi":"Customer a Customer terbaik"
}
```

response body (success):
```json
{
    "msg" :"Customer berhasil ditambahkan",
}
```

response body (failed):
```json
{
    "msg" :"Customer gagal ditambahkan",
}
```