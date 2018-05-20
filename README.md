# PublicOrderManager
 PublicOrderManager - Application for extracting public information from https://mojepanstwo.pl/api/zamowienia_publiczne

## Requirements:
postgresql

### Postgresql Configuration
Just type in terminal
```shell
su - postgres
psql

postgres-# CREATE DATABASE project_order_manager_db;
postgres-# CREATE USER project_order_manager WITH PASSWORD 'passwordToDb';
postgres-# GRANT ALL PRIVILEGES ON DATABASE project_order_manager_db to project_order_manager;
```
