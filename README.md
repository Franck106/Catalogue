# al35-project1
process de résolution de ticket:
 git pull 
 git checkout -b APPLI-NoTicket 
 ... développement ... 
 git add commit push ... 
 git checkout master 
 git pull 
 git checkout - 
 git rebase -i master fusionner les commits en un seul avec message ([nom de la bracnhe]- libellé du ticket)*
 ouverture de vim
  résoudre les éventuels conflits (save, git add, git rebase --continue)
  pour écrire dans vim (pas besoin sauf si on veut modifier les msg commit ou fusionner les commit): taper i
  pour sortir du mode insertion: echap
  pour sauver et quitter vim, taper :wq 
 git push -f 
 si la branch n'existe pas dans le répertoire, git propose une commande pour la créer (git push origin --set-upstream....)
 copier coller cette commande et refaire git push -f 
 faire une pull request dans github
