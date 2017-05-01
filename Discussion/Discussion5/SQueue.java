import java.util.Stack;

public class SQueue{
	// add any instance variables you like
	public Stack<Integer> items;
	public SQueue(){
		// add any code to the constructor you like
		items = new Stack<Integer>();
	}

	public void enqueue(int item) {
		// your code here
		// reverse stack order
		Stack<Integer> tempStack = new Stack<Integer>();
		while(!items.empty()) {
			tempStack.push(items.pop());
		}
		// add item to top
		tempStack.push(item);

		// reverse, item to original bottom
		while (!tempStack.empty()) {
			items.push(tempStack.pop());
		}
	}

	public int dequeue() {
		return items.pop();
	}

	public void main(String args[]){
		SQueue test = new SQueue();
		test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(5);
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
	}
}
