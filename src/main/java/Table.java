package main.java;


import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * P�ly�t t�rol� oszt�ly
 */
public class Table {

	/**
	 * Default constructor
	 */
	public Table() {
	}
	
	/**
	 * Sorok �s oszlopok sz�ma
	 */
	public static int row = 0;
	public static int column = 0;
	
	/**
	 * Alag�tbej�ratok k�z�tt vezet� utatkat t�rol� lista
	 */
	private ArrayList<TunnelRoute> tunnelRoutes;

	/**
	 * T�blaelemeket t�rol� lista
	 */
	private ArrayList<TableElement> tableElements;

	/**
	 * Vonatokat t�rol� lista
	 */
	private ArrayList<Train> train;

	/**
	 * Nyitott alag�tbej�ratok
	 */
	private TunnelEntrance[] openTunnelEntrances = new TunnelEntrance[2];
	
	/**
	 * P�lya bet�lt�se
	 * 
	 * @param map
	 *            A p�lya neve
	 */
	public void loadMap(String map) {
		try {
			openTunnelEntrances[0] = null;
			openTunnelEntrances[1] = null;
			tunnelRoutes = new ArrayList<TunnelRoute>();
			train = new ArrayList<Train>();
			tableElements = new ArrayList<TableElement>();
			File fXmlFile = new File(App.cl.getResource("map/" + map).getFile()); 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();


			Element game = (Element)doc.getElementsByTagName("game").item(0);
			row = Integer.parseInt(game.getAttribute("row"));
			column = Integer.parseInt(game.getAttribute("column"));
			
			NodeList _rail = doc.getElementsByTagName("rail");
			for (int i = 0; i < _rail.getLength(); i++) {

				Node node = _rail.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					tableElements.add(new Rail(TryParseInt(elem.getAttribute("id"))));
				}
			}
			NodeList _field = doc.getElementsByTagName("field");
			for (int i = 0; i < _field.getLength(); i++) {

				Node node = _field.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					tableElements.add(new Field(TryParseInt(elem.getAttribute("id"))));
				}
			}
			NodeList _crossing = doc.getElementsByTagName("crossing");
			for (int i = 0; i < _crossing.getLength(); i++) {

				Node node = _crossing.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					tableElements.add(new Crossing(TryParseInt(elem.getAttribute("id"))));
				}
			}

			NodeList _station = doc.getElementsByTagName("station");
			for (int i = 0; i < _station.getLength(); i++) {

				Node node = _station.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					Color _color;
					String __c = elem.getAttribute("color");
					if (__c.equals("red"))
						_color = Color.RED;
					else if (__c.equals("blue"))
						_color = Color.BLUE;
					else if (__c.equals("green"))
						_color = Color.GREEN;
					else
						_color = Color.YELLOW;
					tableElements.add(new Station(TryParseInt(elem.getAttribute("id")), _color));
				}
			}

			NodeList _switch = doc.getElementsByTagName("switch");
			for (int i = 0; i < _switch.getLength(); i++) {

				Node node = _switch.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					tableElements.add(new Switch(TryParseInt(elem.getAttribute("id"))));
				}
			}

			NodeList _tunnel = doc.getElementsByTagName("tunnel");
			for (int i = 0; i < _tunnel.getLength(); i++) {

				Node node = _tunnel.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					tableElements.add(new Tunnel(TryParseInt(elem.getAttribute("id")), this));
				}
			}

			NodeList _tunnelE = doc.getElementsByTagName("tunnelentrance");
			for (int i = 0; i < _tunnelE.getLength(); i++) {

				Node node = _tunnelE.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					tableElements.add(new TunnelEntrance(TryParseInt(elem.getAttribute("id")), this));
				}
			}

			for (int i = 0; i < _rail.getLength(); i++) {
				Node node = _rail.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					TableElement tableelem = getTableElement(TryParseInt(elem.getAttribute("id")));
					ArrayList<TableElement> list = new ArrayList<TableElement>();
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid1"))));
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid2"))));

					tableelem.setUpConnections(list);
				}
			}

			for (int i = 0; i < _station.getLength(); i++) {
				Node node = _station.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;					
					TableElement tableelem = getTableElement(TryParseInt(elem.getAttribute("id")));
					ArrayList<TableElement> list = new ArrayList<TableElement>();
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid1"))));
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid2"))));

					tableelem.setUpConnections(list);
				}
			}

			for (int i = 0; i < _tunnelE.getLength(); i++) {
				Node node = _tunnelE.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					TableElement tableelem = getTableElement(TryParseInt(elem.getAttribute("id")));
					ArrayList<TableElement> list = new ArrayList<TableElement>();
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid1"))));
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid2"))));

					tableelem.setUpConnections(list);
				}
			}

			for (int i = 0; i < _switch.getLength(); i++) {
				Node node = _switch.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					TableElement tableelem = getTableElement(TryParseInt(elem.getAttribute("id")));
					ArrayList<TableElement> list = new ArrayList<TableElement>();
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid1"))));
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid2"))));
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid3"))));

					tableelem.setUpConnections(list);
				}
			}

			for (int i = 0; i < _crossing.getLength(); i++) {
				Node node = _crossing.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					TableElement tableelem = getTableElement(TryParseInt(elem.getAttribute("id")));
					ArrayList<TableElement> list = new ArrayList<TableElement>();
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid1"))));
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid2"))));
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid3"))));
					list.add(getTableElement(TryParseInt(elem.getAttribute("refid4"))));

					tableelem.setUpConnections(list);
				}
			}

			NodeList _tunnelR = doc.getElementsByTagName("route");
			for (int i = 0; i < _tunnelR.getLength(); i++) {

				Node node = _tunnelR.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					NodeList _nl = elem.getElementsByTagName("nextelem");
					ArrayList<Tunnel> list = new ArrayList<Tunnel>();
					for (int j = 0; j < _nl.getLength(); j++) {
						Node _n = _nl.item(j);
						if (_n.getNodeType() == Node.ELEMENT_NODE) {
							Element _e = (Element) _n;
							list.add((Tunnel) getTableElement(TryParseInt(_e.getAttribute("refid"))));
						}
					}

					TunnelEntrance _str = (TunnelEntrance) getTableElement(TryParseInt(elem.getAttribute("start")));
					TunnelEntrance _end = (TunnelEntrance) getTableElement(TryParseInt(elem.getAttribute("end")));
					tunnelRoutes.add(new TunnelRoute(_str, _end, list));
				}
			}

			NodeList _trains = doc.getElementsByTagName("train");
			for (int i = 0; i < _trains.getLength(); i++) {
				Node node = _trains.item(i);
				Element elem = (Element) node;

				int start = TryParseInt(elem.getAttribute("startpos"));
				TableElement startpos = getTableElement(start);

				Train _train = new Train(TryParseInt(elem.getAttribute("starttick")), startpos,
						TryParseInt(elem.getAttribute("id")));
				NodeList _elems = node.getChildNodes();
				for (int j = 0; j < _elems.getLength(); j++) {
					Node _node = _elems.item(j);
					if (_node.getNodeType() == Node.ELEMENT_NODE) {
						Element _e = (Element) _node;
						String _name = _e.getTagName();
						if (_name.equals("loco")) {
							_train.addElement(new Locomotive(null, true, _train));
						} else if (_name.equals("coalwagon")) {
							_train.addElement(new CoalWagon(null, true, _train));
						} else {
							Color _color;
							String __c = _e.getAttribute("color");
							if (__c.equals("red"))
								_color = Color.RED;
							else if (__c.equals("blue"))
								_color = Color.BLUE;
							else if (__c.equals("green"))
								_color = Color.GREEN;
							else
								_color = Color.YELLOW;
							_train.addElement(new Car(_color, Boolean.parseBoolean(_e.getAttribute("empty")), _train));
						}
					}
				}
				train.add(_train);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Vonatok mozgat�sa az aktu�lis id�pillanatban
	 * 
	 * @param tick
	 *            Az aktu�lis id�pillanat
	 */
	public void move(int tick) {
		for (Train train : train) {
			train.move(tick);
		}
	}

	/**
	 * Kinyitja az alag�tbej�ratot, ha nincs m�r kett� aktiv�lva.
	 * 
	 * @param TunnelEntrance
	 *            A kinyitni k�v�nt alag�tbej�rat.
	 */
	public void openTunnel(TunnelEntrance te) {
		if (openTunnelEntrances[0] != null && openTunnelEntrances[1] != null)
			return;
		if (openTunnelEntrances[0] != null) {
			openTunnelEntrances[1] = te;
			te.changeStatus();
		} else {
			openTunnelEntrances[0] = te;
			te.changeStatus();
		}
	}

	/**
	 * Bez�rja a megadott alag�tbej�ratot, ha nincs alag�tban vonat.
	 * 
	 * @param te
	 *            A bez�rand� alag�tbej�rat.
	 */
	public void closeTunnel(TunnelEntrance te) {
		for (Train tr : train) {
			if (tr.isInTunnel())
				return;
		}
		if (openTunnelEntrances[0] == te) {
			te.changeStatus();
			openTunnelEntrances[0] = null;
		} else if (openTunnelEntrances[1] == te) {
			te.changeStatus();
			openTunnelEntrances[1] = null;
		}
	}

	/**
	 * Megadja, hogy az �tadott param�terenek megfelel� alag�t j�raton mi a
	 * k�vetkez� l�p�s.
	 * 
	 * @param start
	 *            Melyik alagutb�lbej�ratt�l �rkezett a vonat.
	 * @param at
	 *            Melyik Tunnel elemen van �ppen.
	 * @return K�vetkez� Tunnel elem az alag�tj�raton.
	 */
	public TableElement getNextTunnel(TunnelEntrance start, Tunnel at) {
		if(openTunnelEntrances[0] == null || openTunnelEntrances[1] == null) Game.gameOver();
		TunnelEntrance end = null;
		if (start == openTunnelEntrances[0])
			end = openTunnelEntrances[1];
		else
			end = openTunnelEntrances[0];
		TunnelRoute tr = null;
		for (TunnelRoute tunnelRoute : tunnelRoutes) {
			if (tunnelRoute.route(start, end)) {
				tr = tunnelRoute;
				return tr.getNext(at);
			}
		}
		Game.gameOver();
		return null;
	}

	/**
	 * Visszaadja az elemeket t�rol� list�t
	 * @return
	 */
	public ArrayList<TableElement> getTableElements() {
		return tableElements;
	}
	
	/**
	 * Visszaadja a vonatokat t�rol� list�t.
	 * @return
	 */
	public ArrayList<Train> getTrains(){
		return train;
	}

	/**
	 * Visszaadja a param�terk�nt kapott id-j� elemet ha az l�tezik
	 * @param id
	 * @return
	 */
	public TableElement getTableElement(int id) {
		for (TableElement tableElement : tableElements) {
			if (tableElement.getId() == id) {
				return tableElement;
			}
		}
		return null;
	}

	/**
	 * Seg�doszt�ly az XML int-ek beolvas�s�hoz.
	 * 
	 * @param XML-b�l
	 *            beolvasott sz�veg.
	 * @return 0-ha nem siker�lt kiolvasni, k�l�nben int k�nt a megadott sz�veg
	 */
	private int TryParseInt(String str) {
		try {
			int r = Integer.parseInt(str);
			return r;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/**
	 * Megvizsg�lja, hogy van e m�g olyan vonat, amin van utas.
	 * 
	 * @return true ha minden vonat �res
	 */
	public boolean mapCompleted() {
		for (Train train : train) {
			if (!train.isEmpty())
				return false;
		}
		return true;
	}
	/**
	 * Visszaadja, hogy k�t bej�rat van-e nyitva.
	 * @return true ha k�t bej�rat van nyitva, false, ha kevesebb.
	 */
	public boolean twoEntrancesOpen(){
		return(openTunnelEntrances[0]!= null && openTunnelEntrances[1]!=null);
	}
}