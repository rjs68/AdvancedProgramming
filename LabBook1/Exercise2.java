import java.util.ArrayList;

/* Main method to test various implementations of the 
 * cipher classes
 */

public class Exercise2 {
	public static void main(String[] args) {
		ArrayList<CipherInterface> ciphers = new ArrayList<CipherInterface>();
		String keyword = "RHINO";
		try {
			String keywords = "THIS IS A MESSAGE TO ENCODE";
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
