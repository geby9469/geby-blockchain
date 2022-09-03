# install quorum-blockchain
### npx quorum-dev-quickstart
### npx quorum-genesis-tool --consensus ibft --chainID 1337 --blockperiod 5 --requestTimeout 10 --epochLength 30000 --difficulty 1 --gasLimit '0xFFFFFF' --coinbase '0x0000000000000000000000000000000000000000' --validators 5 --members 0 --bootnodes 0 --outputPath 'artifacts'

# create directory
# cd ~
# mkdir -p ~/IBFT-Network/artifacts ~/IBFT-Network/Node-0/data/keystore ~/IBFT-Network/Node-1/data/keystore ~/IBFT-Network/Node-2/data/keystore ~/IBFT-Network/Node-3/data/keystore ~/IBFT-Network/Node-4/data/keystore

# move artifacts
# mv ~/quorum-test-network/artifacts/2022-*/* ~/IBFT-Network/artifacts
# cd ~/IBFT-Network
# rm -rf ~/quorum-test-network/artifacts

# copy static nodes file and node keys to each node
# cd ~/quorum-test-network/artifacts/2022-*
# cd validator0; cp nodekey* address ~/IBFT-Network/Node-0/data
# cd ../validator1; cp nodekey* address ~/IBFT-Network/Node-1/data
# cd ../validator2; cp nodekey* address ~/IBFT-Network/Node-2/data
# cd ../validator3; cp nodekey* address ~/IBFT-Network/Node-3/data
# cd ../validator4; cp nodekey* address ~/IBFT-Network/Node-4/data
# 
# cd ../validator0; cp account* ~/IBFT-Network/Node-0/data/keystore
# cd ../validator1; cp account* ~/IBFT-Network/Node-1/data/keystore
# cd ../validator2; cp account* ~/IBFT-Network/Node-2/data/keystore
# cd ../validator3; cp account* ~/IBFT-Network/Node-3/data/keystore
# cd ../validator4; cp account* ~/IBFT-Network/Node-4/data/keystore

# Initialized nodes in each node directory
# geth --datadir data init ~/IBFT-Network/artifacts/goQuorum/genesis.json

# Start node 0
# cd ~/IBFT-Network/Node-0
# export ADDRESS=$(grep -o '"address": *"[^"]*"' ./data/keystore/accountKeystore | grep -o '"[^"]*"$' | sed 's/"//g')
# export PRIVATE_CONFIG=ignore
# Node0: geth --datadir data --networkid 1337 --nodiscover --verbosity 5 --syncmode full --mine --miner.threads 1 --miner.gasprice 0 --http --http.addr 0.0.0.0 --http.port 22000 --http.corsdomain "*" --http.vhosts "*" --ws --ws.addr 0.0.0.0 --ws.port 32000 --ws.origins "*" --http.api admin,eth,debug,miner,net,txpool,personal,web3,istanbul --ws.api admin,eth,debug,miner,net,txpool,personal,web3,istanbul --unlock ${ADDRESS} --allow-insecure-unlock --password ./data/keystore/accountPassword --port 30300 --authrpc.addr 0.0.0.0 --authrpc.vhosts "*"
# Node1: geth --datadir data --networkid 1337 --nodiscover --verbosity 5 --syncmode full --mine --miner.threads 1 --miner.gasprice 0 --http --http.addr 0.0.0.0 --http.port 22001 --http.corsdomain "*" --http.vhosts "*" --ws --ws.addr 0.0.0.0 --ws.port 32001 --ws.origins "*" --http.api admin,eth,debug,miner,net,txpool,personal,web3,istanbul --ws.api admin,eth,debug,miner,net,txpool,personal,web3,istanbul --unlock ${ADDRESS} --allow-insecure-unlock --password ./data/keystore/accountPassword --port 30301 --authrpc.port 8552 --authrpc.addr 0.0.0.0 --authrpc.vhosts "*"
# Start node 1
# cd ~/IBFT-Network/Node-1
# export ADDRESS=$(grep -o '"address": *"[^"]*"' ./data/keystore/accountKeystore | grep -o '"[^"]*"$' | sed 's/"//g')
# export PRIVATE_CONFIG=ignore
# geth --datadir data --networkid 1337 --nodiscover --verbosity 5 --syncmode full --mine --miner.threads 1 --miner.gasprice 0 --http --http.addr 0.0.0.0 --http.port 22001 --http.corsdomain "*" --http.vhosts "*" --ws --ws.addr 0.0.0.0 --ws.port 32001 --ws.origins "*" --http.api admin,eth,debug,miner,net,txpool,personal,web3,istanbul --ws.api admin,eth,debug,miner,net,txpool,personal,web3,istanbul --unlock ${ADDRESS} --allow-insecure-unlock --password ./data/keystore/accountPassword --port 30301

# Attach to node 0
# geth attach ~/IBFT-Network/Node-0/data/geth.ipc


