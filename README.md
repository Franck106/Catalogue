# al35-project1
process de résolution de ticket:
 git pull 
 git checkout -b APPLI-NoTicket 
 ... développement ... 
 git add commit push ... 
 git checkout master 
 git pull 
 git checkout - 
 git rebase -i master fusionner les commits en un seul avec message ([nom de la bracnhe]- libellé du ticket) git push -f faire une pull request dans github