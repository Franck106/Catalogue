# al35-project1

Public AWS URL : 

http://firstcatalogue-env-1.eba-tmntubkv.eu-west-3.elasticbeanstalk.com

This project is part of TeamA's Freelancer project :
- https://github.com/Franck106/Team-A-Catalogue
- https://github.com/Franck106/Team-A-Front
- https://github.com/melapal3/Team-A-Orchestrateur
- https://github.com/pckerneis/Team-A-Messenger

## Process de résolution de ticket

Récupérer le code avec
 ```git pull```
 
Créer et checker une nouvelle branche pour la feature à développer
 
```git checkout -b CAT-[N]```
 
où [N] est le numéro du ticket (Issues) correspondant à la feature.
 
On peut alors commencer les développements.
 
A la fin des développements, on commit son travail et on le pousse sur la branche
feature distante
 
```
 git add commit ... 
```

Le message de commit doit avoir la forme "ID branche + Nom du ticket". Par exemple :
```
CAT-11 First git ticket Pierre #11
```

## Créer une pull request
```
 git push -f
```

Il faut d'abord créer la branche upstream (la commande est donnée par git).
```
git push --set-upstream origin CAT-11
```

Un lien est ensuite donné pour créer une pull request sur Github.
En validant la pull request sur Github, celle-ci est alors accessible par les collaborateurs.


## Fusionner plusieurs commits d'une branche feature en un commit sur master

TODO
