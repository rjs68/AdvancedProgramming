
public interface CipherInterface {
	public String getAlp();
	public char encode(char in);
	public char decode(char in);
	public String encode(String in);
	public String decode(String in);
	public boolean checkKeyword(String keyword);
}
