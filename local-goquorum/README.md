# GoQuorum 가상환경 구성
## Version
### Host
Windows: 10 64bit&nbsp;
Vagrant: 2.2.19 (latest: 2.3.0)

### Guest
Ubuntu: 18.04.6 LTS&nbsp;
geth: 1.10.23-stable&nbsp;
solc: 0.8.16+commit.07a7930e.Linux.g++&nbsp;
Truffle v5.5.28 (core: 5.5.28)&nbsp;
Ganache v7.4.0&nbsp;
Solidity v0.5.16 (solc-js)&nbsp;
Node v16.17.0&nbsp;
Web3.js v1.7.4&nbsp;
npm: 8.15.0&nbsp;
nvm: 0.39.1&nbsp;

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
