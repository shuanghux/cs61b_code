/* TODO: Set up this interface so that it covers all common
 * methods to AList and SList. Also add a default method
 * print that prints a list. */

/**
* @ author Shuang Hu
*/
public interface List61B<Item>{
	public void insertFront(Item x);
	public void insertBack(Item x);
	public Item deleteFront();
	public Item deleteBack();

	public Item getBack();
	public Item getFront();
	public Item get(int i);
	public int size();
	public void insertPosition(Item x, int position);

	default public void print() {
		for (int i = 0; i < this.size(); i++) {
			System.out.print(this.get(i) + " ");
		}
		System.out.println();
	}

} 