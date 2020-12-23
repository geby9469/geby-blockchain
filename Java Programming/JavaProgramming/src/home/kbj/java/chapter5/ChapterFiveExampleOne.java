package home.kbj.java.chapter5;

/* title: 서브 클래스 만들기 */
public class ChapterFiveExampleOne {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorTV myTv = new ColorTV(32, 1024);
		myTv.printProperty(); 
	}

}

// defined class in the example
class TV {
	private int size;
	
	public TV(int size) {
		this.size = size;
	}
	
	protected int getSize() {
		return size;
	}
}

class ColorTV extends TV {
	private int color;
	
	public ColorTV(int inch, int color) {
		super(inch);
		this.color = color;
	}
	
	void printProperty() {
		System.out.printf("%d inch %d color", super.getSize(), color);
	}
}

/* result
* 32 inch 1024 color
*/