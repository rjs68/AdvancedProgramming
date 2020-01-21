
public class PhoneNumber implements AddressValue{
	private String number;
	
	public PhoneNumber(String number) {
		this.number = number;
	}
	
	public String toString() {
		return number;
	}
}
