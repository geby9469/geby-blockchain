package home.kbj.java.chapter13;

import java.text.SimpleDateFormat;
import java.util.Date;

/* title: 스레드 */
/* condition
 * 프로그램이 실행을 시작한 시간으로부터 시작하는 디지털시계를 만들어라.
 */
public class ChapterThirteenExampleThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutionTimerThread ett = new ExecutionTimerThread();
		ett.run();
	}

}

class ExecutionTimerThread implements Runnable {
	private Date date;
	private SimpleDateFormat sdf;
	
	ExecutionTimerThread() {
		sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			date = new Date();
			System.out.println(sdf.format(date));
			
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}




/* result
 * 2020-01-05 16:25:59 
 * 2020-01-05 16:25:60 
 * 2020-01-05 16:25:61
 * ... 
 */
