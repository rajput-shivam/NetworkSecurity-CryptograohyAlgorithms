class VernamCypher
{
	static String Encryption(String plainText, String key)
	{
		String Alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String StringAns = "";
		for(int i=0; i<plainText.length(); i++)
		{
			int NumAns = Alpha.indexOf(plainText.charAt(i)) + Alpha.indexOf(key.charAt(i));
			if(NumAns >= 26)
				NumAns = NumAns - 26;
			StringAns += Alpha.charAt(NumAns); 
		}
		return StringAns;
	}
	static String Decryption(String cypherText, String key)
	{
		String Alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String StringAns = "";
		for(int i=0; i<cypherText.length(); i++)
		{
			int NumAns = Alpha.indexOf(cypherText.charAt(i)) - Alpha.indexOf(key.charAt(i)) ;
			if(NumAns < 0)
				NumAns = NumAns + 26;
			StringAns += Alpha.charAt(NumAns); 
		}
		return StringAns;
	}
	 
	public static void main(String args[])
	{
		String message = "RAMSWARUPK";
		String key = "RANCHOBABA";
		String CypherText = Encryption(message, key);
		System.out.println("AFTTER ENCRYPTION: "+ CypherText);
		String PlainText = Decryption(CypherText, key);
		System.out.println("AFTTER DECRYPTION: "+ PlainText);
	}
}
