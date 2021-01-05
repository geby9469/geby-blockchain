package home.kbj.java.chapter13;

import java.util.Scanner;

/* title: 타이머 스레드 */
/* condition
 * 아무 키를 입력받으면 좌표(x, y)를 400ms초 간격으로 랜덤한 위치로 이동
 * */
public class ChapterThirteenExampleTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter any key>> ");
		Scanner sc = new Scanner(System.in);
		if(sc.next() != null)
			new RandomLocationThread().start();
		sc.close();
	}

}


class RandomLocationThread extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int x = (int)(Math.random() * 10);
			int y = (int)(Math.random() * 10);
			
			System.out.printf("(%d, %d) \n", x, y);
			
			try {
				Thread.sleep(400);
			}
			catch (InterruptedException e) {
				System.out.println("[Exception] RandomLocationThread State : RUNNABLE..");
				e.printStackTrace();
			}
		}
		
	}
	
}

/* result
 * Enter any key >> go
 * (1, 1)
 * (5, 10)
 * (8, 2)
 * ...
 */