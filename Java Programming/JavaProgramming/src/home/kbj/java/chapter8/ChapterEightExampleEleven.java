package home.kbj.java.chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/* title: Vector 컬렉션, 파일 입출력 실전 응용 */
/* condition
 * 저장: 파일을 한 라인씩 읽어 Vector 컬렉션에 라인별로 삽입
 * 영어 단어를 입력받아 그 단어로 시작하는 모든 단어를 벡터에서 찾아 출력
 */

public class ChapterEightExampleEleven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchWord sw = new SearchWord("./", "words.txt");
		
		sw.searchWord();
	}

}


class SearchWord {
	private String directoryPath;
	private String filePath;
	private String fileName;
	private File file;
	private Vector<String> v;
	
	public SearchWord(String directoryPath, String fileName) {
		// TODO Auto-generated constructor stub
		this.directoryPath = directoryPath.replace("\\", File.separator);
		this.fileName = fileName;
		this.filePath = directoryPath + File.separator + fileName;
		
		file = new File(filePath);
		v = new Vector<>((int)file.length());
	}
	
	void readFile() {
		try (
				BufferedReader br = new BufferedReader(new FileReader(file));
		) {
			System.out.printf("Read the %s file under %s folder \n", fileName, directoryPath);
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				v.add(line);
			}
			
		}
		catch(IOException e) {
			System.out.println("Failed to read");
			e.printStackTrace();
		}
	}
	
	void searchWord() {
		// read file
		readFile();
		
		// search word
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("word>>");
			String word = sc.next();
			
			if("stop".equals(word)) {
				System.out.println("It ends..");
				break;
			}
				
			
			int wordCount = 0;
			for(int i = 0; i < v.size(); i++) {
				if(v.get(i).startsWith(word)) {
					System.out.println(v.get(i));
					wordCount++;
				}
			}
			
			if(wordCount == 0)
				System.out.println("Not found");
		}
		sc.close();
	}
}

/* result
 * 프로젝트 폴더 밑의 words.txt 파일을 읽었습니다...	Read the words.txt file under directory path folder
 * 단어>>lov
 * love
 * lovebird
 * lovelorn
 * 단어>>asdfjasdf
 * 발견할 수 없음	Not found
 * 단어>>그만
 * 종료합니다..	It ends..
 */
