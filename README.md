
# GPS(PacMan) -Ex2/3 

This program is an educational program.

It is broken down into several stages:

The 3D points, which will then be defined as GPS or as Cartesian.

The program is to make the conversion between cartesian is polar, as well as to make any kind of calculations between vectors and points GPS, to find the vector between two points GPS, to find the new point GPS after this displacer of a GPS points with a vectors ...
The program is also read a csv file or a folder containing csv files and convert it to kml file.

Let's go to Package Gis
To make it short:
- Gis-element define a GPS point on the map
- Gis-Layer define a Csv file (several Gis-element)
- Gis-Project defined a set of Gis-layers

We also have a Meta-data that is common to the three classes is defined the data.

All this to arrive at a very interactive Gui Graphical interface program. 
The goal is very simple, we receive a satellite photo of a place with GPS coordinates of the edges of the photo.
Then we add Pacmans and Fruits, and like the famous games, our pacman has to eat Fruits.
Only that according to our version, the pacman know are way thanks to Algorithms start in the background which will define the trajectory of each Pacman (if there are several, each pacman will have his way to have the best time of treatment)

Then we have added some useful accessories:
- Read and write the Paths on a Csv file
- Write the Paths on a Kml file (on which we can also see the Pacman move on their target)
- Possibility to change the speed and Raduis of Pacman
- Possibility to change the weight of each Fruit

The tests of the function were carried out by Junit, all the functions have their verifications which are validated. The tests are located in the Tests Package.



# Authors

Shimon Mimoun & Omer Paz 

# Built With

**Eclipse** - is an integrated development environment (IDE) used in computer programming, and is the most widely used Java IDE

**Google Earth** is a  computer program that renders a [3D](https://en.wikipedia.org/wiki/3D_computer_graphics "3D computer graphics") representation of Earth based on [satellite imagery](https://en.wikipedia.org/wiki/Satellite_imagery).

The project includes class diagrams

# Getting Started

There is a test object that contains demonstrations of all functions to illustrate how things work. In addition, it is recommended to go over the javadoc before and read on all functions.



# Tutorial 

To start the program:
Import the Project then [OOP_EX2-EX4-master](https://github.com/omerpaz1/GPS-Ex2/tree/master/OOP_EX2-EX4-master "OOP_EX2-EX4-master") -->[OP_EX2-Ex4](https://github.com/omerpaz1/GPS-Ex2/tree/master/OOP_EX2-EX4-master/OOP_EX2-Ex4 "OOP_EX2-Ex4")-->[src](https://github.com/omerpaz1/GPS-Ex2/tree/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src "src")-->[GUI](https://github.com/omerpaz1/GPS-Ex2/tree/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GUI "GUI")-->[MyFrameMain.java](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GUI/MyFrameMain.java "MyFrameMain.java")

Then click in the menu on Add The user then enters the Pacmans and Fruits
To start the game click in the menu on File-> Run

### Example of the game:
![enter image description here](https://lh3.googleusercontent.com/Byxkm3oKkQx5NkQMymrCwOfjvV1mOFbfr-xd5Bonn9d5wZYlHbXoRN7LSxc1gYKZE7TNgCqn3-c "01")
![enter image description here](https://lh3.googleusercontent.com/80MaN_s8DBpvT64s_95Dyq0uPfAVPtt4DZPgX8xMvp1w1TuZB6tU6-oG5iLnlqCb9u2wQyIYkqA "02")
# Acknowledgments

Wikipedia to understand more how to CSV File :  https://fr.wikipedia.org/wiki/Comma-separated_values

Wikipedia to understand more how to Kml File :  https://fr.wikipedia.org/wiki/Keyhole_Markup_Language

Wikipedia to understand more how to Polar Coordinate :  https://en.wikipedia.org/wiki/Polar_coordinate_system

Wikipedia to understand more how to Pacman Game:
https://fr.wikipedia.org/wiki/Pac-Man_(s%C3%A9rie)

Ntu Edu to understand more how to Gui Java:
http://www.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html

Google  Developer to understand more how to Time and Animation of Kml :
https://developers.google.com/kml/documentation/time

# Description

### Package:

**Algorithm**

My Classes: [ShortestPathAlgo](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Algorithm/ShortestPathAlgo.java "ShortestPathAlgo.java"),[distance_Comperator](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Algorithm/distance_Comperator.java "distance_Comperator.java")



***Coords:***

_Include 1 interface such as_:  [coords_converter](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Coords/coords_converter.java "coords_converter.java")

My Classes: [MyCoords](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Coords/MyCoords.java "MyCoords.java"),[Map](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Coords/Map.java "Map.java"),[test](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Coords/test.java "test.java")


***File_format :***

My Classes : _[CsvFileHelper](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/File_format/CsvFileHelper.java "CsvFileHelper.java") , [CsvFileHelper](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/File_format/CsvFileHelper.java "CsvFileHelper.java") , [Json_101](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/File_format/Json_101.java "Json_101.java") , [Lunch](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/File_format/Lunch.java "Lunch.java") , [MultiCSV](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/File_format/MultiCSV.java "MultiCSV.java") , [csv2kml](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/File_format/csv2kml.java "csv2kml.java")_  


***GIS :***

Include 4 interface such as: [GIS_element](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/GIS_element.java "GIS_element.java") , [GIS_layer](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/GIS_layer.java "GIS_layer.java") , [GIS_project](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/GIS_project.java "GIS_project.java") , [Meta_data](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/Meta_data.java "Meta_data.java")

My Classes: [GIS_Layer_using](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/GIS_Layer_using.java "GIS_Layer_using.java") , [GIS_projet_using](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/GIS_projet_using.java "GIS_projet_using.java") , [Gis_element_using](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/Gis_element_using.java "Gis_element_using.java") , [Meta_Data_using](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/Meta_Data_using.java "Meta_Data_using.java")

[Game](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/Game.java "Game.java"),[Fruit.](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/Fruit.java "Fruit.java"),[Packman](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/Packman.java "Packman.java"),[Path.](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GIS/Path.java "Path.java")

***GUI***

My Classes: [MyFarme](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GUI/MyFarme.java " MyFarme.java"),   [MyFrameMain](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/GUI/MyFrameMain.java "MyFrameMain.java")

***GEOM :***


Include 1 interface such as: [Geom_element](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Geom/Geom_element.java "Geom_element.java")

My Class: [Point3D](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Geom/Point3D.java "Point3D.java") , [Circle](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Geom/Circle.java "Circle.java")

***Utils***

My Classes: [MyRandom](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Utils/MyRandom.java "MyRandom.java"),  [MyRandomTest](https://github.com/omerpaz1/GPS-Ex2/blob/master/OOP_EX2-EX4-master/OOP_EX2-Ex4/src/Utils/MyRandomTest.java "MyRandomTest.java")



***Tests***

        JunitTest from all my classes
