package home.kbj.java.chapter3;

import java.util.Scanner;

public class ChapterThreeEnd {
	/* 컴퓨터와 독자 사이의 가위 바위 보 게임을 만들어보자. 독자부터 먼저 시작한다.
	 * 독자가 가위 바위 보 중 하나를 입력하고 <Enter>키를 치면,
	 * 프로그램은 가위 바위 보 중에서 랜덤하게 하나를 선택하고 컴퓨터가 낸 것으로 한다.
	 * 독자가 입력한 값과 랜덤하게 선택한 값을 비교하여 누가 이겼는지 판단한다.
	 * 독자가 가위 바위 보 대신 "그만"을 입력하면 게임을 끝낸다.
	 */
	public static void main(String[] args) {
		// create object
		ChapterThreeEnd chapterThreeEnd = new ChapterThreeEnd();
		
		// input
		String computer[] = {"scissors", "rock", "paper"}; // computer array
		
		// function: rock scissors paper game
		boolean result = chapterThreeEnd.gameRockScissorsPaper(computer);
		if(!result)
			System.out.println("exit game");
		 
	}
	
	private boolean gameRockScissorsPaper(String[] computer) {
		boolean gameFlag = true;	// Whether or not to play the game
		
		System.out.println("let's start rock scissors paper game with computer.");
		Scanner sc = new Scanner(System.in);

		// game start
		while(gameFlag) {
			boolean userWin = false;
			boolean computerWin = false;
			
			System.out.print("rock scissors paper!>> ");
			String user = sc.next();
			
			// computer random variable
			int n = (int)(Math.random() * computer.length);
			
			// compare computer with user
			switch (computer[n]) {
			case "rock":
				// user win - lose - draw
				if("paper".equals(user)) {
					userWin = true; computerWin = false;
				}
				else if("scissors".equals(user)) {
					userWin = false; computerWin = true;
				}
				else if("rock".equals(user)) {
					userWin = true; computerWin = true;
				}
				else
					gameFlag = false;
				break;
			case "scissors":
				if("rock".equals(user)){
					userWin = true; computerWin = false;
				}
				else if("paper".equals(user)){
					userWin = false; computerWin = true;
				}
				else if("scissors".equals(user)) {
					userWin = true; computerWin = true;
				}
				else
					gameFlag = false;
				break;
			case "paper":
				if("scissors".equals(user)){
					userWin = true; computerWin = false;
				}
				else if("rock".equals(user)){
					userWin = false; computerWin = true;
				}
				else if("paper".equals(user)) {
					userWin = true; computerWin = true;
				}
				else
					gameFlag = false;
				break;	
			default:
				System.out.println("This is no rock, scissors and paper in computer \n");
				gameFlag = false;
				break;
			}
			
			// print result
			if(userWin && !computerWin)
				System.out.printf("user = %s, computer = %s, user win \n", user, computer[n]);
			if(!userWin && computerWin)
				System.out.printf("user = %s, computer = %s, computer win \n", user, computer[n]);
			if(userWin && computerWin)
				System.out.printf("user = %s, computer = %s, draw \n", user, computer[n]);
		}
		
		return gameFlag;
	}
	
	/* Scenario
	 * let's start rock scissors paper game with computer.
	 * rock scissors paper!>> rock
	 * user = "", computer = "", "" win, lose, draw
	 * exit game.
	 */
	
}
