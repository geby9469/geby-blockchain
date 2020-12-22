package home.kbj.java.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* title: 콘서트 예약 시스템 */
/* condition
 * 공연은 하루에 한 번 있다.
 * 좌석은 S석, A석, B석으로 나뉘며, 각각 10개의 좌석이 있다
 * 예약 시스템의 메뉴는 "예약", "조회", "취소", "끝내기"가 있다.
 * 예약은 한 자리만 가능하고, 좌석 타입, 예약자 이름, 좌석 번호를 순서대로 입력받아 예약한다.
 * 조회는 모든 좌석을 출력한다.
 * 취소는 예약자의 이름을 입력받아 취소한다.
 * 없는 이름, 없는 번호, 없는 메뉴, 잘못된 취소 등에 대해서 오류 메시지를 출력하고 사용자가 다시 시도하도록 한다.
 */
public class ConcertReservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// concert hall structure
		char[] totalSeatSection = {'S', 'A', 'B'};
		int[] seatCount = {10, 10, 10};
		
		// create concert hall
		Seat[] seat = new Seat[totalSeatSection.length];
		for(int i = 0; i < totalSeatSection.length; i++) {
			seat[i] = new Seat(totalSeatSection[i], seatCount[i]);
		}

		// reservation system start
		boolean isReservation = true;
		System.out.println("This is Luxury Concert Hall reservation system.");
		while(isReservation) {
			int seatSection;
			System.out.print("Reservation:1, Inquiry:2, Cancel:3, Exit:4>> ");
			int menuNum = sc.nextInt();
			switch (menuNum) {
			case 1:
				seatSection = classifySeat(totalSeatSection, seatCount);
				seat[seatSection].reservation();
				break;
			case 2:
				for(int i = 0; i < seat.length; i++)
					seat[i].inquiry();
				System.out.println("<<<You have completed your inquiry>>>");
				break;
			case 3:
				seatSection = classifySeat(totalSeatSection, seatCount);
				seat[seatSection].cancel();
				break;
			case 4:
				isReservation = false;
				sc.close();
				break;
			default:
				// error message
				System.out.printf("%d is doesn't exist in menu \n", menuNum);
				break;
			}
		}
	}
	
	@SuppressWarnings("resource")
	private static int classifySeat(char[] totalSeatSection, int[] seatCount) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Seat classification ");
		for(int i = 0; i < totalSeatSection.length; i++) {
			if(i == totalSeatSection.length-1)
				System.out.printf("%s(%d)>> ", totalSeatSection[i], i+1);
			else
				System.out.printf("%s(%d), ", totalSeatSection[i], i+1);
		}
		int seatSectionNumber = sc.nextInt()-1;
		return seatSectionNumber;
	}
}


class Seat {
	private char seatName;
	private int seatCount;
	private List<String> seat;
	
	Seat(char seatName, int seatCount) {
		this.seatName = seatName;
		this.seatCount = seatCount;
		seat = new ArrayList<String>(seatCount);
		for(int i = 0; i < this.seatCount; i++)
			seat.add("---");
	}

	@SuppressWarnings("resource")
	void reservation() {
		this.inquiry();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("name>> ");
			String name = sc.next();
			System.out.print("seat number>> ");
			int seatNumber = sc.nextInt()-1;

			// error message
			if(seatNumber < 0 || seatNumber > this.seatCount) {
				System.out.printf("%d is doesn't exist in seat \n", seatNumber);
				continue;
			}
			
			// error message 2
			if(!this.seat.get(seatNumber).equals("---")) {
				System.out.println("already reserved");
				continue;
			}
			else {
				this.seat.add(seatNumber, name);
				break;
			}
		}
	}
	
	void inquiry() {
		System.out.printf("%c>> ", this.seatName);
		for(int i = 0; i < this.seatCount; i++) {
			System.out.print(seat.get(i) + " ");
		}
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	void cancel() {
		this.inquiry();
	
		Scanner sc = new Scanner(System.in);
		boolean isCancel = true;
		while(isCancel) {
			System.out.print("name>> ");
			String name = sc.next();

			// name exist
			for(int i = 0; i < this.seatCount; i++) {
				if(this.seat.contains(name)) {
					this.seat.set(i, "---");
					isCancel = false;
					break;
				}
			}
			if(isCancel)
				System.out.printf("%s is doesn't exist \n", name);
		}
	}
}
/* result
 * 명품콘서트홀 예약 시스템입니다. Luxury concert hall reservation system.
 * 예약:1, 조회:2, 취소:3, 끝내기:4>>		reservation, inquiry, cancel, exit
 * 1. 예약
 * 좌석구분 S(1), A(2), B(3)>> Seat classification
 * S>> --- --- ---
 * 이름>>
 * 번호>>
 * 2. 조회
 * S>> 이름 --- ---
 * A>> --- 이름 ---
 * B>> --- --- 이름
 * <<<조회를 완료하였습니다.>>> You have completed your inquiry
 * 3. 취소
 * 좌석 S:1, A:2, B:3>>
 * A>> -- -- 이름
 * 이름>>
 * 4. 조회
 * S>> 이름 --- ---
 * A>> --- --- ---
 * B>> --- --- 이름
 * */
