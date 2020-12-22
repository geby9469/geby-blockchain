package home.kbj.java.chapter4;

import java.util.Scanner;

/* title: 3개의 Circle 객체 배열을 만들고 x, y, radius 값을 읽어 3개의 Circle 객체를 만들고 show()를 이용하여 이들을 모두 출력 
 */
public class ChapterFourExampleFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// declare object array
		Circle[] circle = new Circle[2];
		
		// enter
		for(int i = 0; i < circle.length; i++) {
			System.out.print("x, y, radius >> ");
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			int radius = sc.nextInt();
			circle[i] = new Circle(x, y, radius);
		}
		// print
		for(int j = 0; j < circle.length; j++)
			circle[j].show();
		
		sc.close();
		
	}

}

class Circle {
	private double x, y;
	private int radius;
	
	Circle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	void show() {
		System.out.printf("(%.1f, %.1f) %d \n", x, y, radius);
	}
}
/* result
 * x, y, radius >> 3.0 3.0 5
 * x, y, radius >> 2.5 2.7 6
 * x, y, radius >> 5.0 2.0 4
 * (3.0, 3.0) 5
 * (2.5, 2.7) 6
 * (5.0, 2.0) 4
 */
