#!/bin/bash

# MariaDB Node
MARIADB=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50181 "hostname --ip-address"`
echo "export MARIADB=${MARIADB}" >> /home/mtenrero/.profile

# Redis Node
REDIS=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 59733 "hostname --ip-address"`
echo "export REDIS=${REDIS}" >> /home/mtenrero/.profile

# Mongo Node
MONGO=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50888 "hostname --ip-address"`
echo "export MONGO=${MONGO}" >> /home/mtenrero/.profile

# Webservice1 Node
WEBSERVICE1=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 5677 "hostname --ip-address"`
echo "export WEBSERVICE1=${WEBSERVICE1}" >> /home/mtenrero/.profile

# Webservice2 Node
WEBSERVICE2=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 49483 "hostname --ip-address"`
echo "export WEBSERVICE2=${WEBSERVICE2}" >> /home/mtenrero/.profile

# HAProxy Node
HAPROXY=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 60724 "hostname --ip-address"`
echo "export HAPROXY=${HAPROXY}" >> /home/mtenrero/.profile

# Iservice1 Node
ISERVICE1=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50188 "hostname --ip-address"`
echo "export ISERVICE1=${ISERVICE1}" >> /home/mtenrero/.profile

# Iservice2 Node
ISERVICE2=`sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 5999 "hostname --ip-address"`
echo "export ISERVICE2=${ISERVICE2}" >> /home/mtenrero/.profile