package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Coords.MyCoords;
import Geom.Point3D;
/**
 * Test of My_Coords
 * @author Mimoun Shimon and Omer Paz
 *
 */
class MyCoordsTest extends MyCoords {

	MyCoords mc;
	Point3D gps0;
	Point3D gps1;
	double expectedValue;
	double acutalValue;

	@BeforeEach
	void setUp() throws Exception {
		gps0=new Point3D(32.103315,35.209039,670);
		gps1=new Point3D(32.106352,35.205225,650);
		expectedValue = 0;
		acutalValue = 0;

		mc = new MyCoords();
	}

		@Test
		void testAdd() {
			
			Point3D meter = new Point3D(20,30,0);
			Point3D acutal_added_Point = add(gps0,meter);
			Point3D expcetedPoint = new Point3D(32.10709532470852,35.20917679211647,6371698.494419785);
			if(!acutal_added_Point.equals(expcetedPoint)) {
				fail("You Got wrong with add function");

			}
				
		}

	@Test
	void testDistance3d() {
		acutalValue = mc.distance3d(gps0, gps1); // check the distance, and the resulte need to be 493.504487890462.
		if (acutalValue != 493.504487890462) 
			fail("You Got wrong with claculte the distance");
	}

	@Test
	void testVector3D() {

		Point3D p0 = gps0.ConvertToCartesian();
		Point3D p1 = gps1.ConvertToCartesian();
		Point3D expctedPoint = new Point3D(p1.x()-p0.x(),p1.y()-p0.y(),p1.z()-p0.z());
		Point3D acutalPoint  = vector3D(gps0, gps1);

		if(!expctedPoint.equals(acutalPoint))
			fail("You Got Worng with the verktor3D function");

	}

	@Test
	void testAzimuth_elevation_dist() {
		double[] acutal_Azimuth_elevation_dist  = azimuth_elevation_dist(gps0, gps1);
		System.out.println(acutal_Azimuth_elevation_dist[0]);
		System.out.println(acutal_Azimuth_elevation_dist[1]);
		System.out.println(acutal_Azimuth_elevation_dist[2]);
		if(acutal_Azimuth_elevation_dist[0] != 321.47050096915774) 
			fail("You got worng with the north_angle function in point ");

		if(acutal_Azimuth_elevation_dist[1] != 2.3226323668828446) 
			fail("You got worng with the elevation calcaulte");

		if(acutal_Azimuth_elevation_dist[2] != 493.504487890462) 
			fail("You got worng with the distance3d at pointe");

	}
		@Test
		void testIsValid_GPS_Point() {
			
			if(!isValid_GPS_Point(gps0)) {
				fail("You got worng with the isvalid function");

			}
		}

}
