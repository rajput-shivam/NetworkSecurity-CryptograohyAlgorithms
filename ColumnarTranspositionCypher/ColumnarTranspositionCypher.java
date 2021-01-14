import java.lang.Math;

class ColumnarTranspositionCypher{
	    static void display(int[] A, char[][] B)
		{
			System.out.println("\n");
			for(int i: A)
				System.out.print(i+" ");
			System.out.println();
			for (char[] i: B){
				for (char j : i)
					System.out.print(j+" ");
			    System.out.print("\n");}
		}
	
	
		static String Encryption(String plainText, String key)
		{
			//'plainText' as a multiple of 'key' to avoid 'arryOutOfIndex' 
			System.out.println(key.length()-(plainText.length()%key.length()));
			for(int i=0; i<key.length()-(plainText.length()%key.length()); i++) 
				plainText+="#";
			//'keyNumber' which has corresponding integer value of 'key'
			int[] keyNumber = new int[key.length()];
			String alphabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwXxYyZz";
			int number = 0;	
			for(int i=0; i<alphabet.length(); i++)
				for(int j=0; j<key.length(); j++)
					if (alphabet.charAt(i)== key.charAt(j))
						keyNumber[j] = ++number;
			//'squareArray' which has the message in 2D array
			char[][] squareArray = new char[plainText.length()/key.length()][key.length()];
			number = -1;
			for(int i=0; i<plainText.length()/key.length(); i++)
				for(int j=0; j<key.length(); j++)
				    squareArray[i][j] = plainText.charAt(++number);
			display(keyNumber, squareArray);
			//extracting answer
			String ans = "";
			number = 0;
			while(++number<=key.length())
				for(int i=0; i<key.length(); i++)
					if (number==keyNumber[i])
						for(int j=0; j<plainText.length()/key.length(); j++)
							ans += squareArray[j][i];
			return ans;
		}
		
		static String Decryption(String cypherText, String key) 
		{
			//'keyNumber' which has corresponding integer value of 'key'
			int[] keyNumber = new int[key.length()];
			String alphabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwXxYyZz";
			int number = 0;	
			for(int i=0; i<alphabet.length(); i++)
				for(int j=0; j<key.length(); j++)
					if (alphabet.charAt(i)== key.charAt(j))
						keyNumber[j] = ++number;
			//'squareArray' which has the message in 2D array
			char[][] squareArray = new char[cypherText.length()/key.length()][key.length()];
			int indexCy = -1;
			number = 0;
			while(++number<=key.length())
				for(int i=0; i<key.length(); i++)
					if (number==keyNumber[i])
						for(int j=0; j<cypherText.length()/key.length(); j++)
							squareArray[j][i] = cypherText.charAt(++indexCy);
			display(keyNumber, squareArray);
			//extracting answer
			String ans="";
			number = -1;
			for(int i=0; i<cypherText.length()/key.length(); i++)
				for(int j=0; j<key.length(); j++)
				    ans += squareArray[i][j];
			return ans;
		}
		
		
		public static void main(String args[])
		{
			String message = "Geeks for Geekshjg";
			String key = "hack";
			String CypherText = Encryption(message, key);
			System.out.println("AFTTER ENCRYPTION: "+ CypherText);
			String PlainText = Decryption(CypherText, key);
			System.out.println("AFTTER DECRYPTION: "+ PlainText);
		}

}