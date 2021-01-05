package home.kbj.java.chapter13;

/* title: 스레드 동기화 */
/* condition
 * 공유 집계판에 2명의 학생이 10번 접근
 * 점수에 10점씩 더함
 */
public class SynchroizeThread {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// share this object!!
		Operation op = new Operation(); 
		
		Thread t1 = new StudentThread("BJK", op);
		Thread t2 = new StudentThread("MGH", op);
		
		t1.start();
		t2.start();
		
	}

}

class Operation {
	private int sum;
	
	public Operation() {
		sum = 0;
	}
	
	synchronized void add() {
		sum += 10;
		Thread.yield();
		System.out.printf("%s: %d \n", Thread.currentThread().getName(), sum);
	}
	
	
}

class StudentThread extends Thread {
	private Operation op;
	
	public StudentThread(String name, Operation op) {
		// TODO Auto-generated constructor stub
		super(name);
		this.op = op;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++)
			op.add();
	}
}


/* result
 * BJK : 10
 * MGH : 20
 * ...
 * BJK : 200
 * */
