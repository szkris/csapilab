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
	
	private static int TILEHEIGHT = 50;
	private static int TILEWIDTH = 50;
	
	protected JPanel panel = new JPanel();
	
	private Table tableCopy;
	
	private ArrayList<GElements> gelements = new ArrayList<GElements>();
	
	public void loadMap(int id){
			int x = 0, y = 0;
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
						int index = Integer.parseInt(string);
						TableElement te = tableCopy.getTableElement(index);	
						switch(te.getType()){
						case "rail":
							gelements.add(new GRail((Rail)te, x, y));
							break;
						case "field":
							gelements.add(new GField((Field)te, x, y));
							break;
						case "switch":
							gelements.add(new GSwitch((Switch)te, x, y));
							break;
						case "crossing":
							gelements.add(new GCrossing((Crossing)te, x, y));
							break;
						case "station":
							gelements.add(new GStation((Station)te, x, y));
							break;
						case "tunnelentrance":
							gelements.add(new GTunnelEntrance((TunnelEntrance)te, x, y));
							break;
						default:
							break;
						}
						if(index%column == 0){
							y+=TILEHEIGHT;
							x = 0;
						} else {
							x+=TILEWIDTH;
						}
					}
				}
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
	
	
	public void drawAll(){
		for(int i = 0; i < gelements.size(); i++){
			gelements.get(i).draw(panel.getParent().getGraphics());
		}
		panel.invalidate();
	}
	
	public void addTrain(Train t){
		
	}
	
	public void click(int x, int y){
		
	}
}
