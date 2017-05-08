import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class View {
	
	public View(Table table){
		tableCopy = table;
	}
	
	int column;
	
	protected JPanel panel = new JPanel();
	
	private Table tableCopy;
	
	private ArrayList<GElements> gelements = new ArrayList<GElements>();
	
	public void loadMap(int id){
			gelements.clear();
			FileReader fr;
			try {
				fr = new FileReader("map/"+ id+".txt");
				BufferedReader br = new BufferedReader(fr);
				String line;
				column = Integer.parseInt(br.readLine());
				while((line=br.readLine())!=null){
					String[] indexes = line.replace(" ", "").split(",");
					for (String string : indexes) {
						TableElement te = tableCopy.getTableElement(Integer.parseInt(string));	
						switch(te.getType()){
						case "rail":
							gelements.add(new GRail((Rail)te));
							break;
						case "field":
							gelements.add(new GField((Field)te));
							break;
						case "switch":
							gelements.add(new GSwitch((Switch)te));
							break;
						case "crossing":
							gelements.add(new GCrossing((Crossing)te));
							break;
						case "station":
							gelements.add(new GStation((Station)te));
							break;
						case "tunnelentrance":
							gelements.add(new GTunnelEntrance((TunnelEntrance)te));
							break;
						default:
							break;
						}
					}
				}
			} catch (Exception e) {				
				e.printStackTrace();
			}
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
