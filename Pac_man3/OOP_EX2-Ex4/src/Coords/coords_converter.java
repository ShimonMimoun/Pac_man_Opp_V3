package Coords;

import Geom.Point3D;

/**
 * This interface represents a basic coordinate system converter, including:
 * 1. The 3D vector between two lat,lon, alt	 points 
 * 2. Adding a 3D vector in meters to a global point.
 * 3. convert a 3D vector from meters to polar coordinates
 * @author Shimon Mimoun and Omer Paz
 *
 */
public interface coords_converter {
	/** 
	 * Gps a point Gps and a vector in meter, and returns the point Gps after being
	 * moved from the Gps point with the vector.
	 * @param gps Point GPS for exemple (32.106352,35.205225,650)
	 * @param local_vector_in_meter Vector Cartesien in	 meter for exemple (337,-359,-20) 
	 * @return Point3D Gps after moving the GPS point using the vector.
	 */
	public Point3D add(Point3D gps, Point3D local_vector_in_meter);
	/**
	 *  Calculs the distance in meters between two GPS points
	 * @param gps0 first GPS Point for exemple (32.106352,35.205225,650)
	 * @param gps1 second GPS point for exemple (32.306352,35.278225,650)
	 * @return Distance Between gps0 and Gps1 in meter
	 */
	public double distance3d(Point3D gps0, Point3D gps1);
	/**
	 * Calculate the vector between two Gps Point3D
	 * @param gps0 first GPS Point for exemple (32.106352,35.205225,650) 
	 * @param gps1 second GPS point for exemple (32.306352,35.278225,650) 
	 * @return Vector  Between gps0 and Gps1
	 */
	public Point3D vector3D(Point3D gps0, Point3D gps1);
	/**
	 *  Computes the polar representation of the 3D vector be gps0 by gps1 
	 *  The azimuth is the angle formed between a reference direction and a line from the observer 
	 *  to a point of interest projected on the same plane as the reference direction orthogonal to the zenith.
	 * More : https://www.photopills.com/articles/understanding-azimuth-and-elevation
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance
	 * @param gps0 first GPS Point 
	 * @param gps1 second GPS point
	 * @return Array of angle formed
	 */
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1);
	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p GPS Point for exemple (32.106352,35.205225,650)
	 * @return if the Point3D is a GPS point or not
	 */
	public boolean isValid_GPS_Point(Point3D p);
	/**
	 * Convert Cartesian Point3D to  Point3D Gps
	 * @param p Point3D Cartesian
	 * @return Point3D GPS 
	 */
}
//	public Point3D ConvertToGps(Point3D p) ;
//	/**
//	 * Convert GPS Point3D toi Cartesian Point3D
//	 * @param p Point3D GPS 
//	 * @return Point3D Cartesian
//	 */
//	public Point3D ConvertToCartesian(Point3D p);
//}
