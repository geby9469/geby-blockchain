package home.kbj.java.chapter7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/* title: Vector<Integer> 연습 */
/* condition: -1이 입력될 때까지 양의 정수를 입력받아 벡터에 저장하고 벡터를 검색하여 가장 큰 수를 출력 */
public class ChapterSevenExampleOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumNumber maximumNumber = new MaximumNumber();
		System.out.printf("The largest number is %d", maximumNumber.enterInteger());
		
	}

}

class MaximumNumber {
	
	public MaximumNumber() {
		// TODO Auto-generated constructor stub
	}
	
	int enterInteger() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Integer(until -1 is entered)>> ");
		String line = sc.nextLine();
		String[] lines = line.split(" ");
		// String -> Integer
		int[] linesConversion = Arrays.asList(lines).stream().mapToInt(Integer::parseInt).toArray();
		
		Vector<Integer> v = new Vector<>();
		for(int i = 0; i < linesConversion.length; i++) {
			if(linesConversion[i] == -1)
				break;
			else
				v.add(linesConversion[i]); // auto boxing
		}
			
		
		// retrieve
		int maximumNumber = 0;
		if(!v.isEmpty()) {
			for(int i = 0; i < v.size(); i++) {
				if(v.get(i) > maximumNumber)
					maximumNumber = v.get(i);
			}
		}
		
		sc.close();
		return maximumNumber;
	}
	
}

/* result 
 * 정수(-1이 입력될 때까지)>> 10 6 22 6 88 77 -1 Integer(until -1 is entered)
 * 가장 큰 수는 88 The largest number is
 */