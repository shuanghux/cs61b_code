public class Sort {

	/** Returns input strings in sorted order. 
	  * Non-destructive. */
	public static String[] Sort(String[] inputs, int k) {
		if (k == inputs.length) {
			return inputs;
		}

		int minIndex = indexOfSmallest(inputs, k);
		swap(inputs, k, minIndex);
		return Sort(inputs, k + 1);
	}

	// Get the smallest element's index starts from k
	public static int indexOfSmallest(String[] inputs, int k) {
		int minIndex = k;
		int cmp;
		for (int i = k; i < inputs.length; i++) {
			if (inputs[i].compareTo(inputs[minIndex]) < 0) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	// Change the postion of index a and index b
	public static void swap(String[] inputs, int a, int b) {
		String temp = inputs[a];
		inputs[a] = inputs[b];
		inputs[b] = temp;
	}

	/** Prints out all strings in inputs. */
	public static void print(String[] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			System.out.print(inputs[i] + " ");
		}
		System.out.println();
	}

	/** Outputs the command line arguments 
	  * in alphabetical order. */
	public static void main(String[] args) {
		String[] sorted = Sort(args, 0);
		print(sorted);
	}
} 