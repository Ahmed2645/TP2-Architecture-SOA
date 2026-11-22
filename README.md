# TP2 - Partie 1 : Transformation du monolithe en services SOA

Ce projet consiste a decomposer l'application E-Commerce monolithique (TP1) en trois services Spring Boot independants communicant avec une base de donnees MongoDB (`ecommerce_soa`).

## Prerequis
- **Java** : JDK 21
- **Maven** : 3.9+ (ou utilisation du Maven Wrapper `./mvnw`)
- **Base de donnees** : MongoDB demarre sur `localhost:27017`
- **Outils de test** : Postman et MongoDB Compass

## Architecture des services et Ports

| Service | Package | Port | Base de donnees | Collection |
| :--- | :--- | :--- | :--- | :--- |
| `client-service` | `com.example.client` | `8081` | `ecommerce_soa` | `clients` |
| `product-service` | `com.example.product` | `8082` | `ecommerce_soa` | `products` |
| `order-service` | `com.example.order` | `8083` | `ecommerce_soa` | `orders` |

## Commandes de lancement

Ouvrir trois terminaux distincts et executer chaque service separement :

### 1. Lancer `client-service`
```bash
cd client-service
./mvnw spring-boot:run