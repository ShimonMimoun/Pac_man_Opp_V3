package File_format;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import GIS.GIS_Layer_using;
import GIS.GIS_projet_using;

/**
 * Class who knows how to scan files and find Csv files this class
 * has several functions in addition, like converting all csv files into one kml, or into several different kml
 * @author  Shimon Mimoun and Omer Paz
 *
 */
public class MultiCSV {
	/**
	 * Returns the list of csv files found in a folder.
	 * @param dir Destination of the Csv files to search. For exemple: "OOP_EX2-Ex4/data/"
	 */
	public  static void  listDirectory(String dir) throws IOException {

		String Outpout=dir;
		dir=CsvFileHelper.getResourcePath(dir);

		ArrayList <String> listeFichiers = new ArrayList<String>();

		String []s = new File(dir).list(); 
		Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+\\.csv"); 
		if (s != null) {

			for (int i=0; i<s.length;i++) 
			{ 
				Matcher m = p.matcher(s[i]); 
				if ( m.matches()) 
				{
					listeFichiers.add(s[i]); 
				} 
			} 

		}

		try {
			CrateKML_Project(listeFichiers,Outpout);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CreateKml_foreach_CSV(listeFichiers,Outpout);
	}    
	/**
	 * Function that receives a directory with all csv files and converts them into a single Kml using Class Gis
	 * @param Repertoire directory of CSV files
	 * @param Destination destination of kml files
	 * @throws ParseException 
	 */
	public static void CrateKML_Project(ArrayList<String> Repertoire,String Destination)throws IOException, ParseException
	{
		GIS_projet_using myProject = new GIS_projet_using();
		for (int i = 0; i < Repertoire.size(); i++) {

			File file = CsvFileHelper.getResource(Destination+Repertoire.get(i));
			GIS_Layer_using myLayer= csv2kml.ReadCsv_Layer(csv2kml.readFile(file));
			myProject.add(myLayer);
			
		}
		
		myProject.to_KML("OOP_EX2-Ex4/data/MyProject.kml");

	}
	/**
	 * Function that receives a directory with all csv files and converts them into several different kml.
	 * @param Repertoire directory of CSV files
	 * @param Destination destination of kml files
	 */
	public static void CreateKml_foreach_CSV(ArrayList<String> Repertoire,String Destination) throws IOException
	{

		for (int i = 0; i < Repertoire.size(); i++) {

			File file = CsvFileHelper.getResource(Destination+Repertoire.get(i));
			csv2kml.to_KML(csv2kml.readFile(file), Destination+Repertoire.get(i).substring(0, Repertoire.get(i).length()-4)+".kml"); 

		}
		System.out.println("Conversion Complete of Folder");

	}

}