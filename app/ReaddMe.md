Clean Archi 
Le projet suit une clean architecture qui sépare l'app en trois couches principales :

Data :

Cette couche gère les sources de données externes (API, bases de données locales, etc..).
Les entités de données sont mappées vers des objets du domaine (modèles), et les opérations CRUD y sont définies.
Elle n'a aucune connaissance directe de la logique métier ou de l'UI.

Domaine :

La couche la plus importante qui contient la logique métier.
Les cas d'utilisation (interactors) dans cette couche implémentent la logique de l'application et communiquent avec les repositories pour obtenir ou modifier des données.
Elle est totalement indépendante des frameworks et de l'UI.

UI (Interface Utilisateur) :

---------------------------
Core
Le dossier core contient les composants fondamentaux et génériques du projet, tels que les définitions de modules ou les classes de configuration qui sont partagés à travers plusieurs fonctionnalités.

Data
Le package data gère tout ce qui est relatif à la gestion des données. Cela inclut les sources de données locales et distantes, ainsi que les entités spécifiques au stockage des données.

CharacterLocal : Classe pour gérer les opérations locales sur les entités Character.
RMDatabse.kt : Gère la configuration de la base de données Realm.
objects/ : Contient les objets de base comme CharacterObject, qui représente un personnage stocké en base de données.
Remote : contient les classes responsables de récupérer les données distantes (API).

CharacterAPI.kt : Interface définissant les endpoints de l'API pour les personnages.
responses/ : Classes de réponses API telles que CharacterResponse ou LocationResponse.
di : Ce répertoire contient les modules de dépendance définis avec Hilt ou Koin.

DataModule.kt : Déclaration des modules de dépendance pour la couche data. 

Domain :
Le package domain contient la logique métier et les modèles qui sont indépendants des frameworks. C'est le cœur de l'architecture Clean, car cette couche est décorrélée des détails d'implémentation des sources de données ou de l'UI.

models/ :

Character.kt : Définition des modèles de domaine. Ces classes représentent les données utilisées par la couche de domaine et sont décorrélées des détails de la persistance ou de l'API.
Location.kt, LocationPreview.kt : Définissent les lieux et prévisualisations des lieux associés à un personnage.
repositories/ :

CharacterRepository.kt : Interface définissant les opérations de récupération et de stockage des personnages, utilisé par la couche domaine. L'implémentation se trouve dans la couche data.

UI
   Le package ui contient toutes les classes liées à l'interface utilisateur et à la présentation. Cette couche communique avec la couche domain pour récupérer et afficher les données.

composables/ : Contient des composants UI réutilisables basés sur Jetpack Compose. Exemple : PreviewContent.kt.

theme/ : Gère les définitions de thèmes, les couleurs, les typographies, et les styles utilisés à travers l'application.

navigation : Gère la navigation entre les différentes composantes de l'application.

Features
   Chaque fonctionnalité spécifique de l'application est isolée dans un sous-dossier de features/.