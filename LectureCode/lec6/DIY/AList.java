/** Array based list.
 *  @author Shuang Hu
 */

public class AList {
    public int[] items;
    public int size;
    /** Creates an empty list. */
    public AList() {
        int[] items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void insertBack(int x) {
        if (size == items.length) {
            this.resize();
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getBack() {
        return items[size-1];      
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int deleteBack() {
        int return_item = getBack();
        size -= 1;
        return return_item;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Resize the list */
    private void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }
} 