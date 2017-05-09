import java.awt.Graphics;

public class GLocomotive extends GElements {

	Locomotive loco;
	
	public GLocomotive(Locomotive loco, int x, int y){
		super(x,y);
		this.loco = loco;
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
