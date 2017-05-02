public class Car {
	public String type;
	public int location;


	public Car(boolean isCompact, boolean isDisable) {
		if (isDisable) {
			type = "Disable";
		} else if (isCompact) {
			type = "Compact";
		} else {
			type = "Regular";
		}
	}


	public boolean Enter(ParkLot lot) {
		location = lot.FindSpotFor(this);
		return (location > -1);
	}

	public void Leave(ParkLot lot) {
		lot.RemoveCar(location);
	}
}