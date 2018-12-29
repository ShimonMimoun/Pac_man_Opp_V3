package File_format;

import java.io.File;
import java.io.IOException;
/**
 * Class that starts the conversation of the conversion from csv to kml,
 * As well as launching the scan of a given folder in order to check all existing Csv files and convert them into a single KML file.
 * @author  Shimon Mimoun and Omer Paz
 *
 */
public class Lunch {
	
/**
 * Main of Lunch
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		File file = CsvFileHelper.getResource("OOP_EX2-Ex4/data/WigleWifi_20171203085618.csv");
		//csv2kml.to_KML(csv2kml.readFile(file), "OOP_EX2-Ex4/data/Omer2.kml");
		
		//made a project from all the csv files.
		MultiCSV.listDirectory("OOP_EX2-Ex4/data/");
		
	}

}