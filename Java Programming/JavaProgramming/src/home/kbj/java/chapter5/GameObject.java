package home.kbj.java.chapter5;

//defined in the example
public abstract class GameObject {
	protected int distance; // 한 번 이동 거리
	protected int x, y; // 현재 위치(화면 맵 상의 위치)
	public GameObject(int startX, int startY, int distance) {
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean collide(GameObject p) {
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
	public abstract void move(); // 이동한 후의 새로운 위치로 x, y 변경
	public abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴
}
