
public class MapHelper {

	/* Add a method get, which returns an item if it exists
	 * and null otherwise. */

	/* Add a method maxKey, which returns the maximum key. */
	public static <K, V> V get(ArrayMap<K, V> am, K key) {
	    if (am.containsKey(key)) {
	        return am.get(key);
        }
        return null;
    }

	public static void main(String[] args) {
  		ArrayMap<Integer, String> imm = new ArrayMap<Integer, String>();
  		imm.put(5, "hello");
  		imm.put(10, "ketchup");
  		System.out.println(MapHelper.get(imm, 5));
  		//assertEquals("hello", MapHelper.get(am, 5));
  		//assertEquals(null, MapHelper.get(am, 99));


  		//assertEquals(5, MapHelper.maxKey(am));
	}
} 