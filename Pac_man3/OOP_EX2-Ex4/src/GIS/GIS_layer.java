package GIS;
import java.util.Set;

/**
 * this interface represents a GIS layer of elemnts and include metadata from foreach layer.
 *
 * @author Shimon Mimoun and Omer Paz
 *
 */


public interface GIS_layer extends Set<GIS_element>{
	
	
	/**
	 * this function return the specific meta data for this layer.
	 * @return Meta_data
	 */
	public Meta_data get_Meta_data(); 
	
}
