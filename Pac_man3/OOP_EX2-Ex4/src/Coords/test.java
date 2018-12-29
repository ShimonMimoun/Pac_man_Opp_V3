package Coords;

import Geom.Point3D;


/**
 * This Class contains the Main function, which aims to test the functions of Mycoords
 * @author Mimoun Shimon and Omer Paz 
 *
 */
public class test {


	public static void main(String[] args) {
		MyCoords m = new MyCoords();



		Point3D a=new Point3D(32.106352,35.205225,650);
		Point3D b = new Point3D (337,-359,-20);
		System.out.println(m.add(a, b).toString());
//		System.out.println(m.ConvertToCartesian(a).toString());
//		System.out.println(m.ConvertToCartesian(a).toString());
//		Point3D shilo = m.ConvertToCartesian(a);
//		System.out.println(m.ConvertToGps(shilo));
		





	}

}
