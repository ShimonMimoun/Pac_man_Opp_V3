package GIS;

import java.util.ArrayList;

import Coords.Map;
import Geom.Point3D;
/**
 * This class represents the course of my Pacman according to the fruits present
 * @author Mimoun Shimon and Omer Paz
 *
 */
public class Path{

	public double totalTimePath;
	Map theMap = new Map();
	
	private ArrayList<Fruit> thepath;
	private ArrayList<Packman> temp_path;

/**
 * Constractor 
 */
	public Path() {
		this.totalTimePath = 0;	
		thepath = new ArrayList<>();

	}
	/**
	 * Getter Method
	 * @return  a Total Time from my Path
 	 */
	public double getTheTime() {
		return this.totalTimePath;
	}
	/**
	 * Setter Method
	 * @param total  Receiv a new time 
 	 */
	public void setTheTotalTime(double total) {
		this.totalTimePath = total;
	}
	/**
	 * Getter Method
	 * @return  a Path Under the form ArrayList of Packman from my Game 
 	 */
	public ArrayList<Packman> GetmyTest(){
		return this.temp_path;
	}
	/**
	 * Getter Method
	 * return return a Path of Packman ( return a List of Fruit depending on the route my PAC-Man will receive)
 	 */
	public ArrayList<Fruit> TheCurrentPath() {
		return this.thepath;
	}
	/**
	 * Calculations the time between a Pac-Man and a Fruit
	 * @param p The Pacman
	 * @param f The fruit
	 * @return The Time
	 */
	public double CalTime2Points(Packman p , Fruit f) {
		if (theMap.distancePixels(p.getPoint(), f.getFruitPoint()) < p.getradius()) {
			
			return 0;
		}
		else {	
			return (theMap.distancePixels(p.getPoint(), f.getFruitPoint())-p.getradius())/p.getSpeed();

		}
	}
	
	/**
	 * Calculate the total time of a Path
	 * @param packman Receiv Packman (with path inside)
	 * @return  The total Time of a Path
	 */
	public double CalPathTime(Packman packman) {
		
		double totalTime = 0;
		double cal = 0;
		Packman temp = new Packman(packman);
		for (int i = 0; i < packman.getPath().TheCurrentPath().size(); i++) {
			cal = CalTime2Points(packman,packman.getPath().TheCurrentPath().get(i));
			totalTime = totalTime+cal;
			packman.setPackLocation(packman.getPath().TheCurrentPath().get(i).getFruitPoint());

		}
		packman.getPath().setTheTotalTime(totalTime);
		packman.setPackLocation(temp.getPoint());

		return totalTime;
	}

	/**
	 * Find the next waypoints of my PAC-Man Path
	 * @param p1 Pacman on which I do my calculations
	 * @param f1 Fruit on which I do my calculations
	 * @param t The time
	 * @return a new Point of my path 
	 */
	public Point3D theNextPoint(Packman p1 , Fruit f1, double t) {
		
	double dt = p1.getPath().getTheTime(); // the time from (x1,y1) to (x2,y2) example: 300.
	
	double Vx = p1.getPoint().x()/dt+0.05;
	double Vy = p1.getPoint().y()/dt+0.05;
	
	double xt = p1.getPoint().x()+Vx*(f1.getFruitPoint().x()-p1.getPoint().x());
	double yt= p1.getPoint().y()+Vy*(f1.getFruitPoint().y()-p1.getPoint().y());
	return new Point3D(xt,yt);
	
	}
	

	/**
	 * Setter Method
	 * @param p new ArrayList of Fruit
	 */
	public void setPath(ArrayList<Fruit> p) {
		this.thepath = p;
		
	}
	

}