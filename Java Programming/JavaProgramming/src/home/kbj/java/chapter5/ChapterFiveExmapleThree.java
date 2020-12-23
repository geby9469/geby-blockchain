package home.kbj.java.chapter5;

import java.util.Scanner;

/* title: 추상 클래스를 상속받아 서브 클래스 만들기 */
public class ChapterFiveExmapleThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Won2Dollar toDollar = new Won2Dollar(1200);
		toDollar.run();
	}

}

// defined in the example
abstract class Converter {
	abstract protected double convert(double src);
	abstract protected String getSrcString();
	abstract protected String getDestString();
	protected double ratio;
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Convert %s to %s \n", getSrcString(), getDestString());
		System.out.printf("enter the %s>> ",  getSrcString());
		double val = sc.nextDouble();
		double res = convert(val);
		System.out.printf("Conversion result: it's %.1f %s", res, getDestString());
		sc.close();
	}
}

class Won2Dollar extends Converter {
	
	public Won2Dollar(double ratio) {
		super.ratio = ratio;
	}
	
	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		return src / ratio;
	}
	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "dollars";
	}
	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "won";
	}
	
}



/* result
 * Convert won to dollar
 * enter the won>> 
 * Conversion result: it's twenty dollars
 */
