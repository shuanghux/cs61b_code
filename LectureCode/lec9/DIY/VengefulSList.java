/** SList with additional operation printLostItems() which prints all items
  * that have ever been deleted. */
public class VengefulSList<Item> extends SList<Item> {

	private SList<Item> deletedItems;

	public VengefulSList() {
	    deletedItems = new SList<Item>();
    }

    public VengefulSList(Item x) {
	    super(x);
	    deletedItems = new SList<Item>(x);
    }

	@Override
	public Item deleteBack() {
		Item temp = super.deleteBack();
		deletedItems.insertBack(temp);
		return temp;
	}

	public void printLostItems() {
		deletedItems.print();
	}
	public static void main(String[] args) {

		VengefulSList<Integer> vs1 = new VengefulSList<Integer>();
		vs1.insertBack(1);
		vs1.insertBack(5);
		vs1.insertBack(10);
		vs1.insertBack(13);
		// vs1 is now: [1, 5, 10, 13] 

		vs1.deleteBack();
		vs1.deleteBack();
		// After deletion, vs1 is: [1, 5]

		// Should print out the numbers of the fallen, namely 10 and 13.
		System.out.print("The fallen are: ");
		vs1.printLostItems();
	}
} 