package home.kbj.java.chapter4;

/* title: practice Class production */
public class ChapterFourExampleOne {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV myTV = new TV("LG", 2017, 32);	// TV(year:2017, inch:32) made in LG
		myTV.show();	// 2017 32-inch TV made by LG
	}
}

class TV {
	String brand;
	int year, inch;
	
	TV(String brand, int year, int inch) {
		this.brand = brand;
		this.year = year;
		this.inch = inch;
	}
	
	void show() {
		System.out.printf("%d %d-inch TV mad by %s", year, inch, brand);
	}
}
