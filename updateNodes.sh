#!/bin/bash

# Restore previous backup needs yes | cp -rf $HOME/.profile $HOME/.profile.old to be runned for 1st time
yes | cp -rf $HOME/.profile.old $HOME/.profile

# MariaDB Node
MARIADB=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50181 "hostname --ip-address"`
echo "export MARIADB=${MARIADB}" >> $HOME/.profile

# Redis Node
REDIS=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 59733 "hostname --ip-address"` >> $HOME/.profile
echo "export REDIS=${REDIS}" >> $HOME/.profile

# Mongo Node
MONGO=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50888 "hostname --ip-address"` >> $HOME/.profile
echo "export MONGO=${MONGO}" >> $HOME/.profile

# Webservice1 Node
WEBSERVICE1=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 5677 "hostname --ip-address"` >> $HOME/.profile
echo "export WEBSERVICE1=${WEBSERVICE1}" >> $HOME/.profile

# Webservice2 Node
WEBSERVICE2=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 49483 "hostname --ip-address"` >> $HOME/.profile
echo "export WEBSERVICE2=${WEBSERVICE2}" >> $HOME/.profile

# HAProxy Node
HAPROXY=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 60724 "hostname --ip-address"` >> $HOME/.profile
echo "export HAPROXY=${HAPROXY}" >> $HOME/.profile

# Iservice1 Node
ISERVICE1=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50188 "hostname --ip-address"` >> $HOME/.profile
echo "export ISERVICE1=${ISERVICE1}" >> $HOME/.profile

# Iservice2 Node
ISERVICE2=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 5999 "hostname --ip-address"` >> $HOME/.profile
echo "export ISERVICE2=${ISERVICE2}" >> $HOME/.profile
