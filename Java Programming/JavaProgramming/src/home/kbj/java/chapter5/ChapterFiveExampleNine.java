package home.kbj.java.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* title: Stack 인터페이스를 상속받아 실수를 저장하는 StringStack 클래스 구현 */
public class ChapterFiveExampleNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("enter size of total stack storage space >> ");
		int capacity = sc.nextInt();
		
		StringStack stringStack = new StringStack(capacity);
		
		while(true) {
			System.out.print("enter String >> ");
			String str = sc.next();
			
			boolean isEmpty = stringStack.push(str);
			if(!isEmpty)
				System.out.println("Stack is full and cannot be pushed");
			
			if("stop".equals(str))
				break;
		}
		
		System.out.println(stringStack.pop());
		sc.close();

	}

}

interface Stack {
	int length(); // 현재 스택에 저장된 개수 리턴
	int capacity(); // 스택의 전체 저장 가능한 개수 리턴
	String pop(); // 스택의 top에 저장된 실수 리턴
	boolean push(String val); // 스택의 top에 실수 저장
}

class StringStack implements Stack {
	List<String> storage;
	private int capacity;
	private int top;
	
	StringStack(int capacity) {
		storage = new ArrayList<String>();
		this.capacity = capacity;
		top = -1;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return storage.size();
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public String pop() {
		// TODO Auto-generated method stub
		String returnStr = "";
		for(String popStr : storage) {
			returnStr += popStr + " ";
		}
		top = -1;
		return returnStr;
	}

	@Override
	public boolean push(String val) {
		// TODO Auto-generated method stub
		if(++top >= capacity) {
			top = capacity; // 경고창에도 불구하고 계속 push할 경우 error 방지
			return false; 
		}
		else {
			storage.add(val);
			return true;
		}
	}
	
}

/* result 
 * 총 스택 저장 공간의 크기 입력 >> 3 enter size of total stack storage space
 * 문자열 입력 >> hello		enter String
 * 문자열 입력 >> sunny
 * 문자열 입력 >> smile
 * 문자열 입력 >> happy
 * 스택이 꽉 차서 푸시 불가!	Stack is full and cannot be pushed
 * 문자열 입력 >> 그만 ("그만"을 입력하면 프로그램 종료) stop 
 * 스택에 저장된 모든 문자열 팝 : smile sunny hello	Pop all strings stored on the stack
 */

