import java.awt.Graphics;

public class GTunnelEntrance extends GElements {

	TunnelEntrance te;

	public GTunnelEntrance(TunnelEntrance te, int x, int y){
		super(x,y);
		this.te = te;
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
		return te.id;
	}

}
