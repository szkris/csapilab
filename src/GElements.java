import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GElements extends JPanel implements IDrawable {
	protected int x;
	protected int y;
	//private Image img;
	
	public abstract void click();
	
	protected GElements(int x, int y){
		this.x = x;
		this.y = y;
	}
	protected GElements(){
		this.x = 0;
		this.y = 0;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public abstract int getId();
}