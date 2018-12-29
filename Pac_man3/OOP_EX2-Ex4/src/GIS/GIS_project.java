package GIS;


/**
 * this interface represents a GIS Project of elemnts and include metadata from foreach project.
 *
 * @author Shimon Mimoun and Omer Paz
 *
 */


import java.util.Set;

public interface GIS_project extends Set<GIS_layer>{
	
	
	/**
	 * this function return the specific meta data for this project.
	 * @return Meta_data
	 */
	
	public Meta_data get_Meta_data(); 
	
}
