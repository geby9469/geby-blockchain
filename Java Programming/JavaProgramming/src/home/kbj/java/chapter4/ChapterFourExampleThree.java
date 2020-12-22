package home.kbj.java.chapter4;

/* title: 노래 한 곡을 나타내는 Song 클래스를 작성 */
/* condition 1
 * 노래의 제목을 나타내는 title
 * 가수를 나타내는 artist
 * 노래가 발표된 연도를 나타내는 year
 * 국적을 나타내는 country 
 */
/* condition 2
 * 생성자 2개: 기본 생성자와 매개변수로 모든 필드를 초기화하는 생성자
 * 노래 정보를 출력하는 show() method
 * main method: 1978년, 스웨덴 국적의 ABBA가 부른 "Dancing Queen"을 객체로 생성하고 show()를 이용하여 노래의 정보를 출력
 */
public class ChapterFourExampleThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song song = new Song("Dancing Queen", "ABBA", "1978", "Swedish");
		song.show();
	}

}

class Song {
	private String title, artist, year, country;
	
	// basic constructor
	Song() {}
	
	Song(String title, String artist, String year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	
	void show() {
		System.out.printf("%s sung by the %s national %s in %s", title, country, artist, year);
	}
}
/* result
 * Dancing Queen sung by the Swedish national ABBA in 1978
 */