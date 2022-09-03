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



