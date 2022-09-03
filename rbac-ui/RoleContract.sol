// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

/* 
 * ROLE을 기록하고 관리하는 스마트 컨트랙트
 */
contract RoleContract {
   event changeRole(address, string);
   event selectRole(address, string);
   event deletedRole(address);

   mapping (address => string) roleMap;

   modifier checkAddr() {
     require(msg.sender == 0x096616a0E8E93e8245274B035E8D33f6951A3089, "Not administrator");
     _;
   }

   function setRole(address _addr, string memory _role) public checkAddr() {
     roleMap[_addr] = _role;
     emit changeRole(_addr, _role);
   }

   function deleteRole(address _addr) public checkAddr() {
     delete roleMap[_addr];
     emit deletedRole(_addr);
   }

   function getRole(address _addr) external returns (string memory) {
     emit selectRole(_addr, roleMap[_addr]);
     return roleMap[_addr];
   }
}

/*
 * 역할에 관한 함수 실행 스마트 컨트랙트
 */
contract FunctionContract {
  event verifiedExecution(address, string);

  function transferEther(address payable _to, address _contractAddr) public payable {
    (bool success1, bytes memory result) = _contractAddr.call(
	  abi.encodeWithSignature("getRole(address)", msg.sender));
    require(success1, "failed to external function");
    string memory role = abi.decode(result, (string));
    require(keccak256(bytes(role)) == keccak256(bytes("role1")), "Not permitted");
    emit verifiedExecution(msg.sender, role);

    // This code needs to verify whether permitted user or not
    (bool success, ) = _to.call{value : msg.value}("");
    require(success, "failed to transfer ether");
  }

}

