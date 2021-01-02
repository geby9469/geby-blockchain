package home.kbj.java.chapter8;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* title: FileReader로 텍스트 파일 읽기 */
public class ChapterEightExampleTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "C:\\Users\\black\\Desktop\\BJK\\Git\\LocalStorage\\Java Programming\\JavaProgramming\\src\\home\\kbj\\java\\chapter8\\phone.txt";
		url.replace("\\", File.separator);
		File file = new File(url);
		
		try (
				FileReader fr = new FileReader(file);
		) {
			char[] readBuffer = new char[1024];
			
			while(true) {
				int c = fr.read(readBuffer);
				if(c < readBuffer.length);
					break;
			}
			
			System.out.printf("Prints %s \n", url);
			System.out.print(String.valueOf(readBuffer));
		}
		catch(IOException e) {
			System.out.println("Failed to print");
			e.printStackTrace();
		}
		
		
		
	}

}

/* result
 * C:\Users\black\Desktop\BJK\Git\LocalStorage\Java Programming\JavaProgramming\src\home\kbj\java\chapter8\\phone.txt을 출력합니다.
 * */

