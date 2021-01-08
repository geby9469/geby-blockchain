package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ExistsWordClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RetrieveWord rw = new RetrieveWord();
		rw.execute();
	}

}


class RetrieveWord {
	
	public void execute() {
		try (
				Socket socket = new Socket("127.0.0.1", 9998);
				Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		) {
			while(true) {
				System.out.print("단어입력 : ");
				String word = sc.next();
				if("bye".equals(word))
					break;
				
				bw.write(word + "\n");
				bw.flush();
				
				String receiveWord = br.readLine();
				System.out.printf("%s is %s \n", word, receiveWord);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/* result
 * 단어입력 : kite
 * kite는 YES
 * 단어입력 : pather
 * pather는 NO
 */