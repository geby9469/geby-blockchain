package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/* title: 소켓 통신, 스레드를 이용하여 양방향 통신 작성 */
/* condition
 * 순서에 상관없이 자유롭게 서버와 클라이언트가 메시지를 주고받을 수 있도록 스레드를 이용
 * <Enter>키를 입력하면 상대에게 바로 전송
 * 어느 한쪽이 접속을 끊으면 프로그램 종료 
 */
public class RealChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatServer cs = new ChatServer(9999);
		cs.execute();
	}

}

class ChatServer {
	private int port;
	
	ChatServer(int port) {
		this.port = port;
	}
	
	void execute() {
		try (
				ServerSocket serverSocket = new ServerSocket(port);
		) {
			try(
					Socket socket = serverSocket.accept();
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					Scanner sc = new Scanner(System.in);
			) {
				if(socket != null)
					System.out.println("Connection completed from Client");
				
				// receive
				Thread t = new Thread(new ReceiveServerThread(socket));
				t.start();
				
				// send
				String sendMessage = null;
				while(true) {
					if("bye".equals(sendMessage))
						break;
					System.out.print("Send>>");
					sendMessage = sc.nextLine();
					bw.write(sendMessage + "\n");
					bw.flush();
					System.out.printf("Server : %s\n", sendMessage);
				}
				
			}
			catch(Exception e) {
				System.exit(1);
			}
		}
		catch(IOException e) {
			System.out.println("Bind Exception");
			e.printStackTrace();
		}
	}

}

class ReceiveServerThread implements Runnable {
	private Socket socket;
	
	ReceiveServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			try (
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			) {
				String line;
				while((line = br.readLine()) != null) {
					if("bye".equals(line)) {
						break;
					}
					System.out.printf("\nClient : %s\n", line);
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
	}

}


/* result
 * 클라이언트로부터 연결 완료		Connection completed from Client
 * 서버 : 안녕
 * 클라이언트 : 자바 공부는 잘 되니?
 * 서버 : 그럼 얼마나 재밌는데.....
 * 클라이언트 : 진짜?
 */