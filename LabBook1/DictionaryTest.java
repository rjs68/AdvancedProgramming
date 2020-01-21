
public class DictionaryTest {

	//Main to test Dictionary class
	public static void main(String[] args) {
		Dictionary<AddressKey, AddressValue> dict = new Dictionary<AddressKey, AddressValue>();
		
		dict.set(new Individual("Rhys"), new PhoneNumber("01597829393"));
		dict.set(new Business("Apple"), new Address("The Galapagos Islands"));
		
		System.out.println(dict);
	}

}
