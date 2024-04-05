Projet SpringPFA
Ce projet SpringPFA est une application web développée avec Spring Boot, Spring Data JPA, et Spring MVC. L'objectif principal de cette application est de fournir une plateforme de gestion des demandes pour une organisation ou une entreprise.

Fonctionnalités principales
Gestion des utilisateurs : Ajout, suppression, mise à jour et recherche des utilisateurs.
Gestion des rôles : Attribution des rôles aux utilisateurs pour définir les autorisations.
Gestion des demandes : Création et suivi des demandes, affectation à des utilisateurs, etc.
Sécurité : Authentification et autorisation basées sur les rôles des utilisateurs.
Interface utilisateur conviviale : Interface moderne et réactive pour une expérience utilisateur fluide.
Technologies utilisées
Java 11
Spring Boot 2.x
Spring Data JPA
Spring MVC
Hibernate
Thymeleaf pour les templates HTML
MySQL pour la base de données
Structure du projet
entities : Contient les entités JPA telles que User, Demande, UserRole, etc.
Repository : Les interfaces de repository pour accéder aux données.
Controller : Les contrôleurs Spring MVC pour gérer les requêtes HTTP et les vues.
Service : Les services qui implémentent la logique métier de l'application.
Web : Les fichiers HTML, CSS, et JavaScript pour l'interface utilisateur.
Config : Les configurations Spring Boot et de sécurité.
Comment contribuer
Clonez le dépôt sur votre machine locale.
Créez une branche pour vos modifications : git checkout -b nom-de-votre-branche
Faites vos modifications et testez-les.
Validez vos modifications : git commit -m "Description de vos modifications"
Poussez vos modifications sur votre fork : git push origin nom-de-votre-branche
Créez une Pull Request sur GitHub.
N'hésitez pas à ouvrir des issues pour signaler des bugs ou proposer des améliorations !
