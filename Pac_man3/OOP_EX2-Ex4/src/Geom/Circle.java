package Geom;
/**
 * This class represents a 2D (open set) circle
 * @author Mimoun Shimon and Omer Paz 
 *
 */
public class Circle implements Geom_element {
	private Point3D _cen;
	private double _radius;
	
	/**
	 * Represents  a constractor from my class 
	 * @param cen Receive the central point
	 * @param rad Receive the radius
	 */
	public Circle(Point3D cen, double rad) {
		this.set_cen(new Point3D(cen));
		this.set_radius(rad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double distance3D(Point3D p) {
		double d = p.distance3D(this.get_cen());
		double dr = d - this.get_radius();
		double ans = Math.max(0, dr);
		return ans;
	}
	/**
	 * Check if  Point3D is inRange
	 * @param p Receiv Point
	 * @return True if ok ; False if no ok 
	 */
	public boolean inRange(Point3D p) {
		
		if (this._cen.distance3D(p) <= this._radius) {
			return true;
		}
		return false;
	}
	
	// end of helping functions // 

	@Override
	public double distance2D(Point3D p) {
		// TODO Auto-generated method stub
		return -1;
	}
/**
 * Getter Method 
 * @return The Point of the Center
 */
	public Point3D get_cen() {
		return _cen;
	}
/**
 * Setter Methode 
 * @param _cen Receiv new Point  of Center
 */
	public  void set_cen(Point3D _cen) {
		this._cen = _cen;
	}
/**
 * Getter Method
 * @return a Raduis of the Circle
 */
	public double get_radius() {
		return _radius;
	}
/**
 *Setter Method
 * @param _radius Receiv a new Raduis
 */
	private void set_radius(double _radius) {
		this._radius = _radius;
	}

}
