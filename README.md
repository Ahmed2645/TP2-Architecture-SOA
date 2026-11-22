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

## Tableau des tests

| Service | Méthode & Endpoint | Description du test | Résultat attendu | Résultat obtenu | Statut |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Client** | `POST /api/v1/clients` | Création d'un client | `201 Created` + `id` généré | `201 Created` + `id` généré | Validé |
| **Client** | `GET /api/v1/clients` | Lister tous les clients | `200 OK` + liste des clients | `200 OK` + liste retournée | Validé |
| **Client** | `GET /api/v1/clients/{id}` | Rechercher un client par `id` | `200 OK` + détails du client | `200 OK` + client trouvé | Validé |
| **Client** | `PUT /api/v1/clients/{id}` | Modifier un client | `200 OK` + client mis à jour | `200 OK` + modifications enregistrées | Validé |
| **Client** | `GET /api/v1/clients/inexistant` | Rechercher un ID inexistant | `404 Not Found` | `404 Not Found` | Validé |
| **Client** | `DELETE /api/v1/clients/{id}` | Supprimer un client de test | `200 OK` | `200 OK` + supprimé de MongoDB | Validé |
| **Product** | `POST /api/v1/products` | Création de deux produits | `201 Created` + `id` générés | `201 Created` + `id` générés | Validé |
| **Product** | `GET /api/v1/products` | Lister tous les produits | `200 OK` + liste des produits | `200 OK` + liste retournée | Validé |
| **Product** | `GET /api/v1/products/{id}` | Rechercher un produit par `id` | `200 OK` + détails du produit | `200 OK` + produit trouvé | Validé |
| **Product** | `PUT /api/v1/products/{id}` | Modifier le prix d'un produit | `200 OK` + nouveau prix | `200 OK` + prix mis à jour | Validé |
| **Product** | `GET /api/v1/products/inexistant` | Rechercher un ID inexistant | `404 Not Found` | `404 Not Found` | Validé |
| **Product** | `DELETE /api/v1/products/{id}` | Supprimer un produit de test | `200 OK` | `200 OK` + supprimé de MongoDB | Validé |
| **Order** | `POST /api/v1/orders` | Créer une commande | `201 Created` + `id` généré | `201 Created` + commande enregistrée | Validé |
| **Order** | `GET /api/v1/orders` | Lister toutes les commandes | `200 OK` + liste des commandes | `200 OK` + liste retournée | Validé |
| **Order** | `GET /api/v1/orders/{id}` | Rechercher une commande par `id` | `200 OK` + détails de la commande | `200 OK` + commande trouvée | Validé |
| **Indépendance** | Arrêt `product-service` + `GET` clients/orders | Vérifier l'isolation des services | `200 OK` sur `8081` et `8083` | `200 OK` sur Clients et Orders | Validé |
