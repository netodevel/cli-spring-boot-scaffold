#!/bin/bash
declare FILES=('cli' 'spring-api-kotlin-0.1.jar')
declare INSTALL_PATH='/usr/bin'

install() {
  for i in ${FILES[@]}; do
    echo "Copy '$i' to '$INSTALL_PATH'"
    sudo cp $i $INSTALL_PATH
  done
}

uninstall(){
  for i in $FILES; do
    sudo rm "$INSTALL_PATH/$i"
  done
}

case $1 in
  install)
    install
  ;;
  uninstall)
    uninstall
  ;;
  *)
cat <<-TEXT
Install script for SpringBoot Scaffold Kotlin.
This tool helps to install and uninstall the script.

usage:

  ./install.sh install    - to install the script into $INSTALL_PATH
  ./install.sh uninstall  - to uninstall the script

TEXT
esac
