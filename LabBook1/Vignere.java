
public class Vignere extends AbstractCipher implements CipherInterface{
	private char[][] alp; // cipher array
	private int rowPos; // which row are we currently using for encode / decode
	
	public Vignere(String keyword) throws BadKeywordException{
		this.makeAlp(keyword);
		rowPos = 0;
	}
	
	// Make the cipher
	protected void makeAlp(String keyword) throws BadKeywordException{
		if(!checkKeyword(keyword)) {
			throw new BadKeywordException();
		}
		int nRows = keyword.length();
		alp = new char[nRows][26];
		for(int i=0;i<nRows;i++) {
			// Start at the ith keyword character
			int startVal = (int)keyword.charAt(i);
			for(int j=0;j<26;j++) {
				// Put the character in
				alp[i][j] = (char)startVal;
				// Increase position in the alphabet
				startVal += 1;
				// If we got beyond Z, go back to A
				if(startVal>'Z') {
					startVal = 'A';
				}
			}
		}
	}
	
	// Useful method to get the cipher as a String
	// Used for debug
	public String getAlp() {
		String out = "";
		for(int i=0;i<alp.length;i++) {
			for(int j=0;j<26;j++) {
				out += alp[i][j];
			}
			out += '\n';
		}
		return out;
	}
	
	public char encode(char in) {
		int iin = (int)in;
		if(iin < 'A' || iin > 'Z') {
			return in;
		}
		// If we've gone past the last row, go back to the first one
		if(rowPos == alp.length) {
			rowPos = 0;
		}
		// Do the encoding
		return alp[rowPos++][iin-'A'];
	}
	
	public char decode(char in) {
		int iin = (int)in;
		if(iin < 'A' || iin > 'Z') {
			return in;
		}
		if(rowPos == alp.length) {
			rowPos = 0;
		}
		// Do the decoding
		int pos = 0;
		for(int i=0;i<alp[rowPos].length;i++) {
			if(alp[rowPos][i]==in) {
				pos = i;
				break;
			}
		}
		rowPos += 1;
		return (char)('A'+pos);
	}
	
	public void reset() {
		rowPos = 0;
	}
	
	// Also included encode and decode
	// functions that worked with a string
	// They work through the string calling
	// the char versions
	// Useful for debugging
	public String encode(String in) {
		reset();
		String out = "";
		for(int i=0;i<in.length();i++) {
			out += this.encode(in.charAt(i)); 
		}
		return out;
	}
	
	public String decode(String in) {
		reset();
		String out = "";
		for(int i=0;i<in.length();i++) {
			out += this.decode(in.charAt(i)); 
		}
		return out;
	}
	
}
