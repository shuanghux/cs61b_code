public class Spot {
	private String type;
	private int distance;
	public boolean occupied;

	public Spot(String t, int dis) {
		type = t;
		distance = dis;
		occupied = false;
	}

	public boolean forDisable() {
		if (type == "Disable") {
			return true;
		}
		return false;
	}

	public boolean forRegular() {
		if (type == "Regular" && !this.forDisable()) {
			return true;
		}
		return false;
	}

	public void Occupy() {
		occupied = true;
	}

	public void Remove() {
		occupied = false;
	}
}