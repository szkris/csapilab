import java.util.ArrayList;

import javax.swing.JPanel;

public class View {
	protected JPanel panel;
	
	private Table tableCopy;
	
	private ArrayList<GElements> gelements;
	
	public void loadMap(int id){
		
	}
	
	public void drawAll(){
		for(int i = 0; i < gelements.size(); i++){
			gelements.get(i).draw();
		}
	}
	
	public void addTrain(Train t){
		
	}
	
	public void click(int x, int y){
		
	}
}
