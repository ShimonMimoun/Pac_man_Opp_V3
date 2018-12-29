package GIS;

import java.text.ParseException;

import Geom.Point3D;
/**
 * This interface represents a meta data such as (UTD , Oriantation , Color and String).
 * @author Shimon Mimoun and Omer Paz
 *
 */
public interface Meta_data {
	
	/**
	 * Universal Time Clock associated with this data
	 * @return long
	 */
	public long getUTC() throws Exception;	
	/** @return a String representing this data */
	public String toString();
	/**
	 * calculate the orientation: yaw, pitch and roll associated with this data
	 * @return Point3D;
	 */
	public Point3D get_Orientation();
	
	/**
	 * the color of the metadata sach as (red,green,yellow).
	 * @param Color
	 */
	
	public void setColor(String Color);
	public void setUTC(String DateAndTime) throws ParseException;
	

}