
public abstract class AbstractCipher {
	protected abstract void makeAlp(String keyword) throws BadKeywordException;
	abstract String getAlp();
	abstract char encode(char in);
	abstract char decode(char in);
	abstract String encode(String in);
	abstract String decode(String in);
	
	public boolean checkKeyword(String keyword) {
		// check for repeated characters
		for(int i=0;i<keyword.length()-1;i++) {
			// Check this char is between A and Z
			int thisChar = (int)keyword.charAt(i);
			if(thisChar < 'A' || thisChar > 'Z') {
				return false;
			}
			// Check the char hasn't appeared earlier
			for(int j=i+1;j<keyword.length();j++) {
				if(keyword.charAt(i) == keyword.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
