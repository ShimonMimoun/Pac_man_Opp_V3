package Coords;

import Geom.Point3D;

/**
 * This class allows you to perform many functions on 3D Points Cartesian or polar.
 * which is defined by a GPS point for example (32.106352,35,205225,650).
 * for more explanation:
 * https://en.wikipedia.org/wiki/Spherical_coordinate_system
 * @author Shimon Mimoun and Omer Paz
 *
 */
public class MyCoords implements coords_converter {
	
	/**
	 * RADUIS_EARTH = Constant that defines the radius of the earth.  
	 * https://en.wikipedia.org/wiki/Earth_radius
	 */
	public static final int RADUIS_EARTH = 6371000;
	

	@Override
	
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		Point3D covertedCartisian = gps.ConvertToCartesian();
		
		double ans_x = covertedCartisian.x()+local_vector_in_meter.x();
		double ans_y = covertedCartisian.y()+local_vector_in_meter.y();
		double ans_z = covertedCartisian.z()+local_vector_in_meter.z();
		
		Point3D ans = new Point3D(ans_x,ans_y,ans_z);


	return ans.ConvertToGps();
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		
		Point3D gps0Change = gps0.ConvertToCartesian();
		Point3D gps1Change = gps1.ConvertToCartesian();
		
		return Math.abs(gps0Change.distance3D(gps1Change));

			// TODO Auto-generated method stub
	
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		
		Point3D gps0ToMeters = gps0.ConvertToCartesian();
		Point3D gps1ToMeters = gps1.ConvertToCartesian();
		
		double m_x = gps1ToMeters.x()-gps0ToMeters.x();
		double m_y = gps1ToMeters.y()-gps0ToMeters.y();
		double m_z = gps1ToMeters.z()-gps0ToMeters.z();
		
		Point3D ans = new Point3D(m_x,m_y,m_z); 

		return ans.ConvertToGps();
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {

		double[] ans = new double[3];
		ans[0] = gps1.north_angle(gps0);
		ans[1] = Math.toDegrees(Math.asin((gps0.z()-gps1.z())/(distance3d(gps0 , gps1))));
		ans[2] = distance3d(gps1, gps0);
		
		return ans;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		
		return (p.x()<-180 || p.x() >180 ||p.y() <-90 || p.y() >90 || p.z() <-450) ? false : true;
		
	
	}
	
	/// covnert functions ///
	
	
	
}
