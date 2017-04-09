/* 
Author: S Hu
*/

public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	// Constructor 1 with variables
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	// Constructorr 2 with name
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double distx = Math.pow((xxPos-p.xxPos),2);
		double disty = Math.pow((yyPos-p.yyPos),2);
		double dist = Math.sqrt(distx+disty);
		return dist;
	}

	public double calcForceExertedBy(Planet p) {
		double distance = calcDistance(p);
		double G = 6.67 * Math.pow(10,-11);
		double F = G * mass * p.mass / Math.pow(distance,2);
		return F;
	}

	public double calcForceExertedByX(Planet p) {
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);
		double dx = p.xxPos - xxPos;
		double Fx = F * dx / r;
		return Fx;
	}

	public double calcForceExertedByY(Planet p) {
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);
		double dy = p.yyPos - yyPos;
		double Fy = F * dy / r;
		return Fy;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		int num_planet = allPlanets.length;
		double NetForce =0;
		for(int i = 0; i < num_planet; i++) {
			if(!this.equals(allPlanets[i])) {
				NetForce += calcForceExertedByX(allPlanets[i]);
			}
		} 
		return NetForce;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		int num_planet = allPlanets.length;
		double NetForce = 0;
		for(int i = 0; i < num_planet; i++) {
			if(!this.equals(allPlanets[i])) {
				NetForce += calcForceExertedByY(allPlanets[i]);
			}
		} 
		return NetForce;
	}

	public void update(double dt, double Fx, double Fy) {
		double acc_x = Fx / mass;
		double acc_y = Fy / mass;
		xxVel += acc_x * dt;
		yyVel += acc_y * dt;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}

	public void draw() {
		String filename = "./images/" + this.imgFileName;
        StdDraw.picture(xxPos, yyPos, filename);
	}

}

