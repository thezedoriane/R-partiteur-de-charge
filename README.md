# Repartiteur-de-charge
Nous avons choisi pour ce projet le sujet de répartiteur de charge.
Pour ceci nous avons décidé de faire notre code en Java et nous avons utilisé Java RMI pour pouvoir gérer les entités aiguilleur, machine et client.

Pour lancer le programme:

Si il n'existe pas encore de fichier à traiter il faut lancer le code CreerFichier, qui crée un fichier avec un nom, un nombre de ligne et un texte qui seront demandé par le pc et à remplir manuellement dans la console lorsque ces informations seront demandées. Attention, lors de lacréation du fichier, il sera écrit avec seulement un mot par ligne les espaces sont comptés comme des retours à la ligne. Pour ppuvoir écrire plusieurs mots par ligne il faudra faire appel à la fonction écriture comme l'explique la suite.

L'aiguilleur est enregistré dans un registre lancé chacun avec Registry et RMIAiguilleur (en respectant cet ordre). 
Nous créons ensuite une ou plusieurs machines en lancant une ou plusieurs fois RMIMachine. 
Et finalement nous créons des clients avec des requêtes pour l'aiguilleur avec RMIClient.

Pour ce projet nous avons fait l'hypothèse que la distribution des tâches aux machines se fait selon un cycle. Ainsi que les machines ont accès aux mêmes fichiers.

Attention pour reprendre ce code les fichiers ont été mis dans un package du nom de repartiteur.
