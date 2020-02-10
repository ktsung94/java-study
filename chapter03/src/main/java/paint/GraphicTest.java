package paint;

public class GraphicTest implements Drawable {

	private String text;
	
	public GraphicTest(String test) {
		this.text = text;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("텍스트 " + text + "에 그렸습니다.");
	}

}
