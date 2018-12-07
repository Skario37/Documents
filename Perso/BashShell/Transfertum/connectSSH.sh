#!/bin/bash

#**********************************
#CHECKING ARGUMENTS
if [[ $# -ne 1 ]]; then
  echo "Usage: $0 <machine>"
  exit 1
fi
#----------------------------------

echo "Trying ssh..." && ssh $1 || echo "Connection failed."
exit 0