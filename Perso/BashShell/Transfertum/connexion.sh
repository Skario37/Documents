#!/bin/bash

#**********************************
#CHECKING ARGUMENTS
if [[ $# -ne 1 ]]; then
  echo "Usage: $0 <machine>"
  exit 1
fi
#----------------------------------

co_dist () {
	$DIR/displayName.sh
	echo "##### Remote connection #####"
	echo ""
	echo "Connecting to $1 ..."
	xfce4-terminal --tab --command "$DIR/connectSSH.sh $1" -T "Connecting to $1" --hold
	return
}
co_l_to_dist () {
	$DIR/displayName.sh
	echo "--- Copy local files to remote ---"
        echo ""
        echo "Source path:"
        read src
        echo ""
        echo "destination path:"
        read dst
        echo ""
        echo "Connecting to $1 ..."
        xfce4-terminal --tab --command "$DIR/connectLocalToRemoteSCP.sh $1 $src $dst" -T "Connecting to $1" --hold
	return
}
co_d_to_local () {
	$DIR/displayName.sh
	echo "--- Copy remote files to local ---"
    echo ""
    echo "Source path:"
    read src
    echo ""
    echo "Destination path:"
    read dst
    echo ""
    echo "Connection to $1 ..."
    xfce4-terminal --tab --command "$DIR/connectRemoteToLocalSCP.sh $1 $src $dst" -T "Connecting to $1" --hold
	return
}

read REPLY
case "$REPLY" in
#*******************
#SSH
    1)
		echo -en "\ec"
		co_dist $1
    ;;
#******************
#SCP LOCAL TO DISTANT
    2)
        echo -en "\ec"
        co_l_to_dist $1
	;;
#******************
#SCP DISTANT TO LOCAL
    3)
        echo -en "\ec"
        co_d_to_local $1
		;;
	q)
	;;
esac
exit 0