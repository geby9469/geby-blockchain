package home.kbj.java.chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/* title: 파일 읽기, 벡터 다루기 (행맨 게임) */
/* condition
 * words.txt파일 읽고 영어 단어 하나를 선택
 * 몇 개의 글자를 숨긴 다음 화면에 출력 (여기서는 2개)
 * 한 단어에 대해 5번 틀리면 프로그램 종료
 */
public class HangManGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HangMan hangMan = new HangMan();
		hangMan.execute();
		
	}

}

class HangMan {
	private Vector<String> words;
	private File file;
	private String word;
	private StringBuilder hiddenWord;
	private int tryCount;
	
	
	HangMan() {
		String path = "words.txt";
		file = new File(path.replace("\\", File.separator));
		words = new Vector<>((int)file.length());
		tryCount = 0;
	}

	void execute() {
		read();
		select();
		
		System.out.println("The hangman game starts now.");
		boolean isNext = true;
		while(isNext) {
			enter();
			
			// success
			if(tryCount < 5 && hiddenWord.toString().equals(word)) {
				isNext = isNext();
			}
			
			// fail
			if(tryCount >= 5 && !hiddenWord.toString().equals(word)) {
				System.out.println("Failed 5 times");
				isNext = isNext();
			}
		}
	}
	
	// read file
	void read() {
		try (
				BufferedReader br = new BufferedReader(new FileReader(file));
		) {
			String line;
			while((line = br.readLine()) != null) {
				words.add(line);
			}
		}
		catch (IOException e) {
			System.out.println("Failed to read");
			e.printStackTrace();
		}
	}
	
	// select English words
	void select() {
		int random = (int)(Math.random() * words.size());
		word = words.get(random);

		// remove redundancy
		int[] hiddenIndex = new int[2];
		for(int i = 0; i < hiddenIndex.length; i++) {
			hiddenIndex[i] = (int)(Math.random() * word.length());
			
			for(int j = 0; j < i; j++) {
				if(hiddenIndex[i] == hiddenIndex[j]) {
					i--;
					break;
				}
			}
		}
		// hidden word transform
		hiddenWord = new StringBuilder(word);
		for(int i = 0; i < hiddenIndex.length; i++) {
			hiddenWord.setCharAt(hiddenIndex[i], '-');
		}
	}

	// enter user
	@SuppressWarnings("resource")
	int enter() {
		System.out.println(hiddenWord);

		System.out.print(">>");
		Scanner sc = new Scanner(System.in);
		char input = sc.next().charAt(0);

		// convert
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == input) {
				hiddenWord.setCharAt(i, input);
			}
		}
		
		return tryCount++;
	}
	
	// Whether to continue the game
	@SuppressWarnings("resource")
	boolean isNext() {
		System.out.println(word);
		Scanner sc = new Scanner(System.in);
		System.out.print("Next(y/n)?");
		if("n".equals(sc.next()))
			return false;
		else {
			tryCount = 0;
			select();
			return true;
		}
	}

}

/* result
 * 지금부터 행맨 게임을 시작합니다.	The hangman game starts now.
 * o-colog-
 * >>y
 * o-cology
 * >>n
 * oncology
 * Next(y/n)?y
 * b-ckpl-ne
 * >>a
 * backplane
 * Next(y/n)?y
 * 5번 실패 하였습니다.	Failed 5 times.
 * nodular
 * Next(y/n)?
 */