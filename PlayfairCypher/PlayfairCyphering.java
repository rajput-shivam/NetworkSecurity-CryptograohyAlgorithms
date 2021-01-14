class PlayfairCyphering
{

	static String Encryption(String plainText, String key)
	{
		// Constructing the KeyAlphabet //
		String KeyAlphabet = "";
		String Alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i=0; i<Alphabet.length(); i++)
		{
			int j;
			for(j=0; j<key.length(); j++)
			{
				if(key.charAt(j)==Alphabet.charAt(i))
					break;
				if(key.charAt(j)!='j' && Alphabet.charAt(i)=='j')
					break;
				if(key.charAt(j)=='j' && Alphabet.charAt(i)=='i')
					break;
			}
			if(j==key.length())
				KeyAlphabet += Alphabet.charAt(i);
		}	
		KeyAlphabet = key + KeyAlphabet;
		
		// Constructing the KeySquare and Printing the keySquare //	
		char[][] KeySquare = new char[5][5];
		int k=0;
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++,k++)
				KeySquare[i][j] = KeyAlphabet.charAt(k);
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++,k++)
				System.out.print(KeySquare[i][j]+" ");
			System.out.println();}

		// Encrypting the plainText //
		if(plainText.length()%2==1) plainText = plainText+KeySquare[4][4];
		String ans = "";
		for(int a=0,b=1; b<plainText.length(); a+=2,b+=2)
		{
			int i1=0,i2=0,j1=0,j2=0;
			for(int i=0; i<5; i++)
				for(int j=0; j<5; j++){
					if (plainText.charAt(a) == KeySquare[i][j])
					{ i1=i; j1=j; }
				    if (plainText.charAt(b) == KeySquare[i][j])
					{ i2=i; j2=j; }   }
			
			if(plainText.charAt(a)==plainText.charAt(b))
				ans += plainText.charAt(a)+plainText.charAt(b);	
			else if(i1==i2)
			{
				if(j1==4) ans += KeySquare[i1][0];
				else      ans += KeySquare[i1][j1+1];
				if(j2==4) ans += KeySquare[i2][0];
				else      ans += KeySquare[i2][j2+1];
			}
			else if(j1==j2)
			{
				if(i1==4) ans += KeySquare[0][j1];
				else      ans += KeySquare[i1+1][j1];
				if(i2==4) ans += KeySquare[0][j2];
				else      ans += KeySquare[i2+1][j2];
			}
			else
			{
				ans += KeySquare[i1][j2]; 
				ans += KeySquare[i2][j1];
			}	
		}
		return ans;
	}
	
	
	static String Decryption(String cypherText, String key)
	{
		// Constructing the KeyAlphabet //
		String KeyAlphabet = "";
		String Alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i=0; i<Alphabet.length(); i++)
		{
			int j;
			for(j=0; j<key.length(); j++)
			{
				if(key.charAt(j)==Alphabet.charAt(i))
					break;
				if(key.charAt(j)!='j' && Alphabet.charAt(i)=='j')
					break;
				if(key.charAt(j)=='j' && Alphabet.charAt(i)=='i')
					break;
			}
			if(j==key.length())
				KeyAlphabet += Alphabet.charAt(i);
		}	
		KeyAlphabet = key + KeyAlphabet;
		
		// Constructing the KeySquare and Printing the keySquare //	
		char[][] KeySquare = new char[5][5];
		int k=0;
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++,k++)
				KeySquare[i][j] = KeyAlphabet.charAt(k);
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++,k++)
				System.out.print(KeySquare[i][j]+" ");
			System.out.println();}

		
		// Decrypting the cypherText//
		String ans = "";
		for(int a=0,b=1; b<cypherText.length(); a+=2,b+=2)
		{
			int i1=0,i2=0,j1=0,j2=0;
			for(int i=0; i<5; i++)
				for(int j=0; j<5; j++){
					if (cypherText.charAt(a) == KeySquare[i][j])
					{ i1=i; j1=j; }
				    if (cypherText.charAt(b) == KeySquare[i][j])
					{ i2=i; j2=j; }   }
			
			if(cypherText.charAt(a)==cypherText.charAt(b))
				ans += cypherText.charAt(a)+cypherText.charAt(b);	
			else if(i1==i2)
			{
				if(j1==0) ans += KeySquare[i1][4];
				else      ans += KeySquare[i1][j1-1];
				if(j2==0) ans += KeySquare[i2][4];
				else      ans += KeySquare[i2][j2-1];
			}
			else if(j1==j2)
			{
				if(i1==0) ans += KeySquare[4][j1];
				else      ans += KeySquare[i1-1][j1];
				if(i2==0) ans += KeySquare[4][j2];
				else      ans += KeySquare[i2-1][j2];
			}
			else
			{
				ans += KeySquare[i1][j2]; 
				ans += KeySquare[i2][j1];
			}	
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		String message = "instruments";
		String key = "monarchy";
		String CypherText = Encryption(message, key);
		System.out.println("AFTTER ENCRYPTION: "+ CypherText);
		String PlainText = Decryption(CypherText, key);
		System.out.println("AFTTER DECRYPTION: "+ PlainText);
	}
	
}