package GIS;

import Geom.Geom_element;
import Geom.Point3D;

/**
 * This interface represents a GIS element with geometric representation and meta data such as:
 * Orientation, color, string, timing...
 * @author Shimon Mimoun and Omer Paz
 *
 */
public interface GIS_element {
	
	/**
	 * this function return the specific Geom.
	 * @return Geom_element
	 */
	public Geom_element getGeom();
	/**
	 * get the meta data the for  specific element (UTF,Color,Oriantation)..
	 * @return Meta_data
	 */
	public Meta_data getData();
	
	/**
	 * this Function get a vertor in meters and change the point3D with heis prameters.
	 * 
	 * @param vec
	 */
	public void translate(Point3D vec);
}
