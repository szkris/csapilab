import java.awt.Graphics;

public class GRail extends GElements {

	Rail rail;
	
	public GRail(Rail rail, int x, int y){
		super(x,y);
		this.rail = rail;
	}
	
	@Override
	public void draw(Graphics g) { 
		g.drawRect(x, y, 50, 50);
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}

}
