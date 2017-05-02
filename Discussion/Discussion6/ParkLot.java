/*
Design a ParkingLot package that allocates specific parking spaces to cars in a smart way. Decide
what classes you’ll need, and design the API for each. Time permitting, select data structures
to implement the API for each class. Try to deal with annoying cases (like disobedient humans).
Parking spaces can be either regular, compact, or handicapped-only.
When a new car arrives, the system should assign a specific space based on the type of car.
All cars are allowed to park in regular spots. Thus, compact cars can park in both compact
spaces and regular spaces.
When a car leaves, the system should record that the space is free.
Your package should be designed in a manner that allows different parking lots to have
different numbers of spaces for each of the 3 types.
Parking spots should have a sense of closeness to the entrance. When parking a car, place it
as close to the entrance as possible. Assume these distances are distinct.
*/

public class ParkLot {
	private Spot[] spots;
	private int numReg;
	private int numCom;
	private int numDis;
	private int totSpots;

	// Constructor: define numbers of each type of spots
	// starts from disable, to regular, to compact

	public ParkLot(int reg, int com, int dis) {
		numReg = reg;
		numCom = com;
		numDis = dis;
		totSpots = numDis+numReg+numCom;
		spots = new Spot[numReg + numCom + numDis];
		for (int i = 0; i < numDis; i++) {
			spots[i] = new Spot("Disable",i);
		}
		for (int i = numDis; i < (numDis+numReg); i++) {
			spots[i] = new Spot("Regular",i);
		}
		for (int i = (numDis+numReg); i < (numDis+numReg+numCom); i++) {
			spots[i] = new Spot("Compact",i);
		}
	}

	public int FindSpotFor(Car c) {
		if (c.type == "Disable") {
			return FindDis();
		} else if (c.type == "Regular") {
			return FindReg();
		} else {
			return FindCom();
		}
	}

    private int FindDis() {
    	for (int i = 0; i < numDis; i++) {
    		if(!spots[i].occupied) {
    			spots[i].Occupy();
    			return i;
    		}
    	}
    	return -1;
    }

    private int FindCom() {
    	for (int i = numDis; i < numDis+numReg+numCom; i++) {
    		if (!spots[i].forDisable() && !spots[i].occupied) {
    			spots[i].Occupy();
    			return i;
    		}
    	}
    	return -1;
    }

    private int FindReg() {
    	for (int i=numDis; i < numDis+numReg; i++) {
    		if(!spots[i].forDisable() && !spots[i].occupied && spots[i].forRegular()) {
    			spots[i].Occupy();
    			return i;
    		}
    	}
    	return -1;
    }

	public void RemoveCar(int index) {
		spots[index].Remove();
	}


}