#!/bin/bash

#**********************************
#Verif arguments
if [[ $# -ne 1 ]]; then
  echo "Usage: $0 <dataFile>"
  exit 1
fi
#----------------------------------

#**********************************
#FUNCTIONS
delete_machine () {
	sed -i "$REPLY d" $1
	return
}
#----------------------------------

nbligne=`cat $1 | wc -l`
read REPLY
case "$REPLY" in
	q)
	;;
 	*)
		if [[ $REPLY -le $nbligne ]]; then
			delete_machine $1
		fi
	;;
esac
exit 0