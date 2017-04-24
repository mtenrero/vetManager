#!/bin/bash

# MariaDB Node
export MARIADB = sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50181 "hostname --ip-address"

# Redis Node
export REDIS = sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 59733 "hostname --ip-address"

# Mongo Node
export MONGO = sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50888 "hostname --ip-address"

# Webservice1 Node
export WEBSERVICE1 = sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 5677 "hostname --ip-address"

# Webservice2 Node
export WEBSERVICE2 = sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 49483 "hostname --ip-address"

# HAProxy Node
export HAPROXY = sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 60724 "hostname --ip-address"

# Iservice1 Node
export ISERVICE1 = sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 50188 "hostname --ip-address"

# Iservice2 Node
export ISERVICE2 = sshpass -p ${ssh_pass} ssh -o StrictHostKeyChecking=no vetmanager@vetmanager.cloudapp.net -p 5999 "hostname --ip-address"
