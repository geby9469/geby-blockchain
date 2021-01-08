package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/* title: 다중 클라이언트를 서비스하는 소켓 통신 응용 */
/* condition
 * 하나의 서버에 다중 클라이언트가 동시에 접속하여 통신하는 프로그램을 작성
 * words.txt파일 읽기
 * 클라이어트는 사용자로부터 영어 단어를 입력받아 서버로 보낸다.
 * 서버는 클라이언트로부터 받은 단어가 words.txt에 있는지 검사하고 있으면 "YES", 업승면 'NO"를 전송한다.
 * 클라이언트는 서버로부터 받은 결과를 출력 
 */
public class ExistsWordServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server(9998);
		server.execute();
	}

}

class Server {
	private int port;
	private Vector<String> words;
	private File file;
	
	
	Server(int port) {
		this.port = port;
		String url = "C:\\Users\\black\\Desktop\\BJK\\Git\\LocalStorage\\Java Programming\\JavaProgramming\\words.txt".replace("\\", File.separator);
		file = new File(url); // convert absolute path for execute cmd 
		words = new Vector<>((int)file.length());
	}
	
	void readFile() {
		try (
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
		) {
			String line;
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				words.add(line);
			}
		}
		catch (IOException e) {
			System.out.printf("Failed to read %s \n", file.getName());
		}
	}
	
	void execute() {
		readFile();
		System.out.printf("Finished reading %s \n", file.getName());
		
		try(
				ServerSocket serverSocket = new ServerSocket(port);
		) {
			Socket socket = null;
			try {
				while(true) {
					socket = serverSocket.accept();
					if(socket != null)
						System.out.println("Client connected");
					ServerTask st = new ServerTask(socket, words);
					st.start();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(socket != null)
						socket.close();
				}
				catch (IOException e) {
				}
			}
		}
		catch (IOException e) {
			System.out.println("Failed to bind");
			e.printStackTrace();
		}
	}
	
	
}


class ServerTask extends Thread {
	private Socket socket;
	private Vector<String> words;
	
	ServerTask(Socket socket, Vector<String> words) {
		this.socket = socket;
		this.words = words;
	}
	
	@Override
	public void run() {
			try(
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			) {
				while(true) {
					send(bw, receive(br));
				}
			}
			catch (IOException e) {
				System.out.println("Client connection termination");
			}
	}
	
	boolean receive(BufferedReader br) throws IOException {
		String word = br.readLine();
		if(word == null)
			throw new IOException();
		
		if(words.contains(word)) {
			System.out.printf("%s=YES \n",word);
			return true;
		}
		else {
			System.out.printf("%s=NO \n",word);
			return false;
		}
			
	}
	
	void send(BufferedWriter bw, boolean hasWord) throws IOException {
		if(hasWord)
			bw.write("YES \n");
		else
			bw.write("NO \n");
		bw.flush();
	}
}

/* result
 * words.txt 읽기 완료 		finished reading words.txt
 * 클라이언트 연결됨		Client connected
 * kite=YES
 * 클라이언트 연결됨
 * friend=YES
 * pather=NO
 */
