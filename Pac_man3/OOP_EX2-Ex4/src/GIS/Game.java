package GIS;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Algorithm.ShortestPathAlgo;
import Coords.Map;
import File_format.csv2kml;
import Geom.Point3D;

/**
 * This class represents the function that manages the games (pacmans, fruits ..)
 * It has many features.
 * @author Mimoun Shimon and Omer Paz
 *
 */

public class Game {

	public  ArrayList<Packman> Packman_arr = new ArrayList<>();
	public  ArrayList<Fruit> Fruits_arr = new ArrayList<>();
	public 	String file_directory;
	public Map theMap = new Map();



/**
 * Constractor
 * @param p Receiv Packman
 * @param f Receiv Fruit
 */

	public Game(ArrayList<Packman> p , ArrayList<Fruit> f) {
		this.Packman_arr = p;
		this.Fruits_arr = f;

	}
/**
 * Getter Method
 * @return  a Directory of file
 */
	public String getDiractroy() {
		return this.file_directory;
	}
	/**
	 * Setter Method
	 * @param file_directory  Receiv a new file directory
	 */
	public void setfile_directory(String file_directory) {
		this.file_directory = file_directory;
	}








	public  void save2Csv() throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(new File(getDiractroy()+".csv"));
		StringBuilder sb = new StringBuilder();
		String[] heders = {"Type","id"	,"Lat"	,"Lon"	,"Alt"	,"Speed/Weight"	,"Radius"};

		for (int i = 0; i < heders.length; i++) {
			sb.append(heders[i]);
			sb.append(",");	
		}
		sb.append(this.Packman_arr.size());
		sb.append(',');
		sb.append(this.Fruits_arr.size());
		sb.append('\n');

		for (int i = 0; i < Packman_arr.size(); i++) {
			Packman_arr.get(i).packLocation = theMap.Pixel2GPS(Packman_arr.get(i).getPoint().x(), Packman_arr.get(i).getPoint().y());
		}
		for (int i = 0; i < Fruits_arr.size(); i++) {
			Fruits_arr.get(i).FuritPoint = theMap.Pixel2GPS(Fruits_arr.get(i).getFruitPoint().x(), Fruits_arr.get(i).getFruitPoint().y());

		}

		for (int i = 0; i < this.Packman_arr.size(); i++) {
			sb.append("P");
			sb.append(',');
			sb.append(i);
			sb.append(',');
			sb.append(Packman_arr.get(i).packLocation.x());
			sb.append(',');
			sb.append(Packman_arr.get(i).packLocation.y());
			sb.append(',');
			sb.append(Packman_arr.get(i).packLocation.z());
			sb.append(',');
			sb.append(this.Packman_arr.get(i).getSpeed());
			sb.append(',');
			sb.append(this.Packman_arr.get(i).getradius());
			sb.append('\n');
		}
		for (int i = 0; i < Fruits_arr.size(); i++) {
			sb.append("F");
			sb.append(',');
			sb.append(i);
			sb.append(',');
			sb.append(Fruits_arr.get(i).FuritPoint.x());
			sb.append(',');
			sb.append(Fruits_arr.get(i).FuritPoint.y());
			sb.append(',');
			sb.append(Fruits_arr.get(i).FuritPoint.z());
			sb.append(',');	
			sb.append(this.Fruits_arr.get(i).getWeight());
			sb.append('\n');

		}
		sb.append('\n');

		pw.write(sb.toString());
		pw.close();

	}


	public void Csvread() throws IOException{		
		List<String[]> s = csv2kml.readFile2(getDiractroy());

		for (int i = 1; i < s.size(); i++) {
			String[] row = s.get(i);

			if(row[0].equals("P")) {
				Point3D p = new Point3D(row[2],row[3],row[4]);
				p = theMap.GPS2Pixel(p);

				double speed = Double.parseDouble(row[5]);
				double radius = Double.parseDouble(row[6]);
				Packman_arr.add(new Packman(p, speed, radius));	
			}
			if(row[0].equals("F")) {
				Point3D p = new Point3D(row[2],row[3],row[4]);
				p = theMap.GPS2Pixel(p);
				int Weight = Integer.parseInt(row[5]);
				Fruits_arr.add(new Fruit(p, Weight));
			}
		}


	}




	public void save_to_kml() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(getDiractroy()+".kml"));



		ArrayList<String> content = new ArrayList<String>();
		String kmlstart = 
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document>\r\n<name> Points with TimeStamps</name>\r\n <Style id=\"red\">\r\n" + 
						"<IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle>\r\n" + 
						"</Style><Style id=\"Packman\"><IconStyle><Icon><href>http://www.iconhot.com/icon/png/quiet/256/pac-man.png</href></Icon></IconStyle>\r\n" + 
						"</Style><Style id=\"Fruit\"><IconStyle><Icon><href>https://www.clipartmax.com/png/full/10-109149_heart-outline-clipart.png</href></Icon></IconStyle></Style>\r\n" + 
						"\r\n" + 
						"    <Style id=\"check-hide-children\">\r\n" + 
						"      <ListStyle>\r\n" + 
						"        <listItemType>checkHideChildren</listItemType>\r\n" + 
						"      </ListStyle>\r\n" + 
						"    </Style>\r\n" + 
						"    <styleUrl>#check-hide-children</styleUrl>"+
						"\r\n"+"<Folder><name>GAME PACKMAN</name>\n\n";

		content.add(kmlstart);
		String[] nameData = {"Type","id","Lat","Lon","Speed/Weight"	,"Radius"};

		String kmlend = "</Folder>\n" + 
				"</Document>\n</kml>";

		ArrayList<Packman> myPackmens = new ArrayList<>();
		ShortestPathAlgo algo = new ShortestPathAlgo(this);

		myPackmens = algo.algoMultiPackmans();

		for (int i = 0; i < myPackmens.size(); i++) {
			Path p = algo.algoSinglePackman(myPackmens.get(i));
			myPackmens.get(i).getPath().setPath(p.TheCurrentPath());
			myPackmens.get(i).getPath().setTheTotalTime(p.getTheTime());

		}
		


		for (int i = 0; i < myPackmens.size(); i++) {
			myPackmens.get(i).packLocation = theMap.Pixel2GPS(myPackmens.get(i).getPoint().x(), myPackmens.get(i).getPoint().y());

			for (int j = 0; j < myPackmens.get(i).getPath().TheCurrentPath().size(); j++) {
				myPackmens.get(i).getPath().TheCurrentPath().get(j).FuritPoint =
						theMap.Pixel2GPS( myPackmens.get(i).getPath().TheCurrentPath().get(j).getFruitPoint().x(),  myPackmens.get(i).getPath().TheCurrentPath().get(j).getFruitPoint().y());

			}
		}

		LocalDateTime now_start=LocalDateTime.now();
		LocalDateTime temp_start_official=now_start;
		LocalDateTime now_start_end=temp_start_official.plusHours(6);
		LocalDateTime temp_start=now_start;


		int j=(-1);

		for (Packman packman_for : myPackmens)
		{
			j++;

			now_start=	temp_start_official;

			String kmlelement ="<Placemark>\n" +
					"<name><![CDATA[ PACKMAN START "+j+"]]></name>\n" +
					"<description>"+
					"<![CDATA["
					+nameData[0]+": <b> PACKMAN  </b><br/>"
					+nameData[1]+": <b> PACKMAN Start Number"+j+" </b><br/>"
					+nameData[2]+": <b>"+packman_for.packLocation.x()+" </b><br/>" 
					+nameData[3]+": <b>"+packman_for.packLocation.y()+" </b><br/>" 
					+nameData[4]+": <b>"+packman_for.getSpeed()+" </b><br/>" 
					+nameData[5]+": <b>"+packman_for.getradius()+" </b><br/>" // altito to meter


					+"]]></description>\n" +
					"<TimeStamp>\r\n" + 
					"        <when>"+now_start+"</when>\r\n" + 
					"      </TimeStamp>"+
					"<styleUrl>#Packman</styleUrl>"+
					"<Point>\n" +
					"<coordinates>"+packman_for.packLocation.y()+","+packman_for.packLocation.x()+"</coordinates>" +
					"</Point>\n" +
					"</Placemark>\n";


			content.add(kmlelement);


			if(packman_for.getPath().TheCurrentPath().size()==0)
			{

				String kmlelement2 ="<Placemark>\n" +
						"<name><![CDATA[ PACKMAN Without PATH "+j +"]]></name>\n" +
						"<description>"+
						"<![CDATA["
						+nameData[0]+": <b> PACKMAN  </b><br/>"
						+nameData[1]+": <b> PACKMAN  Without PATH Number"+j+" </b><br/>"
						+nameData[2]+": <b>"+packman_for.packLocation.x()+" </b><br/>" 
						+nameData[3]+": <b>"+packman_for.packLocation.y()+" </b><br/>" 
						+nameData[4]+": <b>"+packman_for.getSpeed()+" </b><br/>" 
						+nameData[5]+": <b>"+Packman_arr.get(j).getradius()+" </b><br/>" // altito to meter



						+"]]></description>\n" +
						"<TimeStamp>\r\n" + 
						"        <when>"+now_start_end+"</when>\r\n" + 
						"      </TimeStamp>"+
						"<styleUrl>#Packman</styleUrl>"+
						"<Point>\n" +
						"<coordinates>"+packman_for.packLocation.y()+","+packman_for.packLocation.x()+"</coordinates>" +
						"</Point>\n" +
						"</Placemark>\n";


				content.add(kmlelement2);

			}
				
				for (int i = 0; i < packman_for.getPath().TheCurrentPath().size(); i++) {

					now_start=now_start.plusMinutes(5);
					temp_start=now_start.plusMinutes(10);




					kmlelement ="<Placemark>\n" +
							"<name><![CDATA[ FRUIT "+(i)+",Pac:"+j+"]]></name>\n <description>"+
							"<![CDATA["
							+nameData[0]+": <b> FRUIT  </b><br/>"
							+nameData[1]+": <b> FRUIT Number :"+i+",Pac:"+j+" </b><br/>"
							+nameData[2]+": <b>"+packman_for.getPath().TheCurrentPath().get(i).getFruitPoint().x()+" </b><br/>" 
							+nameData[3]+": <b>"+packman_for.getPath().TheCurrentPath().get(i).getFruitPoint().y()+" </b><br/>" 
							+nameData[4]+": <b>"+packman_for.getPath().TheCurrentPath().get(i).getWeight()+" </b><br/>" 


						+"]]></description>\n" +
						"<TimeStamp>\r\n" + 
						"        <when>"+now_start+"</when>\r\n" + 
						"      </TimeStamp>"+
						"<styleUrl>#Fruit</styleUrl>"+
						"<Point>\n" +
						"<coordinates>"+packman_for.getPath().TheCurrentPath().get(i).getFruitPoint().y()+","
						+packman_for.getPath().TheCurrentPath().get(i).getFruitPoint().x()+"</coordinates>" +
						"</Point>\n" +
						"</Placemark>\n";



					content.add(kmlelement);			
					
					
					
					
					if(i+1==packman_for.getPath().TheCurrentPath().size()) temp_start=now_start_end;

					String kmlelement2 ="<Placemark>\n" +
							"<name><![CDATA[ PACKMAN Moving "+j+", "+i+"]]></name>\n" +
							"<description>"+
							"<![CDATA["
							+nameData[0]+": <b> PACKMAN  </b><br/>"
							+nameData[1]+": <b> PACKMAN Moving "+j+", "+i+"</b><br/>"
							+nameData[2]+": <b>"+packman_for.packLocation.x()+" </b><br/>" 
							+nameData[3]+": <b>"+packman_for.packLocation.y()+" </b><br/>" 
							+nameData[4]+": <b>"+packman_for.getSpeed()+" </b><br/>" 
							+nameData[5]+": <b>"+Packman_arr.get(j).getradius()+" </b><br/>" // altito to meter



							+"]]></description>\n" +
							"<TimeStamp>\r\n" + 
							"        <when>"+temp_start+"</when>\r\n" + 
							"      </TimeStamp>"+
							"<styleUrl>#Packman</styleUrl>"+
							"<Point>\n" +
							"<coordinates>"+packman_for.getPath().TheCurrentPath().get(i).getFruitPoint().y()+","
							+packman_for.getPath().TheCurrentPath().get(i).getFruitPoint().x()+"</coordinates>" +
							"</Point>\n" +
							"</Placemark>\n";


					content.add(kmlelement2);

				}


		}

		content.add(kmlend);
		pw.write(String.join("\n", content));
		System.out.println("Operation Complete");
		pw.close();
	} 

}











