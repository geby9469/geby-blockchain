package home.kbj.java.chapter13;

import java.util.Scanner;

/* title: 간단한 스레드 만들기 */
/* condition
 * 실행되자마자 1~10까지 콘솔 창에 출혁한 뒤 종료하는 스레드를 Runnable 인터페이스를 이용
 * main 메소드에서는 사용자가 아무 문자나 입력하고 enter치면 스레드 객체를 생성하고 실행
 * */
public class ChapterThirteenExampleOne{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		PrintThread pt = new PrintThread();
		System.out.print("Enter any key>> ");
		if(sc.next() != null)
			pt.run();
		System.out.println("Thread termination");
		sc.close();
	}
}

class PrintThread implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Start thread execution");
		for(int i = 1; i <= 10; i++)
			System.out.printf("%d ", i);
		System.out.println();
	}
}

/* result
 * 아무 키나 입력>> go		Enter any key
 * 스레드 실행 시작			Start thread execution
 * 1 2 ... 10
 * 스레드 종료				Thread termination
 * */
