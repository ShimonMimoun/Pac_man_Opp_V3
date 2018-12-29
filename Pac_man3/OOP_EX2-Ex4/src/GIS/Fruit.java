package GIS;

import Geom.Point3D;
/**
 * This Class represents the Fruits of the Pacman Gam.
 * To remind him the fruits give us points in the official game
 * @author Mimoun Shimon and Omer Paz
 *
 */
public class Fruit {

	
	public Point3D FuritPoint;
	private int Weight;
/**
 * Constractor
 * @param p Receiv Point(x,y)
 * @param Weight Receiv Weight
 */
	public Fruit(Point3D p, int Weight) {
		
		this.FuritPoint = p;
		this.Weight = Weight;
	}
	/**
	 * Copy Constractor
	 * @param f Receiv new Fruit to Copy
	 */ 
	public Fruit(Fruit f) {
		this(f.FuritPoint, f.Weight);
	}

/**
 * Getter Method
 * @return the Weight
 */
	public int getWeight() {
		return Weight;
	}
/**
 * Geter Methode 
 * @return the Point of Fruit 
 */
	public Point3D getFruitPoint() {
		return FuritPoint;
	}
	public void setFruitPoint(Point3D p) {
		this.FuritPoint = p;
	}


	@Override
	public String toString() {
		return "Furit [FuritPoint=" + FuritPoint.toString() + ", Weight=" + Weight + "]";
	}


}
