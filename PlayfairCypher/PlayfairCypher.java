class PlayfairCypher
{
	static int[] indexOf(char value, char[][] matrix)
	{
		int[] index = new int[2];
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++)
				if (value == matrix[i][j])
				{ index[0]=i; index[1]=j; }
		return index;
	}
	
	static String Encryption(String plainText, String key)
	{
		// Constructing the KeyAlphabet //
		String Alphabet = "abcdefghijklmnopqrstuvwxyz";
		String KeyAlphabet = "";
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
		if(plainText.length()%2==1) plainText = plainText+'z';
		String ans = "";
		for(int a=0,b=1; b<plainText.length(); a+=2,b+=2)
		{
			int[] indexA = indexOf(plainText.charAt(a), KeySquare);
			int[] indexB = indexOf(plainText.charAt(b), KeySquare);
			if(plainText.charAt(a)==plainText.charAt(b))
			{
				ans += plainText.charAt(a)+plainText.charAt(b);	
			}
			else if(indexA[0]==indexB[0])
			{
				if(indexA[1]==4) 
					ans += KeySquare[indexA[0]][0];
				else
					ans += KeySquare[indexA[0]][indexA[1]+1];
				if(indexB[1]==4) 
					ans += KeySquare[indexB[0]][0];
				else
					ans += KeySquare[indexB[0]][indexB[1]+1];
			}
			else if(indexA[1]==indexB[1])
			{
				if(indexA[0]==4) 
					ans += KeySquare[0][indexA[1]];
				else
					ans += KeySquare[indexA[0]+1][indexA[1]];
				if(indexB[0]==4) 
					ans += KeySquare[0][indexB[1]];
				else
					ans += KeySquare[indexB[0]+1][indexB[1]];
			}
			else
			{
				ans += KeySquare[indexA[0]][indexB[1]];
				ans += KeySquare[indexB[0]][indexA[1]];
			}
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		String message = "sadfkn";
		String key = "monarchysda";
		String CypherText = Encryption(message, key);
		System.out.println("AFTTER ENCRYPTION: "+ CypherText);
		//String PlainText = Decryption(CypherText, key);
		//System.out.println("AFTTER DECRYPTION: "+ PlainText);
	}
	
}