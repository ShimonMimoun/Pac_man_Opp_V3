package GIS;

import Geom.Point3D;

/**
 * This class represents the packmans of the game.
 * Packmans have the ability to have different speeds and different raduis.
 * Recall that in the official game the packman aims to eat the maximum of Fruit.
 * @author Mimoun Shimon and Omer Paz
 *
 */
public class Packman {
	
	
	double radius;
	Point3D packLocation;
	double Orientation;
	double speed;
	Path packmanPath;
	
	/**
	 * Constractor of Packman
	 * @param point Receiv Point3D 
	 * @param speed Receiv a speed of Packman
	 * @param radius Reveib a raduis (to limit a Path of Packman)
	 */
	public Packman(Point3D point , double speed, double radius) {
		this.packLocation = point;
		this.speed  = speed;
		this.radius = radius;
		packmanPath = new Path();
		
	}
	/**
	 * Copy Constractor
	 * @param p Receiv a new Packman
	 */
	public Packman(Packman p) {
		this(p.packLocation,p.speed,p.radius);
		setPackmanPath(new Path());

	}
	/**
	 * Setter Method
	 * @param p Receiv a new Point from my Pac-Man
	 */
	public void setPackLocation(Point3D p) {
		this.packLocation = p;
	}
	/**
	 * Setter Method
	 * @param rad Receiv a new Raduis from my pac-man
 	 */
	public void setRadius(double rad) {
		this.radius = rad;
	}
	/**
	 * Setter Method
	 * @param speed Receiv a new Speed from my pac-man
 	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	/**
	 * Getter Method
	 * @return  a Raduis from my Pac_Man
 	 */
	public double getradius() {
		return this.radius;
	}
	/**
	 * Getter Method
	 * @return  a Orientation from my Pac_Man
 	 */
	public double getOrientation() {
		return this.Orientation;
	}
	/**
	 * Getter Method
	 * @return  a Speed from my Pac_Man
 	 */
	public double getSpeed() {
		return this.speed;
	}
	/**
	 * Getter Method
	 * @return  a Path from my Pac_Man
 	 */
	public Path getPath() {
		return this.packmanPath;
	}
	
	public void setPackmanPath(Path packmanPath) {
		this.packmanPath = packmanPath;
	}
	/**
	 * Getter Method
	 * @return  a Point3D from my Pac_Man
 	 */
	public Point3D getPoint() {
		return this.packLocation;
	}
	
	@Override
	public String toString() {
		return "Packman ["+packLocation.toString()+" Radius= "+radius+"speed=" + speed + "]";
	}
	
	
	


}
