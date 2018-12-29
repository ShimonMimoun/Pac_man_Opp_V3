package Geom;

import java.io.Serializable;
/**
 * This class represents a Point3D and any methods it may need as a Point
 * more:https://docs.oracle.com/cd/E17802_01/j2se/javase/technologies/desktop/java3d/forDevelopers/J3D_1_3_API/j3dapi/javax/vecmath/Point3d.html
 * @author Mimoun Shimon and Omer Paz
 *
 */
public class Point3D implements Geom_element, Serializable 
{
	/**
	 * This class represents a 3D point in space.
	 */
	private static final long serialVersionUID = 1L;
	private double _x,_y,_z;
	public static final int RADUIS_EARTH = 6371000;
	
	/**
	 * Constractor in 3 coordinates
	 * @param x the X Point
	 * @param y the Y Point
	 * @param z the Z Point
	 */
	public Point3D(double x,double y,double z) 
	{
		_x=x;
		_y=y;
		_z=z;
	}
	/**
	 * Constractor 
	 * @param lat Latitude GPS
	 * @param lon Longitude GPS
	 * @param AltitudeMeters Altitude GPS
	 */
	public Point3D(String lat , String lon , String AltitudeMeters) {
		String_2_Point3D(lat, lon ,AltitudeMeters);
	}

	/**
	 * Copy Constractor
	 * @param p receiv Point3D
	 */
	public Point3D(Point3D p) 
	{
		_x=p.x();
		_y=p.y();
		_z=p.z();
	}
	/**
	 * Constractor in 2 coordinates
	 * @param x The X Point
	 * @param y The Y Point
	 */
	public Point3D(double x,double y) 
	{this(x,y,0);}
	/**
	 * Constractor in String
	 * @param s Receiv String Points
	 */
	public Point3D(String s) {
		String[] a = s.split(",");
		_x = Double.parseDouble(a[0]);
		_y = Double.parseDouble(a[1]);
		_z = Double.parseDouble(a[2]);
	}
	///////////////////////////////////////////////////////////////////////////
	////////////////////////////       methods        /////////////////////////
	///////////////////////////////////////////////////////////////////////////

	/**
	 * Return Values of x 
	 * @return The value of X
	 */
	public double x() {return _x;}
	/**
	 * Return Values of Y
	 * @return The value of Y
	 */
	public double y() {return _y;}
	/**
	 * Return Values of Z 
	 * @return The value of Z
	 */
	public double z() {return _z;}
	/**
	 * Return Values of x in Casting to int
	 * @return The value of X
	 */
	public int ix() {return (int)_x;}
	/**
	 * Return Values of Y in Casting to int
	 * @return The value of Y
	 */
	public int iy() {return (int)_y;}
	/**
	 * Return Values of Z in Casting to int
	 * @return The value of Z
	 */
	public int iz() {return (int)_z;}
/**
 * Methode add Point 
 * @param p Point 3D to add
 */
	public void add(Point3D p) { add(p._x,p._y,p._z);}
	/**
	 * Methode add X,Y,Z
	 * @param dx the x Point
	 * @param dy the y Point
	 * @param dz the z Point
	 */
	public void add(double dx, double dy, double dz) {
		_x+=dx;_y+=dy;_z+=dz;
	}
	/**
	 * Methode add X,Y
	 * @param x the x Point
	 * @param y the y Point
	 */
	public void add(double x, double y){this.add(x,y,0);}
/**
 * Methode toString To Print the Object 
 * for Example Point3D test: test.toString --> "100,500,30"
 */
	public String toString() 
	{
		return ""+_x+","+_y+","+_z;
	}
	
	public double distance2D(Point3D p2) { 
		return this.distance3D(p2.x(), p2.y(), this.z());
	}
	public double distance3D(Point3D p2) {
		return this.distance3D(p2.x(), p2.y(), p2.z());}
	/**
	 * Distance between Two Point3D in 3 Coordinates
	 * @param x the X Point
 	 * @param y the Y Point
	 * @param z the Z Point
	 * @return
	 */
	public double distance3D(double x, double y , double z)
	{
		double dx = _x-x;
		double dy = _y-y;
		double dz = _z-z;
		double t = dx*dx+dy*dy+dz*dz;
		return Math.sqrt(t);
	}
/**
 * Check in Two Point3D are equal (3 Coordinates)
 * @param p2 Point 3D to be compared
 * @return True if equals, False if no equal
 */
	public boolean equals(Point3D p2)
	{
		return ( (_x==p2._x) && (_y==p2._y) && (_z==p2._z) );
	}
	/**
	 * Check in Distance Between two Point3D are bigger distance
	 * @param p2  Point 3D to be compared
	 * @param dist distance to compare
	 * @return True if equal , false if no equal 
	 */
	public boolean close2equals(Point3D p2, double dist)
	{
		return ( this.distance3D(p2)< dist );
	}
	/**
	 * Check in Two Point3D are equal (2 Coordinates)
	 * @param p2 Point 3D to be compared
	 * @return True if equals, False if no equal
	 */
	public boolean equalsXY (Point3D p)
	{return p._x == _x && p._y == _y;}

	/**
	 * Export to File the Point3D (2 Coordinates)
	 * @return A file ready
	 */
	public String toFile()  {return _x+","+_y+","+_z;}
	/**
	 * Export to File the Point3D (3 Coordinates)
	 * @return A file ready
	 */
	public String toFile1()  {return "Point3D "+_x+" "+_y+" "+_z;}

	////////////////////////////////////////////////////////////////////////////////////////

	public final static int ONSEGMENT = 0,  LEFT = 1, RIGHT = 2, INFRONTOFA = 3, BEHINDB = 4, ERROR = 5;
	public final static int DOWN = 6, UP = 7;

	/** return up iff this point is above the SEGMENT (not the line) */
	public int pointLineTest2(Point3D a, Point3D b) {
		int flag = this.pointLineTest(a,b);
		if(a._x < b._x ) {
			if(a._x<=_x && b._x>_x) {
				if (flag == LEFT) return DOWN;
				if (flag == RIGHT) return UP;
			}
		}
		else 
			if(a._x > b._x ) {
				if(b._x<=_x && a._x>_x) {
					if (flag == RIGHT) return DOWN;
					if (flag == LEFT) return UP;
				}
			}	
		return flag;
	}


/**
 * Return A Line betwenn two Point3D
 * @param a First Point
 * @param b second Point
 */
	public int pointLineTest(Point3D a, Point3D b) {

		if(a== null || b==null || a.equalsXY(b)) return ERROR;

		double dx = b._x-a._x;
		double dy = b._y-a._y;
		double res = dy*(_x-a._x)-dx*(_y-a._y);

		if (res < 0) return LEFT;
		if (res > 0) return RIGHT;

		if (dx > 0) {
			if (_x < a._x) return INFRONTOFA;
			if (b._x < _x) return BEHINDB;
			return ONSEGMENT;
		}
		if (dx < 0) {
			if (_x > a._x) return INFRONTOFA;
			if (b._x > _x) return BEHINDB;
			return ONSEGMENT;
		}
		if (dy > 0) {
			if (_y < a._y) return INFRONTOFA;
			if (b._y < _y) return BEHINDB;
			return ONSEGMENT;
		}
		if (dy < 0) {
			if (_y > a._y) return INFRONTOFA;
			if (b._y > _y) return BEHINDB;
			return ONSEGMENT;
		}
		return ERROR;
	}


	////////////////////////////////////////////////////////////////
	public void rescale(Point3D center, Point3D vec) {
		if(center!=null && vec != null)
			rescale(center,vec.x(),vec.y(),vec.z());
	}

	public void rescale(Point3D center, double size) {
		if(center!=null && size>0)
			rescale(center,size,size,size);
	}
	private void rescale(Point3D center, double sizeX,double sizeY, double sizeZ) {
		_x = center._x + ((_x - center._x) * sizeX);
		_y = center._y + ((_y - center._y) * sizeY);
		_z = center._z + ((_z - center._z) * sizeZ);
	} 

	public void rotate2D(Point3D center, double angle) {
		// angle -1/2PI .. 1/2Piregular degrees. 
		_x = _x - center.x();
		_y = _y - center.y();
		double a = Math.atan2(_y,_x);
		//	System.out.println("Angle: "+a);
		double radius = Math.sqrt((_x*_x) + (_y*_y));
		_x = (center.x() +  radius * Math.cos(a+angle));
		_y = (center.y() +  radius * Math.sin(a+angle));
	}								
	/** computes the angleXY between p1 and p2 in RADIANS: <br><br>
	up:(PI/2)  , down (-PI/2) , right(0),  left(+- PI).   [-PI, +PI]	*/
	public double angleXY(Point3D p) {
		if(p==null) throw new RuntimeException("** Error: Point3D angle got null **");
		return Math.atan2((p._y-_y), (p._x-_x));
	}
	/** computes the angleXY between p1 and p2 in RADIANS: <br><br>
	up:(PI/2)  , down (1.5PI) , right(0),  left(PI).   [0,2PI].	*/
	public double angleXY_2PI(Point3D p) {
		if(p==null) throw new RuntimeException("** Error: Point3D angle got null **");
		double ans = Math.atan2((p._y-_y), (p._x-_x));
		if (ans<0) ans = 2*Math.PI+ans;
		return ans;
	}
	/** computes the angleZ between p1 and p2 in RADIANS */ 							
	public double angleZ(Point3D p) {
		if(p==null) throw new RuntimeException("** Error: Point3D angleZ got null **");
		return Math.atan2((p._z-_z), this.distance2D(p));
	}	
	/** return the (planer angle of the vector between this --> p, in DEGREES, in a
	 * compass order: north 0, east 90, south 180, west 270.
	 * @param p is the end point of the vector (z value is ignored). 
	 * @return angle in compass styye [0,360).
	 */
	public double north_angle(Point3D p) {
		double ans = 0;
		double a_rad = Math.atan2((p._y-_y), (p._x-_x));
		double a_deg = Math.toDegrees(a_rad);
		if(a_deg<=90) ans = 90-a_deg;
		else ans = 450-a_deg;
		return ans;
	}
	/** return the vertical angles in DEGREES of the vector this-->p
	 * 
	 * */
	public double up_angle(Point3D p) {
		double ans = 0;
		ans = Math.atan2((p._z-_z), this.distance2D(p));
		return Math.toDegrees(ans);
	}
	/** return the vertical angles in DEGREES of the vector this-->p, 
	 *  @param h: is the extra height of the point p (used by GISElement).
	 * */
	public double up_angle(Point3D p, double h) {
		double ans = 0;
		ans = Math.atan2((p._z+h-_z), this.distance2D(p));
		return Math.toDegrees(ans);

	}
	/// Convert Functions \\\
	/**
	 * Convert Point3D Cartesien to Gps
	 * @return Point GPS
	 */
	public Point3D ConvertToGps() {		

		double x=Math.asin(_z/RADUIS_EARTH)*180/Math.PI;
		double y=Math.atan2(_y, _x)*180/Math.PI;
		double r =Math.sqrt(Math.pow(_x, 2)+Math.pow(_y, 2)+Math.pow(_z, 2))-RADUIS_EARTH;
		return new Point3D (x,y,r);
		
	}
/**
 * Convert Point3D Gps To Cartesian 
 * @return Point Cartesian
 */
	public Point3D ConvertToCartesian() {


		double Gps_x = Math.cos(_y/180*Math.PI) * Math.cos(_x/180*Math.PI)*(RADUIS_EARTH+_z);;
		double Gps_y = Math.sin(_y/180*Math.PI) * Math.cos(_x/180*Math.PI)*(RADUIS_EARTH+_z);
		double Gps_z = (RADUIS_EARTH+_z)*Math.sin(_x/180*Math.PI);


		return new Point3D(Gps_x,Gps_y,Gps_z);
	}
	/**
	 * Casting String to Points 
	 * @param lat Point String Latitude
	 * @param lon Point String Lontitude
	 * @param AltitudeMeters Point String Altitude 
	 */
	public void String_2_Point3D(String lat , String lon , String AltitudeMeters) {

		_x = Double.parseDouble(lat);
		_y = Double.parseDouble(lon);
		_z = Double.parseDouble(AltitudeMeters);

	}



	////////////////////////////////////////////////////////////////

	/** transform from radians to angles */
	public static double r2d(double a) { return Math.toDegrees(a);}
	/** transform from radians to angles */
	public static double d2r(double a) { return Math.toRadians(a);}
	////////////////////////////////////////////////////////////////////////////////
}
