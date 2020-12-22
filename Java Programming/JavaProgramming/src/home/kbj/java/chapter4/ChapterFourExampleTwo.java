package home.kbj.java.chapter4;

import java.util.Scanner;

/* title: 3과목의 점수를 입력받아 Grade 객체를 생성하고 성적 평균을 출력하는 main를 만들어라 */
public class ChapterFourExampleTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter 3 scores in order of math, science, english>> ");
		// input: 90 88 96
		int math = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();
		
		Grade me = new Grade(math, science, english);
		System.out.printf("The average is %.2f", me.average());
		// output: 91
		
		sc.close();
	}

}

class Grade {
	private int math, science, english;
	
	Grade(int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	double average() {
		return (math + science + english) / 3;
	}
	
}
/* result
 * Please enter 3 scores in order of math, science, English>>
 * average is 91 
 */
