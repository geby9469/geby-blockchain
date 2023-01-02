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

# .bashrc
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