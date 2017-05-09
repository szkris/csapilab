import java.awt.Graphics;

public class GCoalWagon extends GElements {

	CoalWagon cw;
	
	public GCoalWagon(CoalWagon coalwagon,int x, int y){
		super(x,y);
		cw = coalwagon;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int getId(){
		return 0;
	}

}
