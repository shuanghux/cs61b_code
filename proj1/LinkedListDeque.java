/**
 * Author: Shuang Hu
 */
public class LinkedListDeque<Item> {

    public class Node {

        public Node prev;
        public Item item;
        public Node next;

        public Node(Node p, Item i, Node n) {
            this.prev = p;
            this.item = i;
            this.next = n;
        }
    }

    private Node sentinel;
    private int size;
    
    // Constructor
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(this.sentinel, null, this.sentinel);
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return this.size;
    }

    //Adds an item to the front of the Deque.
    public void addFirst(Item x) {
        Node newFrontNode;
        if (isEmpty()) {
            newFrontNode = new Node(sentinel,x,sentinel);
            // PreSentinel points to back Node, which is newFrontNode
            this.sentinel.prev = newFrontNode; 

        } else {
            // in this case back Node is not changed
            Node oldFrontNode = sentinel.next;
            newFrontNode = new Node(sentinel, x, oldFrontNode);
        }
        sentinel.next = newFrontNode;
        size += 1;
    }

    //Adds an item to the back of the Deque.
    public void addLast(Item x) {
        Node newLastNode;
        if (isEmpty()) {
            newLastNode = new Node(sentinel, x, sentinel);
            this.sentinel.next = newLastNode;
        } else {
            Node oldLastNode = sentinel.prev;
            newLastNode = new Node(oldLastNode, x, sentinel);
            oldLastNode.next = newLastNode;
        }
        sentinel.prev = newLastNode;
        size += 1;
    }
    
    //Removes and returns the item at the front of the Deque. If no such item exists, returns null.
    public Item removeFirst() {
        Node newFrontNode;
        if (isEmpty()) {
            return null;
        }
        Item value_return = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        this.size -= 1;
        return value_return;
    }


    //Removes and returns the item at the back of the Deque. If no such item exists, returns null.
    public Item removeLast() {
        Node newLastNode;
        if (isEmpty()) {
            return null;
        }
        Node oldLastNode = sentinel.prev;
        Item value_return = oldLastNode.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        this.size -= 1;
        return value_return;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public Item get(int index) {
        if (index >= size) {
            return null;
        }
        int i = 0;
        Node t = sentinel;
        while (i < index) {
            t = t.next;
            i++;
        }
        return t.item;
    }
    

    //Prints the items in the Deque from first to last, separated by a space.
    public void printDeque() {
        Node t = sentinel.next;
        while (t != sentinel) {
            System.out.print(t.item + " ");
            t = t.next;
        }
    }


    private Item getElement(int index, Node x) {
        if (index == 0) {
            return x.item;
        }
        return recursiveHelper(index - 1, x.next);
    }

    public Item getRecursive(int index) {
        if (index >= this.size) {
            return null;
        }

        return getElement(index, sentinel.next);
    }


    
}