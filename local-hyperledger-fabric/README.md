# Hyperledger Fabric 가상환경 구성


## Version
### Host
* Windows: 10 64bit
* Vagrant: 2.2.19 (latest: 2.3.4)

### Guest
* Ubuntu: 18.04.6 LTS
* docker: 20.10.22
* docker-compose: 1.22.0
* gradle: 4.4.1
* go: 1.11.1
* java: openjdk 1.8.0_352
* node: 8.17.0
* npm: 5.6.0
* python: 2.7.17
* Hyperledger Fabric: 2.4.7
* Hyperledger Composer: 0.20.9

## Installation
```console
cd $GOPATH/src
curl -sSL http://bit.ly/2ysbOFE | sudo bash -s
```

## Start Fabric
```console
cd fabric-samples/test-network
./network.sh up
```

## Start Composer
```console
composer-playground
```

## Reference
1. [Prerequisties](https://hyperledger-fabric.readthedocs.io/en/latest/prereqs.html)
2. [Using the Fabric test network](https://hyperledger-fabric.readthedocs.io/en/latest/test_network.html)
3. Deprecated[Composer github](https://github.com/hyperledger/composer)
