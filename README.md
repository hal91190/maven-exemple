# Exemple de projet Maven/Java

## Étape 1 : initialiser le projet
### Créer le projet à partir d'un archétype
Même s'il est un peu daté, l'archétype `org.apache.maven.archetypes:maven-archetype-quickstart` permet de créer un squelette de projet Maven/Java.

```bash
mvn archetype:generate \
    -DinteractiveMode=false \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.1 \
    -DgroupId=fr.uvsq.poo \
    -DartifactId=maven-exemple \
    -Dpackage=fr.uvsq.poo.compte
```

### Initialiser le dépôt git
```bash
git init
git add .
git commit -m"Initialise le projet Maven"
```
Après ces commandes, le dépôt comporte un _commit_ sur la branche _master_.

### Faire le lien avec le dépôt distant sur la forge (_github_, _bitbucket_, ...)
Tout d'abord, il est nécessaire de créer le dépôt distant sur la forge.
Ensuite, il suffit de le lier avec le dépôt local.

```bash
git remote add origin git@github.com:hal91190/maven-exemple.git
git push -u origin master
```

### Vérifier la construction du projet avec Maven
On génère un `jar` du projet.

```bash
mvn package
```
Cette commande crée un répertoire `target` contenant les résultats de la construction du projet.
Ce répertoire ne doit pas être ajouté au dépôt git.
On ajoute donc un fichier `.gitignore` à partir du modèle se trouvant sur [github](https://raw.githubusercontent.com/github/gitignore/master/Maven.gitignore).

### Importer le projet dans l'IDE
La plupart des IDEs permettent d'importer un projet Maven.
Il est préférable de ne pas ajouter les fichiers spécifiques à l'IDE dans le dépôt git.
On modifie donc le `.gitignore` en conséquence.
