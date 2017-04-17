
import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * Pályát tároló osztály
 */
public class Table {

	/**
	 * Default constructor
	 */
	public Table() {
		openTunnelEntrances[0] = null;
		openTunnelEntrances[1] = null;
	}

	/**
	 * Alagútbejáratok között vezetö utatkat tároló lista
	 */
	private ArrayList<TunnelRoute> tunnelRoutes;

	/**
	 * Táblaelemeket tároló lista
	 */
	private ArrayList<TableElement> tableElements;

	/**
	 * Vonatokat tároló lista
	 */
	private ArrayList<Train> train;

	/**
	 * Nyitott alagútbejáratok
	 */
	private TunnelEntrance[] openTunnelEntrances = new TunnelEntrance[2];

	/**
	 * Pálya betöltése
	 * 
	 * @param map
	 *            A pálya neve
	 */
	public void loadMap(String map) {
		try {

			tunnelRoutes = new ArrayList<TunnelRoute>();
			train = new ArrayList<Train>();
			tableElements = new ArrayList<TableElement>();
			File fXmlFile = new File("map/" + map);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

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
			for (int i = 0; i < _crossing.getLength(); i++) {

				Node node = _crossing.item(i);
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
							Tunnel teee = (Tunnel) getTableElement(TryParseInt(_e.getAttribute("refid")));
							TableElement teee2 = getTableElement(TryParseInt(_e.getAttribute("refid")));
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
							String __c = elem.getAttribute("color");
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
	 * Vonatok mozgatása az aktuális idöpillanatban
	 * @param tick Az aktuális idöpillanat
	 */
	public void move(int tick){
		for (Train train : train) {
			train.move(tick);
		}
	}

	/**
	 * Kinyitja az alagútbejáratot, ha nincs már kettö aktiválva, valamit
	 * bezárja ha épp aktív.
	 * 
	 * @param TunnelEntrance
	 *            A bezárni/kinyitni kívánt alagútbejárat.
	 */
	public void openTunnel(TunnelEntrance te) {
		if (openTunnelEntrances[0] == te) {
			te.changeStatus();
			openTunnelEntrances[0] = null;
			return;
		} else if (openTunnelEntrances[1] == te) {
			te.changeStatus();
			openTunnelEntrances[1] = null;
		} else if (openTunnelEntrances[0] != null && openTunnelEntrances[1] != null) {
			return;
		} else {
			for (Train tr : train) {
				if (tr.isInTunnel())
					return;
			}
			if (openTunnelEntrances[0] != null) {
				openTunnelEntrances[0] = te;
				te.changeStatus();
				return;
			} else {
				openTunnelEntrances[1] = te;
				te.changeStatus();
				return;
			}
		}
	}

	/**
	 * Megadja, hogy az átadott paraméterenek megfelelö alagút járaton mi a
	 * következö lépés.
	 * 
	 * @param start
	 *            Melyik alagutbólbejárattól érkezett a vonat.
	 * @param at
	 *            Melyik Tunnel elemen van éppen.
	 * @return Következö Tunnel elem az alagútjáraton.
	 */
	public TableElement getNextTunnel(TunnelEntrance start, Tunnel at) {
		TunnelEntrance end;
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
		return null;
	}
	private TableElement getTableElement(int id) {
		for (TableElement tableElement : tableElements) {
			if (tableElement.getId() == id) {
				return tableElement;
			}
		}
		return null;
	}

	private int TryParseInt(String str) {
		try {
			int r = Integer.parseInt(str);
			return r;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}