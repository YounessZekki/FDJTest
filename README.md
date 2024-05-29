# Préambule
FDJTest est une application Android qui démontre l'implémentation de l'architecture MVVM en utilisant Kotlin, Hilt pour l'injection de dépendances, et les principes de Clean Architecture. L'application permet aux utilisateurs de rechercher des ligues et d'afficher une liste d'équipes dans la ligue sélectionnée.
# Architecture
L'application est structurée selon les principes de Clean Architecture, ce qui aide à maintenir une séparation des préoccupations et à rendre la base de code plus modulaire et testable.
# Couches
1. **Couche de présentation** :
   - Contient la logique de l'interface utilisateur (Activités, ViewModels).
   - Utilise LiveData pour observer les changements dans le ViewModel.

2. **Couche de domaine** :
   - Contient la logique métier (UseCases).
   - Définit les interfaces pour les dépôts qui sont implémentés dans la couche de données.

3. **Couche de données** :
   - Gère les données provenant de différentes sources (dans notre cas, les API distantes).
   - Contient les modèles de données et les implémentations des dépôts.
# Structure du répertoire
fr.technosens.fdjtest
|-- data
|   |-- model
|   |-- repository
|   |-- api
|       |-- remote
|-- domain
|   |-- repository
|   |-- usecase
|-- di
|-- presentation
|   |-- ui
|       |-- viewmodel

# Bibliothèques utilisées
- **Kotlin** : Langage de programmation pour l'application Android.
- **Hilt** : Bibliothèque pour l'injection de dépendances.
- **Retrofit** : Pour les appels réseau.
- **Coroutines** : Pour exécuter du code non-bloquant et asynchrone.
- **LiveData** : Pour l'observation des données.
- **ViewModel** : Pour gérer les données liées à l'interface utilisateur.
- **RecyclerView** : Pour afficher la liste des éléments.
- **Picasso** : bibliothèque de téléchargement et de mise en cache d'images pour Android.
- **Mockito** : Pour le mock en tests.
- **JUnit** : Pour les tests unitaires.

# Screenshot
![alt text](https://github.com/YounessZekki/FDJTest/blob/main/app/src/main/res/screenshot/Screenshot_20240529-175552_FDJ%20Test.jpg)
![alt text](https://github.com/YounessZekki/FDJTest/blob/main/app/src/main/res/screenshot/Screenshot_20240529-175603_FDJ%20Test.jpg)
