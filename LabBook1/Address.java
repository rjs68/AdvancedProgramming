
public class Address implements AddressValue{
	private String address;
	
	public Address(String address) {
		this.address = address;
	}
	
	public String toString(){
		return address;
	}
}
