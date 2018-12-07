#!/bin/bash

echo -en "\ec" # Clean display

#***********************************
#Verif arguments
if [[ $# -ne 0 ]]; then
  echo "Usage: $0 <no arg>"
  exit
fi
#-----------------------------------

#***********************************
# Initialisation Variables
SOURCE=${BASH_SOURCE[0]}
while [ -h $SOURCE ]; do
	DIR=$( cd -P $( dirname $SOURCE ) && pwd )
	SOURCE=$(readlink $SOURCE)
	[[ $SOURCE != /* ]] && SOURCE=$DIR/$SOURCE
done
DIR=$( cd -P $( dirname $SOURCE ) && pwd )
transfertumDirectory=".transfertum"
FILES=(addMachine.sh connectLocalToRemoteSCP.sh connectRemoteToLocalSCP.sh connectSSH.sh connexion.sh deleteMachine.sh displayName.sh Transfertum)
error=""
#-----------------------------------

#***********************************
#ERRORS
get_error() {
	if [[ $# -eq 2 ]]; then
		if $1 $2 2>/dev/null; then
		    echo " ... OK"
		else
		    echo ""
		    echo "FAILED $1 $HOME/$2"
		    echo "Exiting installation."
		    exit 1
		fi
	else
		if [[ $# -eq 3 ]]; then
			if $1 $2 $3 2>/dev/null; then
			    echo " ... OK"
			else
			    echo ""
			    echo "FAILED $1 $2 $3"
			    echo "Exiting installation."
			    exit 1
			fi
		fi
	fi 
}
#-----------------------------------

#***********************************
#INSTALLATION
#Entraîne la fin du programme si erreur
echo "Installation in progress."
cd $HOME
if [ -d $transfertumDirectory ]; then
    echo "The directory already exist."
    echo "Do you want to erase it? (yes/no)"
    read REPLY
    case "$REPLY" in
    	"y")
			rm -r $transfertumDirectory
			cd $HOME/bin/
			unlink Transfertum 2>/dev/null
			echo "Uninstallation successful."
		;;
    	"yes")
			rm -r $transfertumDirectory
			cd $HOME/bin/
			unlink Transfertum 2>/dev/null
			echo "Uninstallation successful."
    	;;
    	"n")
			echo "Exiting uninstallation."
		;;
		"no")
			echo "Exiting uninstallation"
		;;
    esac
else
    echo -n "Creating directory: $HOME/$transfertumDirectory"
    get_error "mkdir" $transfertumDirectory
	for((idx=$((${#FILES[@]}-1));idx>=0;idx--))
	do
		file="${FILES[${idx}]}"
		echo -n "Copying files: $file"
		get_error "cp" "$DIR/$file" "$HOME/$transfertumDirectory"
	done
	if [[ ! -d $HOME/bin ]]; then
		mkdir $HOME/bin/
		echo "export PATH=$PATH:$HOME/bin/" >> $HOME/.bashrc
	fi
	cd $HOME/bin/
	ln -s $HOME/$transfertumDirectory/Transfertum
	echo "Installation successful."
fi
#-----------------------------------
