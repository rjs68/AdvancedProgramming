
public class Business implements AddressKey{
	private String name;
	
	public Business(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
