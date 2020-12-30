package home.kbj.java.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

/* title: ArrayList<E>에 객체 저장 및 검색 */
/* condition
 * 학생마다 Student 객체를 생성
 * 4명의 학생 정보를 ArrayList<Student>에 저장
 * 모든 학생 정보를 출력 + 학생 이름을 입력받아 해당 학생의 학점 평균을 출력
 */
public class ChapterSevenExampleFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// save student's information
		System.out.println("Enter student's name, department, id, grade point average.");
		ArrayList<Student> student = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 2; i++) {
			System.out.print(">> ");
			String studentInfo = sc.nextLine();
			String[] temp = studentInfo.split(", ");
			student.add(new Student(temp[0], temp[1], Integer.parseInt(temp[2]), Double.parseDouble(temp[3])));
		}
		
		// print
		for(int i = 0; i < student.size(); i++) {
			student.get(i).printAllInfo();
		}
		
		// enter name -> print grade point average
		while(true) {
			System.out.print("student's name >> ");
			String name = sc.next();
			
			// exit loop
			if("stop".equals(name))
				break;
			
			// retrieve
			for(int i = 0; i < student.size(); i++) {
				if(student.get(i).hasName(name)) {
					student.get(i).printInfo();
					break;
				}
			}
		}
		sc.close();
		
	}

}

class Student {
	private String name;
	private String department;
	private int id;
	private double gradePointAverage;
	
	public Student(String name, String department, int id, double gradePointAverage) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.department = department;
		this.id = id;
		this.gradePointAverage = gradePointAverage;
	}
	
	void printAllInfo() {
		System.out.println("-------------------");
		System.out.printf("name:%s \n", this.name);
		System.out.printf("department:%s \n", this.department);
		System.out.printf("id:%d \n", this.id);
		System.out.printf("grade point average:%.1f \n", this.gradePointAverage);
		System.out.println("-------------------");
	}

	boolean hasName(String name) {
		if(this.name.equals(name))
			return true;
		else 
			return false;
	}
	
	void printInfo() {
		System.out.printf("%s, %s, %d, %.1f \n", this.name, this.department, this.id, this.gradePointAverage);
	}
}
/* result
 * 학생 이름, 학과, 학번, 학점평균을 입력하세요. Enter student's name, department, id, grade point average
 * >> 황기태, 모바일, 1, 4.1
 * -------------------
 * 이름:황기태
 * 학과:모바일
 * 학번:1
 * 학점:4.1
 * -------------------
 * 학생 이름 >> 황기태	student's name
 * 황기태, 모바일, 1, 4.1
 * 학생 이름 >> 그만
 */
