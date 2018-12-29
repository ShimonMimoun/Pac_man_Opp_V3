package Geom;

/**
 * Interface of Geom 
 * It helps us send distance between points
 * @author Mimoun Shimon and Omer Paz
 */
public interface Geom_element {
	/**
	 * Calculat Distance  
	 * @param p Receiv Point in 3 coordinates
	 * @return a Distance in meter
	 */
	public double distance3D(Point3D p) ;
	/**
	 * Calculat Distance  
	 * @param p Receiv Point in 2coordinates
	 * @return a Distance in meter
	 */
	public double distance2D(Point3D p);
	
}
