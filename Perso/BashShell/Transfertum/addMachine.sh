#!/bin/bash

#**********************************
#CHECKING ARGUMENTS
if [[ $# -ne 1 ]]; then
  echo "Usage: $0 <dataFile>"
  exit 1
fi
#----------------------------------

echo "--- Add machine ---"
echo ""
echo "Machine name:"
    read user
echo ""
    echo "Machine adress:"
    read machine
echo ""

if [[ "$user" == "q" || "$user" == "-" || "$user" == "+" || "$machine" == "q" || "$machine" == "-" || "$machine" == "+" ]]; then
	echo "This name is unavailable!"
	exit 2
fi

echo $machine $user>>$1
exit 0