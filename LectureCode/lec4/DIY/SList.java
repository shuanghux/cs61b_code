/* Represent a list of integers, where all the "list" work is delegated
 * to a naked IntList. */

public class SList {
	public class IntNode {
		public int item;     /* Equivalent of first */
		public IntNode next; /* Equivalent of rest */
		public IntNode(int i, IntNode h) {
			item = i;
			next = h;		
		}
	} 

	private IntNode sentinel;
	private int size;

	/** Creates an empty list. */
	public SList() {
		size = 0;
		sentinel = new IntNode(932343, null);
	}

	public SList(int x) {
		size = 1;
		sentinel = new IntNode(92182, null);
		sentinel.next = new IntNode(x, null);
	}

	/** Adds an item of the front. */
	// It can be viewed that sentinal.next is the front Node.
	public void insertFront(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}

	/** Gets the front item of the list. */
	public int getFront() {
		return sentinel.next.item;
	}

	/** Puts an item at the back of the list. */
	public void insertBack(int x) {
		IntNode p = getBackNode();
		p.next = new IntNode(x,null);
		size += 1;
	}

	/** Returns the back node of our list. */
	private IntNode getBackNode() {
		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		return p;
	}

	/** Returns last item */
	public int getBack() {
		IntNode p =  getBackNode();
		return p.item;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		SList s1 = new SList();
		s1.insertBack(6);
		s1.insertFront(4);
		s1.insertFront(3);
		System.out.println(s1.getBack());
		//System.out.println(s1.getFront());
	}
} 