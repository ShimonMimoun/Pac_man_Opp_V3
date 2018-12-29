package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

/**
 *  This class implements GIS_element functions.
 * @author Shimon Mimoun and Omer Paz
 *
 */



public class Gis_element_using  implements GIS_element  {
	
	
	
	Point3D elem_Point;
	Meta_Data_using mt;
	private String MAC;
	private String SSID_name;
	private String AuthMode;
	private double Lat;
	private double Lon;
	private double AltitudeMeters;
	private int Channel;
	private int RSSI; 
	private int AccuracyMeters;
	private String type;



	/**
	 * this Constractor include all the information foreach element.
	 * all the elements that the constartor get he is String type cuse we read it from csv file.
	 * 
	 * @param MAC
	 * @param SSID
	 * @param AuthMode
	 * @param FirstSeen
	 * @param Channel
	 * @param RSSI
	 * @param Lat
	 * @param Lon
	 * @param AltitudeMeters
	 * @param AccuracyMeters
	 * @param type
	 */

	public Gis_element_using(String MAC , String SSID_name,String AuthMode,String Channel,
			String RSSI,String Lat,String Lon , String  AltitudeMeters,String AccuracyMeters, String type) {
		
		setMAC(MAC); // String 
		setSSID_name(SSID_name); //String 
		setAuthMode(AuthMode); //String
		setType(type);; // String 
		setPoint(Lat,Lon,AltitudeMeters);
		setChannel(Channel); // int
		setRSSI(RSSI); // int
		setAccuracyMeters(AccuracyMeters);		
		mt=new Meta_Data_using();
	}

	/// Getters ////

	public String getMAC() {
		return MAC;
	}

	public String getSSID_name() {
		return SSID_name;
	}

	public String getAuthMode() {
		return AuthMode;
	}

	public double getLat() {
		return Lat;
	}

	public double getLon() {
		return Lon;
	}

	public double getAltitudeMeters() {
		return AltitudeMeters;
	}

	public int getChannel() {
		return Channel;
	}

	public int getRSSI() {
		return RSSI;
	}

	public double getAccuracyMeters() {
		return AccuracyMeters;
	}

	public String getType() {
		return type;
	}
	/// end Getters //

	/// Setters ///

	public void setChannel(String Channel) {
		int theChannel = Integer.parseInt(Channel);
		this.Channel = theChannel;
	}
	public void setRSSI(String RSSI) {
		int theRSSI = Integer.parseInt(RSSI);
		this.RSSI = theRSSI;
	}
	public void setAccuracyMeters(String AccuracyMeters) {
		
		double theAccuracyMeters = Double.parseDouble(AccuracyMeters);
		this.AccuracyMeters =(int) theAccuracyMeters;
	}
	
	public Point3D setPoint(String lat, String lon , String AltitudeMeters) {
		elem_Point = new Point3D(lat, lon, AltitudeMeters);
		return elem_Point;
	}	
	
	public void setType(String type) {
		this.type = type;
	}

	public void setAuthMode(String AuthMode) {
		this.AuthMode = AuthMode;
	}
	public void setSSID_name(String name) {
		this.SSID_name = name;
	}
	public void setMAC(String MAC) {
		this.MAC = MAC;
	}


	/// end Setters ///


	@Override
	public Geom_element getGeom() {
		return elem_Point;
	}

	@Override
	public Meta_data getData() {
		return this.mt;
	}

	@Override
	public void translate(Point3D vec) {
		MyCoords m = new MyCoords();


		Point3D ans = m.add(this.elem_Point, vec);
		elem_Point = new Point3D(ans.x(),ans.y(),ans.z());

	}

	// Helping functions //

//	public Point3D String_2_Point3D(String lat , String lon , String AltitudeMeters) {
//
//		Double x = Double.parseDouble(lat);
//		Double y = Double.parseDouble(lon);
//		Double z = Double.parseDouble(AltitudeMeters);
//
//		return new Point3D(x,y,z);
//	}

	/**
	 * Create a String of the element and adiing the meta data information.
	 * @return the element
	 */
	public String toString() {

		return ""+MAC +"," +SSID_name+","+AuthMode+","+Channel+","+RSSI+","+elem_Point.toString()+","+AccuracyMeters+","+type+","+getData().toString();
	}



}