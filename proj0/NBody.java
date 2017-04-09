/*
Hint: Call this function by command such as:
java NBody 15778800.0 25000.0 data/planets.txt
the data file may vary

Author: S Hu

*/

public class NBody {
	public static double readRadius(String file_location) {
		In in = new In(file_location);
		int N = in.readInt();
        double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String file_location) {
		In in = new In(file_location);
		int num = in.readInt(); //Get number of planet
		double radius = in.readDouble();
		Planet[] allPlant = new Planet[num];
		for(int i = 0; i < num; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			allPlant[i] = new Planet(xxPos, yyPos, xxVel,
              yyVel, mass, imgFileName);
		}
		return allPlant;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        String picFilename = "./images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0,0,picFilename);
        for(int i = 0; i < planets.length; i++) {
        	planets[i].draw();
        }

        // Simulation

        double t = 0;
        while (t < T) {
        	
        	//Create an xForces array and yForces array.
        	double[] xForce = new double[planets.length];
        	double[] yForce = new double[planets.length];

        	//Calculate the net x and y forces for each planet
        	//storing these in the xForces and yForces arrays respectively.
        	for (int i = 0; i < planets.length; i++) {
        		xForce[i] = planets[i].calcNetForceExertedByX(planets);
        		yForce[i] = planets[i].calcNetForceExertedByY(planets);
        	}

        	//Call update on each of the planets. 
        	//This will update each planet's position, velocity, and acceleration.
        	for (int i = 0; i < planets.length; i++) {
        		planets[i].update(dt, xForce[i], yForce[i]);
        	}

        	//Draw the background image.
            StdDraw.picture(0,0,picFilename);

            //Draw all of the planets.
            for (int i = 0; i < planets.length; i++) {
        		planets[i].draw();
        	}

        	//Pause the animation for 10 milliseconds (see the show method of StdDraw). 
        	//You may need to tweak this on your computer.
        	StdDraw.show(10);

        	t += dt;
        }
	}

}
