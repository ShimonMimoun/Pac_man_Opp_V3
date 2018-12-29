package Algorithm;

import java.util.ArrayList;

import Coords.Map;
import GIS.Fruit;
import GIS.Game;
import GIS.Packman;
import GIS.Path;
import Geom.Point3D;

/**
 * This class manages our algorithms that know how to find the best way for my Packman
 * There are several different methods depending on the quantity of packmans and the speed.
 * Example Algo Details: https://fr.wikipedia.org/wiki/Algorithme_glouton
 * @author Omer Paz and Shimon Mimoun
 */
public class ShortestPathAlgo {

	private ArrayList<Fruit> fruits = new ArrayList<>(); // Arraylist of fruit
	private ArrayList<Packman> Packmans = new ArrayList<>();//Arraylist of Packman 
	private distance_Comperator calDis = new distance_Comperator();// Call to the Comparator 
	private Map themap = new Map();// create a Map object


	/**
	 * Contractor of ShortestPathAlgo Who receives Game Object
	 * @param theGame Object Game receiv 
	 */
	public ShortestPathAlgo(Game theGame) {	


		ArrayList<Fruit> clone = new ArrayList<Fruit>(theGame.Fruits_arr.size());  for (Fruit item : theGame.Fruits_arr) clone.add(item);
		this.fruits = clone;	//Create a new fruit for not to overwrite Game data later
		this.Packmans = theGame.Packman_arr;
	}

	/**
	 * Algorithm that rolls for only a Pac-Man.
	 * Detail: www.101computing.net/pacman-ghost-algorith
	 * @param oriPackman Receiv Pac_man 
	 * @return Path with the arraylist sort according to my best Path
	 * 
	 */
	public Path algoSinglePackman(Packman oriPackman){
		ArrayList<Fruit> Tempfruits = new ArrayList<>();
		Tempfruits=oriPackman.getPath().TheCurrentPath();

		Packman tempPackman = new Packman(oriPackman.getPoint(),oriPackman.getSpeed(),oriPackman.getradius());
		Path Dis = disAlgo(tempPackman,Tempfruits);
		Path p = calFastDisOnePack(tempPackman, Tempfruits);
		
		
		double timeFor1 = Dis.CalPathTime(tempPackman);
		
		double timeFor2 = p.CalPathTime(tempPackman);


		if(timeFor1 < timeFor2) {
			Dis.setTheTotalTime(timeFor1);

			return Dis;

		}else {
			p.setTheTotalTime(timeFor2);

			return p;

		}



	}
	/**
	 * Help function that calculates the closest distance between a packman and fruits
	 * @param packman Receiv Packman Only
	 * @param myFurits Arraylist in Fruits 
	 * @return the Path the most suitable
	 */
	public Path calFastDisOnePack (Packman packman, ArrayList<Fruit> myFurits) {

		if (myFurits.isEmpty()) {
			return packman.getPath();
		}


		Fruit theCloserTemp = TheCloserFurit(packman,myFurits); // the closer furit to packman 
		packman.getPath().TheCurrentPath().add(theCloserTemp);
		packman.setPackLocation(theCloserTemp.getFruitPoint());
		myFurits.remove(getIndexFurit(theCloserTemp, myFurits));

		return calFastDisOnePack(packman,myFurits);


	}
	/**
	 * Method that calculates the distance between a pacman and each fruit
	 * @param packman a single Packman on which we will calculate the distance
	 * @param myFurits Fruit list
	 * @return Path with distance add
	 */
	public Path disAlgo(Packman packman, ArrayList<Fruit> myFurits) {
		ArrayList<Double> SortPathByDis = new ArrayList<>();

		Path ans = new Path();

		for (int i = 0; i < myFurits.size(); i++) {
			double temp = themap.distancePixels(packman.getPoint(), myFurits.get(i).getFruitPoint());
			SortPathByDis.add(temp);
		}
		SortPathByDis.sort(calDis);
		double temp;

		for(double distance : SortPathByDis) {

			for (int j = 0; j < myFurits.size(); j++) {
				temp = themap.distancePixels(packman.getPoint(), myFurits.get(j).getFruitPoint());

				if(temp == distance) {
					ans.TheCurrentPath().add(myFurits.get(j));
					break;
				}


			}
		}

		return ans;
	}

	/**
	 * Algorithm that calculates the course of several pacman and who know how to return:
	 * what will be the course of each pacman to have the best time 
	 * Fonction Help
	 * 
	 * @return Pacman's ArrayList to which will be added to each Pacman a path of the course he will perform
	 * 
	 */

	public ArrayList<Packman> algoMultiPackmans (){
		Path myPath = new Path();
		ArrayList<Fruit> myFurits = this.fruits;
		ArrayList<Packman> ans = new ArrayList<>();
		ArrayList<Packman> myPackmens = this.Packmans;
		

		for (int i = 0; i < myPackmens.size(); i++) {
			Packman p = new Packman(myPackmens.get(i).getPoint(),myPackmens.get(i).getSpeed(), myPackmens.get(i).getradius());
			ans.add(p);
		}
		myPackmens = Algomulti(myPackmens,myFurits);

		for (int i = 0; i < myPackmens.size(); i++) {
			myPackmens.get(i).setPackLocation(ans.get(i).getPoint());
		}

		
		
		for(Packman packman : myPackmens) {
			
			Path PackmanPath = new Path();
			Path p = new Path();
			PackmanPath = packman.getPath();


			//Packman pack = new Packman(packman);
//			packman.getPath().setPath(algoSinglePackman(packman).TheCurrentPath());
//			packman.getPath().setTheTotalTime(packman.getPath().CalPathTime(packman));
//			
//			
//				if(PackmanPath.getTheTime() <= pack.getPath().getTheTime()) {
//				packman.getPath().setPath(PackmanPath.TheCurrentPath());
//				PackmanPath.CalPathTime(packman);
//			}
//			else {
//	
//				packman.getPath().setPath(pack.getPath().TheCurrentPath());
//		
//			}

		}


		double longestTime = myPath.CalPathTime(myPackmens.get(0));
		double temp = 0;

		for (int i = 1; i < myPackmens.size(); i++) {
			temp = myPath.CalPathTime(myPackmens.get(i));
			if (temp > longestTime) {
				longestTime = temp;
			}
		}

		
		
		System.out.println("the Total time is: "+longestTime);
		return myPackmens;
	}

	/**
	 * Algorithm that calculates the course of several pacman and who know how to return:
	 * what will be the course of each pacman to have the best time 
	 * @param myPackmans Get a Pacmans ArrayList
	 * @param myFurits Get a Fruits ArrayList
	 * @return Pacman's ArrayList to which will be added to each Pacman a path of the course he will perform
	 */

	private ArrayList<Packman> Algomulti (ArrayList<Packman> myPackmans , ArrayList<Fruit>myFurits) {
		Path myPath = new Path();
		if(myFurits.isEmpty()) {
			return myPackmans;
		}


		Packman thePackman = myPackmans.get(0);
		Fruit theCloserFurit = TheCloserFurit(myPackmans.get(0),myFurits);
		double FastTime = myPath.CalTime2Points(myPackmans.get(0),theCloserFurit);

		Packman tempPack;
		Fruit tempFruit;
		double tempTime = 0;

		for (int i = 0; i < myPackmans.size(); i++) {

			tempPack = myPackmans.get(i);
			tempFruit = TheCloserFurit(myPackmans.get(i),myFurits);
			tempTime = myPath.CalTime2Points(myPackmans.get(i),tempFruit);

			if (tempTime < FastTime) {
				thePackman = tempPack;
				FastTime = tempTime;
				theCloserFurit = tempFruit;
			}

		}
		thePackman.getPath().TheCurrentPath().add(theCloserFurit);
		thePackman.setPackLocation(theCloserFurit.getFruitPoint());
		myFurits.remove(getIndexFurit(theCloserFurit, myFurits));

		return Algomulti(myPackmans ,myFurits);

	}

	/**
	 * method that calculates  the fastest point between a pac man and the path
	 * @param packman Receiv Pacman on which we will look for the fastest time
	 * @param myFurits ArrayList of Fruits on which we seek the fastest fruit of the Pac-Man
	 * @return The double time of the fastest route
	 */

	double FastSpeedToFriut(Packman packman ,ArrayList<Fruit> myFurits ) {
		Path p = new Path();
		double fastTime = p.CalTime2Points(packman, myFurits.get(0));
		double tempTime = 0;

		for (int i = 1; i < myFurits.size(); i++) {

			tempTime = p.CalTime2Points(packman, myFurits.get(i));

			if(tempTime <fastTime) {
				fastTime = tempTime;
			}

		}
		return fastTime;

	}
	/**
	 * Return the most closers furit to the packman
	 * @param packman Receiv Pacman on which we will look for the fastest Fruit
	 * @param myFurits ARraylist Of Fruit on wiche we seek the most closers PAcman
	 * @return a Fruit the most closers of PAcman
	 */
	public Fruit TheCloserFurit(Packman packman,ArrayList<Fruit> myFurits) {
		Path p = new Path();

		double FastTime = p.CalTime2Points(packman,myFurits.get(0));
		Fruit theMostCloser = myFurits.get(0);
		double tempTime = 0;

		for (int i = 1; i < myFurits.size(); i++) {
			tempTime = p.CalTime2Points(packman, myFurits.get(i));

			if(tempTime < FastTime)	{
				FastTime = tempTime;
				theMostCloser = myFurits.get(i);
			}	
		}

		return theMostCloser;
	}

	/**
	 * Calculate the index of the furit.
	 * @param fruit Receiv Fruit of ArrayList
	 * @param myFurits ArrayList contain The "fruit"
	 * @return Index of Fruit (if no found return -1)
	 */
	public int getIndexFurit(Fruit furit , ArrayList<Fruit> myFurits) {

		for (int i = 0; i < myFurits.size(); i++) {

			if(furit.equals(myFurits.get(i))) {
				return i;
			}

		}
		return -1;
	}



}
