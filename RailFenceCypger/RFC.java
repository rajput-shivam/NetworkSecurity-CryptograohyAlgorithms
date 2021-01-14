class RFC{
	
		static void displayMatrix(char[][] X)
		{
			for(char[] i: X){
				for(char j: i )
					System.out.print(j+" ");
				System.out.println();}
		}

		static String Encryption(String plainText, int key)
		{
			int i=-2,j=0;
			char[][] zigzag_array = new char[key][plainText.length()];
			while(j<plainText.length())
			{
				for(i=i+2; i<key && j<plainText.length(); i++,j++)
						zigzag_array[i][j] = plainText.charAt(j); 
				for(i=i-2; i>=0 && j<plainText.length(); i--,j++)
						zigzag_array[i][j] = plainText.charAt(j); 
			}
			displayMatrix(zigzag_array);
			String ans = "";
			for( char[] x : zigzag_array)
				for( char y : x )
					if(y !='\u0000')
						ans += y;
			return ans;
		}
		
		static String Decryption(String cypherText, int key)
		{
			int i=-2,j=0;
			char[][] zigzag_array = new char[key][cypherText.length()];
			while(j<cypherText.length())
			{
				for(i=i+2; i<key && j<cypherText.length(); i++,j++)
						zigzag_array[i][j] = '\u039A';
				for(i=i-2; i>=0 && j<cypherText.length(); i--,j++)
						zigzag_array[i][j] = '\u039A'; 
			}
			displayMatrix(zigzag_array);
			int k=-1;
			for(i=0; i<key; i++)
				for(j=0; j<cypherText.length(); j++)
					if(zigzag_array[i][j]=='\u039A')
						zigzag_array[i][j]=cypherText.charAt(++k);
			displayMatrix(zigzag_array);
			String ans = "";
			i=-2;j=0;
			while(j<cypherText.length())
			{
				for(i=i+2; i<key && j<cypherText.length(); i++,j++)
						ans += zigzag_array[i][j];
				for(i=i-2; i>=0 && j<cypherText.length(); i--,j++)
						ans += zigzag_array[i][j]; 
			}
			return ans;
		}
				
		
		
		public static void main(String args[])
		{
			String message = "defend the east wall";
			int key = 5;
			String CypherText = Encryption(message, key);
			System.out.println("AFTTER ENCRYPTION: "+ CypherText);
			String PlainText = Decryption(CypherText, key);
			System.out.println("AFTTER DECRYPTION: "+ PlainText);
		}

}