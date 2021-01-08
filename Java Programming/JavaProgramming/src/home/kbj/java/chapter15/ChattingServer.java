package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/* title: 채팅 프로그램 */
/* condition
 * 1:1 채팅
 * 클라이언트가 먼저 문자열을 보내면 서버가 받아 출력
 * 서버가 다시 문자열을 보내는 식
 * "\n"을 덧붙여 라인 단위로 수신
 * 클라이언트가 "bye"를 보내면 서버 클라이언트 모두 종료
 */
public class ChattingServer {
	
	public static void main(String[] args) {
		CreateServer chattingServer = new CreateServer(9999);
		chattingServer.execute();
	}
}


class CreateServer {
	private int port;
	
	CreateServer(int port) {
		this.port = port;
	}
	
	void execute() {
		try (
				ServerSocket serverSocket = new ServerSocket(port);
		) {
			if(serverSocket != null)
				System.out.println("Waiting for connection");
			
			try (
					Socket socket = serverSocket.accept();
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					Scanner sc = new Scanner(System.in);
			) {
				if(socket != null)
					System.out.println("Connected");

				while(true) {
					String clientMessage = br.readLine();

					if("bye".equals(clientMessage)) {
						System.out.println("Client terminated the connection to bye");
						break;
					}

					System.out.printf("Client: %s \n", clientMessage);
					System.out.print("Send>>");
					bw.write(sc.nextLine() + "\n");
					bw.flush();
				}
			}
			catch (IOException e) {
				System.out.println("An error has occurred");
			}
			
		}
		catch (IOException e) {
			System.out.println("Failed to connect server socket");
			e.printStackTrace();
		}		
	}
	
}

/* result
 * 연결을 기다리고 있습니다..... Waiting for connection
 * 연결되었습니다.				Connected
 * 클라이언트: 안녕?	
 * 보내기>>너도 안녕?
 * 클라이언트에서 bye로 연결을 종료하였음	 Client terminated the connection to bye
 */



