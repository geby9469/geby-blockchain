# GoQuorum 가상환경 구성
## Version
### Host
Windows: 10 64bit
Vagrant: 2.2.19 (latest: 2.3.0)

### Guest
Ubuntu: 18.04.6 LTS
geth: 1.10.23-stable
solc: 0.8.16+commit.07a7930e.Linux.g++
Truffle v5.5.28 (core: 5.5.28)
Ganache v7.4.0
Solidity v0.5.16 (solc-js)
Node v16.17.0
Web3.js v1.7.4
npm: 8.15.0
nvm: 0.39.1

## Installation
```console
cd $VAGRANT_HOME
vagrant up
```

## ssh(putty)
SSH를 이용하여 접속

## Start
```console
npx quorum-dev-quickstart
```

## Reference

1. [GoQuorum Developer Quickstart](https://consensys.net/docs/goquorum//en/latest/tutorials/quorum-dev-quickstart/#run-quorum-developer-quickstart)
