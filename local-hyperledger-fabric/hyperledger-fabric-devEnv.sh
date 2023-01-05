#!/bin/sh
sudo apt-get update -y
sudo apt-get upgrade -y
sudo apt-get install systemd

# ssh
sed -i -e 's/PasswordAuthentication no/PasswordAuthentication yes/g' /etc/ssh/sshd_config

# network tool
sudo apt-get install net-tools

# editor
sudo apt-get install vim

# public-key
sudo apt-key adv --keyserver keyserver.ubuntu.com --recv 0EBFCD88

# git
sudo apt-get install git

# cURL
sudo apt-get install curl

# Docker
sudo usermod -aG docker $USER
sudo curl -L "https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

# JQ
sudo apt-get -y install jq

# Go
sudo add-apt-repository ppa:gophers/archive
sudo apt-get update
sudo apt-get install golang-1.11.1-go
# export GOPATH=$HOME/go
# export PATH=$PATH:$GOROOT/bin:$GOPATH/bin
mkdir -p $HOME/go/{src,pkg,bin}

# python
sudo apt install -y python

# node.js, npm
curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.33.2/install.sh | sudo bash -
sudo chown -R vagrant:vagrant .nvm
nvm install 8
nvm use 8
npm install npm@5.6.0 -g

# java
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt update
sudo apt install -y openjdk-8-jdk openjdk-8-jre

# Gradle
sudo apt install -y gradle

# Hyperledger fabric
cd $GOPATH
curl -sSL https://bit.ly/2ysbOFE | sudo bash -s

# Hyperledger Composer
curl -O https://hyperledger.github.io/composer/latest/prereqs-ubuntu.sh
chmod u+x prereqs-ubuntu.sh
npm install -g composer-cli@0.20 # command-line interface s/w
npm install -g composer-rest-server@0.20 # connect outer-application
npm install -g generator-hyperledger-composer@0.20 # automated code generation
npm install -g yo # Yeoman plugin
npm install -g composer-playground # Playground: GUI tool

# .bashrc ENV
# export FABRIC_HOME=$GOPATH/src/fabric-samples
# export PATH=$FABRIC_HOME/bin:$PATH
# export FABRIC_TESTNET_HOME=$FABRIC_HOME/test-network
# export FABRIC_CFG_PATH=$FABRIC_HOME/config
# 
# 
# export CORE_PEER_TLS_ENABLED=true
# export CORE_PEER_LOCALMSPID="Org1MSP"
# export CORE_PEER_TLS_ROOTCERT_FILE=$FABRIC_TESTNET_HOME/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/ca.crt
# export CORE_PEER_MSPCONFIGPATH=$FABRIC_TESTNET_HOME/organizations/peerOrganizations/org1.example.com/users/Admin@org1.example.com/msp
# export CORE_PEER_ADDRESS=localhost:7051