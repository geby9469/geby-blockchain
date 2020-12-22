package home.kbj.java.chapter4;

import java.util.Scanner;

/* title: n명이 참가하는 끝말잇기 게임
 * 처음단어는 "아버지"
 * n명의 참가자들은 순서대로 자신의 단어를 입력하면 된다. 끝말잇기에서 끝말이 틀린 경우 게임을 끝내고 게임에서 진 참가자를 화면에 출력
 * 핵심: 여러 개의 객체와 배열 사용을 연습하기 위함
 * WordGameApp, 선수 Player 클래스 작성
 * 실행 중에는 WordGameApp 객체 하나와 선수 숫자만큼의 Player 객체 생성
 */

/* hint
 * WordGameApp: 생성자, main(), 게임을 전체적으로 진행하는 run(): 선수 숫자 만큼의 Player 객체를 배열로 생성
 * Player 클래스: 게임 참가자의 이름 필드와 사용자로부터 단어를 입력받는 getWordFromUser()
 * 끝말잇기의 성공여부와 게임을 계속하는지를 판별하는 checkSuccess()
 */
public class WordGameApp {

	public WordGameApp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordGameApp wordGameApp = new WordGameApp();
		wordGameApp.run();
	}

	void run() {
		System.out.println("Let's start Word Chain game.");

		// personnel
		Scanner sc = new Scanner(System.in);
		System.out.print("How many people are participating in the game?>>");
		int personnel = sc.nextInt();

		// create object array
		Player[] player = new Player[personnel];
		
		// enter name
		for(int i = 0; i < personnel; i++) {
			System.out.print("Please enter participant name>>");
			String name = sc.next();
			player[i] = new Player(name);
		}
		
		String preWord = "아버지"; // start_word & pre_word
		System.out.printf("The starting word is %s \n", preWord);

		boolean game = true; // keep going game flag
		int j = 0; // control player
		while(game) {
			String postWord = player[j].getWordFromUser();
			if(player[j].checkSuccess(preWord, postWord)) {
				j++;
				preWord = postWord;
			}
			else {
				game = false;
				System.out.printf("%s lose", player[j].name);
			}
			
			// init loop
			if(j >= personnel)
				j = 0;
		}
		
		sc.close();
	}
}

class Player {
	String name;

	Player(String name) {
		this.name = name;
	}
	
	String getWordFromUser() {
		Scanner sc = new Scanner(System.in); // resource leak..
		System.out.printf("%s>> ", name);
		String word = sc.next();

		return word;
	}

	boolean checkSuccess(String preWord, String postWord) {
		int lastIndex = preWord.length()-1;
		char last = preWord.charAt(lastIndex);
		char first = postWord.charAt(0);
		
		if(last == first)
			return true;
		else
			return false;
	}
}

/* result
 * Let's start "Word Chain" game.
 * How many people are participating in the game?>>3
 * Please enter participant name>>황기태
 * The starting word is "아버지"
 * player1 name>>
 * player2 lose.
 */