'use strict';

const administratorAddress = 'administrator-public-address';
const userAddress = 'administrator-private-address';

window.addEventListener('load', () => {
    // accounts
    let accounts;
    
    // connect MetaMask
    const enableMetaMask = async () => {
        accounts = await window.ethereum.request({ method: 'eth_requestAccounts' })
            .catch((err) => {
                console.error(err.code); 
            });
        whichType(accounts[0]);
    }
    enableMetaMask();

    // update MetaMask account
    const handleAccountsChanged = (acc) => {
        accounts = acc;
        if (accounts && accounts.length > 0) {
            window.location.reload();
        } else {
            swal("It wasn't updated");
            return;
        }
    }
    if (window.ethereum) {
        window.ethereum.on('accountsChanged', handleAccountsChanged);
    } else { 
        swal("Please install MetaMask");
        return;
    }
    
    
});

/* Header */
const adminBtn = document.querySelector('.admin-btn');
adminBtn.addEventListener('click', (e) => {
    e.preventDefault();
    document.querySelector('.admin-wallet').scrollIntoView(true);
});
const userBtn = document.querySelector('.user-btn');
userBtn.addEventListener('click', (e) => {
    e.preventDefault();
    document.querySelector('.user-wallet').scrollIntoView(true);
});

/* common function */
// whether admin or user?
const whichType = function(account) {
    if(isAdministrator(account)) {
        const adminAddr = document.querySelector('#admin-address');
        adminAddr.value = account;
        const adminWallet = document.querySelector('.admin-wallet');
        adminWallet.scrollIntoView(true);
    }
    if(isUser(account)) {
        const userAddr = document.querySelector('#user-user-address');
        userAddr.value = account;
        userAddr.scrollIntoView(true);
    }
}

/* Administrator wallet */
const isAdministrator = function (account) {
    if(account === administratorAddress) {
        return true;
    }
    return false;
}
// add button
const addButton = document.querySelector('.add-btn');
addButton.addEventListener('click', (e) => {
    e.preventDefault();
    const adminAddr = document.querySelector('#admin-address').value;
    if(!adminAddr) {
        swal('Please choose admin address in MetaMask.');
        return;
    }
    const userAddr = document.querySelector('#admin-user-address').value;
    if(!userAddr) {
        swal('Please input user address.');
        return;
    }
    const userRole = document.querySelector('#admin-user-role').value;
    if(!userRole) {
        swal('Please input user role.');
        return;
    }
});
// delete button
const deleteButton = document.querySelector('.delete-btn');
deleteButton.addEventListener('click', (e) => {
    e.preventDefault();
    const adminAddr = document.querySelector('#admin-address').value;
    if(!adminAddr) {
        swal('Please choose admin address in MetaMask.');
        return;
    }
    const userAddr = document.querySelector('#admin-user-address').value;
    if(!userAddr) {
        swal('Please input user address.');
        return;
    }
});


/* User wallet */
const isUser = function (account) {
    if(account === userAddress) {
        return true;
    }
    return false;
}
// inquiry balance button
const getBalanceButton = document.querySelector('.get-balance-btn');
getBalanceButton.addEventListener('click', (e) => {
    e.preventDefault();
    const userAddr = document.querySelector('#user-user-address').value;
    if(!userAddr) {
        swal('Please choose user address in MetaMask.');
        return;
    }
    getBalance(userAddr);
});
const getBalance = async (account) => {
    let balance = await window.ethereum.request({ method: 'eth_getBalance',
        params: [ account, 'latest' ]
    }).catch((err)  => {
        console.error(err);
    });
    balance = parseInt(balance) / Math.pow(10, 18);
    const userBalanceEl = document.querySelector('#user-user-balance');
    userBalanceEl.value = balance;
    userBalanceEl.scrollIntoView(true);
}
// send button
const sendButton = document.querySelector('.send-ether-btn');
sendButton.addEventListener('click', function(event) {
    event.preventDefault();
    const userAddr = document.querySelector('#user-user-address').value;
    if(!userAddr) {
        swal('Please choose user address in MetaMask.');
        return;
    }
    const remittanceAmount = document.querySelector('#user-remittance-amount').value;
    if(!remittanceAmount) {
        swal('Please input remittance amount.');
        return;
    }
});