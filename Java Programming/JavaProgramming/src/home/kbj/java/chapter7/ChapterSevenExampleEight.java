package home.kbj.java.chapter7;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/* title: HashMap의 요소 값을 수정하는 연습 (고객의 이름과 포인트 점수를 관리하는 프로그램) */
/* condition
 * 고객의 이름과 포인트를 함께 저장 관리
 * 포인트는 추가될 때마다 누적하여 저장
 */
public class ChapterSevenExampleEight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("** It is a point management program **");
		
		PointManagement pointManagement = new PointManagement();
		while(true) {
			System.out.print("Enter name and point>> ");
			String line = sc.nextLine();
			
			if("stop".equals(line))
				break;
			
			String[] temp = line.split(" ");
			pointManagement.EnterInfo(temp[0], Integer.parseInt(temp[1]));
			pointManagement.printAllInfo();
		}

	}

}

class PointManagement {
	private HashMap<String, Integer> hm;
	
	PointManagement() {
		// TODO Auto-generated constructor stub
		hm = new HashMap<>();
	}
	
	void EnterInfo(String name, int point) {
		if(hm.containsKey(name)) {
			hm.put(name, hm.get(name) + point);
		}
		else {
			hm.put(name, point);
		}
	}
	
	void printAllInfo() {
		for(Entry<String, Integer> entry : hm.entrySet()) {
			System.out.printf("(%s,%d)", entry.getKey(), entry.getValue());
		}
		System.out.println();
	}
}
/* result
 * ** 포인트 관리 프로그램입니다 **	It is a point management program
 * 이름과 포인트 입력>> 이재문 40	Enter name and point
 * (이재문,40)
 * 이름과 포인트 입력>> 황기태 50
 * (이재문,40)(황기태,50)
 * 이름과 포인트 입력>> 그만
 */
