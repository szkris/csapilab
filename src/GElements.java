
public abstract class GElements implements IDrawable {
	protected int x;
	protected int y;
	//private Image img;
	
	
	public abstract void click();
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}