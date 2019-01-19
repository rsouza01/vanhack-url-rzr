#!/usr/bin/env bash
#
# run-image.sh - Build and push the docker image to dockerhub.
#
# Author: 	Rodrigo Alvares de Souza (rsouza01@gmail.com)
#
#
# IMPORTANT:
# Do not forget to enable docker
# Either by 
# *	adding your user to docker group or 
# * by running 'sudo chmod 777 /var/run/docker.sock'
#
# History:
# Version 0.1: 2019/01/16 (rsouza) - First version
#


_HEADER="[INFO] ========================================================================"
_USE_MESSAGE="
Usage: $(basename "$0") [OPTIONS]
OPTIONS:
  -h, --help            Show this help screen and exits.
  -V, --version         Show program version and exits.
"
_VERSION=$(grep '^# Version ' "$0" | tail -1 | cut -d : -f 1 | tr -d \#)

clear
echo $_HEADER
echo -n "[INFO]" $(basename "$0")
echo "${_VERSION}"
echo $_HEADER

#Command line arguments
case $1 in

		-h | --help)
			echo "$_USE_MESSAGE"
			exit 0
		;;

		-V | --version)
			echo -n $(basename "$0")
            echo " ${_VERSION}"
			exit 0
		;;
esac

echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO] Importing settings."
echo "[INFO] ------------------------------------------------------------------------"

source ./env.sh

echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO] Running $ORG_NAME/$SERVER_NAME:$IMG_TAG."
echo "[INFO] ------------------------------------------------------------------------"

#docker run --rm --name $SERVER_NAME --network=$NETWORK -p $PORT_HOST:$PORT_CONTAINER $ORG_NAME/$SERVER_NAME:$IMG_TAG
docker run --rm --name $SERVER_NAME --env-file $ENV_FILE -p $PORT_HOST:$PORT_CONTAINER $ORG_NAME/$SERVER_NAME:$IMG_TAG

echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO] Done!"
echo "[INFO] ------------------------------------------------------------------------"
