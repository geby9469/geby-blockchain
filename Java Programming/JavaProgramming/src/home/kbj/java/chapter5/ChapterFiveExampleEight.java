package home.kbj.java.chapter5;

/* title: 서브 클래스 생성자 및 메소드 작성, super 활용 */
/* condition 
 * 양수의 공간에서만 점을 나타냄
 */

public class ChapterFiveExampleEight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PositivePoint p = new PositivePoint();
		p.move(10, 10);
		System.out.println("it is %s", p.toString());
		
		p.move(-5, 5);
		System.out.println("it is %s", p.toString());
		
		PositivePoint p2 = new PositivePoint(-10, -10);
		System.out.println("it is %s", p2.toString());
		
	}

}

// defined in the example
class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/* result
 * Is the point of (10,10)
 */
