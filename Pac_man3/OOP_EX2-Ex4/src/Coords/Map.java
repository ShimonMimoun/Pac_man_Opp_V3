package Coords;

import Geom.Point3D;

/**
 * This class contains the GPS coordinates of the ends of the photo enter my software
 * She know how to do all kinds of conversion calculations between GPS coordinates and pixels
 * @author Mimoun Shimon and Omer Paz
 *
 */
public class Map {
	
									
	private Point3D leftUp;
	private Point3D RightDown;
	private double x_length;
	private double y_length;
	private String diractroyMap;
	
	/**
	 * Default Constractor of my Class 
	 */
	public Map() {
		this.leftUp = new Point3D(32.105770,  35.202469);
		this.RightDown = new Point3D(32.101899, 35.211588);
		this.x_length = this.RightDown.y()-this.leftUp.y();
		this.y_length = this.RightDown.x()-this.leftUp.x();
		this.diractroyMap = "Pictures&Icones/Ariel1.png";

	}
	/**
	 * Contractor of Map : Receiv 3 Parameters
	 * @param LeftUpPointGps Point3D in the Lef tUp Coordinates 
	 * @param RightDownGps Point3D in the Right Down Coordinates 
	 * @param MapPath The Directory of Pictures 
	 */
	public Map(Point3D LeftUpPointGps , Point3D RightDownGps, String MapPath) {
		this.leftUp = LeftUpPointGps;
		this.RightDown = RightDownGps;
		this.x_length = this.RightDown.y()-this.leftUp.y();
		this.y_length = this.RightDown.x()-this.leftUp.x();
		this.diractroyMap = MapPath;

	}
	
/**
 * Change the Directory of Picture 
 * @param PathPic Receiv the  new Directory 
 */
	public void setMap(String PathPic) {
		this.diractroyMap = PathPic;
	}
	/**
	 * Getter of directory picture
	 * @return a Directory actual 
	 */
	public String getMapDiractory() {
		return this.diractroyMap;
	}
	

	/**
	 * Convert a Pixel Coordinate to GPS Coordinates.
	 * @param Dx Wight of Picture
	 * @param Dy Hight Of Picture
	 * @return The Point3D in the Coordinate GPS corresponding to the pixel
	 */
	public  Point3D Pixel2GPS(double Dx , double Dy) {
		
		
		double lon_x = Dx * x_length+leftUp.y();
		double lat_y = Dy * y_length+leftUp.x(); // or RightdDown.x()
		
		Point3D ans_in_Gps = new Point3D(lat_y,lon_x);
		
		return ans_in_Gps;
	}
	
	/**
	 * Convert a Gps Coordinates to Pixel Coordinates
	 * @param p Receiv Point3D in GPS Corrdinates 
	 * @return Point3D in Pixel Coordinates
	 */
	public Point3D GPS2Pixel(Point3D p) {
		
		double Dx = (p.y()-leftUp.y())/x_length;
		double Dy = (p.x()-leftUp.x())/y_length;
		
	return new Point3D(Dx,Dy);
			
	}
	/**
	 * Calculate the Distance Between 2 Points Pixels
	 * @param p1 Receiv the First Pixel Point 
	 * @param p2 Receiv the Secnd Pixel Point
	 * @return Distance Between the Points 
	 */
	public double distancePixels(Point3D p1, Point3D p2) {
		Point3D ansX =  Pixel2GPS(p1.x(),p1.y());
		Point3D ansY =  Pixel2GPS(p2.x(),p2.y());
		MyCoords m = new MyCoords();
		double result = m.distance3d(ansX, ansY);
		return result;

	}
	

}
