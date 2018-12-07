#!/bin/bash

#**********************************
#CHECKING ARGUMENTS
if [[ $# -ne 3 ]]; then
  echo "Usage: $0 <machine> <src> <dst>"
  exit 1
fi
#----------------------------------

echo "Trying scp..." && scp $1:$2 $3
if [[ $? -ne 0 ]]; then
	echo "Trying recursive scp..." && scp -r $1:$2 $3 || echo "Connection failed."
fi

exit 0