package home.kbj.java.chapter8;

import java.io.File;

/* title: File 클래스로 파일 리스트, 파일 타입, 파일 삭제 연습 (.txt 파일만 삭제하는 프로그램) */
public class ChapterEightExampleNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deleteFile();
	}
	
	static void deleteFile() {
		String directoryPath = "C:\\Users\\black\\Desktop\\BJK\\Git\\LocalStorage\\Java Programming\\JavaProgramming\\src\\home\\kbj\\java\\chapter8";
		String fileType = ".txt";
		directoryPath.replace("\\", File.separator);
		File file = new File(directoryPath);

		File[] fileList = file.listFiles();
		
		System.out.printf("Delete all %s files in %s directory.... \n", fileType, directoryPath);
		int countD = 0;
		for(int i = 0; i < fileList.length; i++) {
			if(fileList[i].getName().contains(fileType)) {
				fileList[i].delete();
				System.out.printf("Delete %s \n", fileList[i].getName());
				countD++;
			}
		}
		System.out.printf("A total of %d %s files have been deleted.", countD, fileType);
		
	}

}

/* result
 * ~디렉터리의 .txt 파일을 모두 삭제합니다....	Delete all .txt files in ~ directory
 * 1.txt 삭제		Delete 1.txt
 * 2.txt 삭제
 * 총 2개의 .txt 파일을 삭제하였습니다.	 A total of 2 .txt files have been deleted.
 */