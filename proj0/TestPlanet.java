import java.math.*;
public class TestPlanet {
	public static boolean Check(Planet[] allPlanet) {
		boolean all_good = true;
		int i;
		for (i = 0; i < allPlanet.length; i++) {
			if (!CheckConstructor(allPlanet[i])) {
				all_good = false;
				break;
			}
		}
		return all_good;
	}

	public static boolean CheckConstructor(Planet p) {
		if (p != null) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
        
        Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p4 = new Planet(3.0, 2.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet[] allPlanet = {p1, p2, p3, p4};
        if(Check(allPlanet)) {
        	System.out.println("All Good!");
        } else {
        	System.out.println("Something's Wrong!");
        }
	}
}