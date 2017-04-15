public class ArrayDeque<Item> {
	private Item[] items;
	private int size;
	private int frontIndex;
	private int rearIndex;
	private int memOccupied;
	private int resizeFactor = 2;

	public ArrayDeque() {
		items = (Item[]) new Object[8];
        size = 0;
        memOccupied = 0;
        frontIndex = 0;
        rearIndex = 1;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public boolean noElememt() {
		if (memOccupied == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (size == memOccupied) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public int getMemOccupied() {
		return memOccupied;
	}

	public void keepEfficiency() {
		double usage = memOccupied/size;
		if (usage < 0.25) {
			this.resize(this.size / resizeFactor);
		}
	}

	// take into the required size of the new array
	public void resize(int capacity) {
		Item[] a = (Item[]) new Object[capacity];
		System.arraycopy(items, frontIndex, a, 0, size);
		this.items = a;
		this.size = capacity;
		this.frontIndex = 0;
		this.rearIndex = 1 + memOccupied;
	}

	// Add a item to the front of the array
	public void addFirst(Item itemToAdd) {
		if (this.isFull()) {
			this.resize(this.size * resizeFactor);
		}
		items[frontIndex] = itemToAdd;
		memOccupied += 1;
		frontIndex = (frontIndex-1) % size;
	}

	// Add a item to rear of the array
	public void addLast(Item itemToAdd) {
		if (this.isFull()) {
			this.resize(this.size * resizeFactor);
		}
		items[rearIndex] = itemToAdd;
		memOccupied += 1;
		rearIndex = (rearIndex + 1) % size;
	}

	public Item delFirst() {
		if (this.isEmpty() || this.noElememt()) {
			return null;
		}
		Item itemToReturn = items[frontIndex];
		items[frontIndex] = null;
		frontIndex = (frontIndex + 1) % size;
		memOccupied -= 1;
		this.keepEfficiency();
		return itemToReturn;
	}

	public Item delLast() {
		if (this.isEmpty() || this.noElememt()) {
			return null;
		}
		Item itemToReturn = items[rearIndex];
		items[rearIndex] = null;
		rearIndex = (rearIndex - 1) % size;
		memOccupied -= 1;
		this.keepEfficiency();
		return itemToReturn;
	}

	// Get ith item in the array (starts from 0)
	public Item getItem(int getIndex) {
		if (getIndex > memOccupied - 1) {
			return null;
		}
		return items[frontIndex + getIndex];
	}

	public void printDeque() {
		for (int i = 0; i < memOccupied; i++) {
			System.out.print(this.getItem(i) + " ");
		}
	}
}