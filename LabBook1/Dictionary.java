import java.util.ArrayList;

public class Dictionary<A, B> {
	private ArrayList<A> key = new ArrayList<A>();
	private ArrayList<B> value = new ArrayList<B>();
	
	/**
	 * Method to add key, value pair to the arrays
	 * @param a
	 * @param b
	 */
	public void set(A a, B b) {
		key.add(a);
		value.add(b);
	}
	
	/**
	 * Method to return the value associated with a key
	 * @param a
	 * @return B
	 */
	public B get(A a) {
		int i = key.indexOf(a);
		return value.get(i);
	}
	
	/**
	 * Overwrite toString() method to print out key, value pairs
	 */
	public String toString() {
		String list = "";
		for(int i=0; i<key.size(); i++) {
			list += (key.get(i) + ": " + value.get(i) + "\n");
		}
		return list;
	}
}
