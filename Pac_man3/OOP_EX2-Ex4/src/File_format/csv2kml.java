package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import GIS.Gis_element_using;
import GIS.GIS_Layer_using;



/**
 * This class can convert a Csv file into Kml As a reminder, a Csv file is a file separated by commas a
 * Kml file is a Google Geographical file.
 * More: https://he.wikipedia.org/wiki/CSV
 * https://developers.google.com/kml/
 * 
 * @author  Shimon Mimoun and Omer Paz
 *
 */
public class csv2kml {


	/**
	 * This class receives a file csv is knows how to read it in order to record it is given in an arraylist.
	 * @param file Csv file
	 * @return List<String[]> of Data for file 
	 */
	public static List<String[]> readFile(File file) throws IOException {


		List<String[]> result = new ArrayList<String[]>();

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			result.add(line.split(","));

		}


		br.close();
		fr.close();
		return result;
	}
	/**
	 * This class receives a file csv is knows how to read it in order to record it is given in an arraylist.
	 * @param file Csv String 
	 * @return List<String[]> of Data for file 
	 */
	public static List<String[]> readFile2(String file) throws IOException {


		List<String[]> result = new ArrayList<String[]>();

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		for (String line = br.readLine(); line != null; line = br.readLine()) {
			result.add(line.split(","));

		}


		br.close();
		fr.close();
		return result;
	}

	/**
	 * Get a list with the read data from a List file, Send to Gis
	 * @param result List<String[]> of Data for file 
	 * @return GIS_Layer_using with the csv data
	 * @throws ParseException 
	 */
	public static GIS_Layer_using ReadCsv_Layer(List<String[]> result) throws ParseException
	{
		GIS_Layer_using myLayer = new GIS_Layer_using();
		// Add color Random
		String Color []= {"red","yellow","green"};
		int idx = new Random().nextInt(Color.length);
		String random = (Color[idx]);

		for (int i = 2; i < result.size(); i++) {
			String[] s = result.get(i);
			Gis_element_using myelm  =new Gis_element_using(s[0],s[1],s[2],s[4],s[5],s[6],s[7],s[8],s[9],s[10]);

			myelm.getData().setUTC(s[3]);
			myLayer.add(myelm);
			myelm.getData().setColor(random);


		}
		//Add color in Layer
		myLayer.get_Meta_data().setColor(random);
		return myLayer;

	}
	/**
	 * Function that can write a Kml file from a Csv file
	 * @param a List<String[]> of Data for file.
	 * @param output Localization of the export of the file (with the name of the file).
	 * @return Kml file
	 */
	static void to_KML(List<String[]> a, String output) {


		ArrayList<String> content = new ArrayList<String>();
		String kmlstart = 
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\">\r\n" + 
						"<IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle>\r\n" + 
						"</Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle>\r\n" + 
						"</Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style>\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"<Folder><name>Wifi Networks</name>\n\n";
		content.add(kmlstart);
		String[] nameData = a.get(1);
		String kmlend = "</Folder>\n" + 
				"</Document>\n</kml>";
		try{
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 2; i < a.size(); i++) {
				String[] s = a.get(i);

				String kmlelement ="<Placemark>\n" +
						"<name><![CDATA["+s[1]+"]]></name>\n" +
						"<description>"+
						"<![CDATA[B"
						+nameData[0]+": <b>"+s[0]+" </b><br/>"
						+nameData[2]+": <b>"+s[2]+" </b><br/>"
						+nameData[3]+": <b>"+s[3]+" </b><br/>" // time and date
						+nameData[4]+": <b>"+s[4]+" </b><br/>"
						+nameData[5]+": <b>"+s[5]+" </b><br/>" // rssi
						+nameData[6]+": <b>"+s[6]+" </b><br/>" // latitauo
						+nameData[7]+": <b>"+s[7]+" </b><br/>" // logntiue
						+nameData[8]+": <b>"+s[8]+" </b><br/>" // altito to meter
						+nameData[9]+": <b>"+s[9]+" </b><br/>" //accaryto meter
						+nameData[10]+": <b>"+s[10]+" </b><br/>" //type wifi

						+"]]></description>\n" +
						"<Point>\n" +
						"<coordinates>"+s[7]+","+s[6]+"</coordinates>" +
						"</Point>\n" +
						"</Placemark>\n";


				content.add(kmlelement);


			}
			content.add(kmlend);
			bw.write(String.join("\n", content));
			System.out.println("Operation Complete");
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}








