
public class Individual implements AddressKey{
	private String name;
	
	public Individual(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
