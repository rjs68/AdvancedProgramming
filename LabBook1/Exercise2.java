import java.util.ArrayList;

/* Main method to test various implementations of the 
 * cipher classes
 */

public class Exercise2 {
	public static void main(String[] args) {
		ArrayList<AbstractCipher> ciphers = new ArrayList<AbstractCipher>();
		String keyword = "ZEBRA";
		try {
			String keywords = "NATHAN IS A CUNT";
			Mono m = new Mono(keyword);
			Vignere v = new Vignere(keyword);
			ciphers.add(m);
			ciphers.add(v);
			for(int i=0; i<ciphers.size(); i++) {
				String output = "";
				for(int j=0;j<keywords.length();j++) {
					output += ciphers.get(i).encode(keywords.charAt(j));
					}
				System.out.println(output);
			}
		}catch(BadKeywordException e) {
			e.printStackTrace();
		}
	}
}
