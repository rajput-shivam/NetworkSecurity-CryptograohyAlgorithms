class RailFenceCypher{
	
	    
		static void displayMatrix(char[][] X, int row, int col)
		{
			for(int i=0; i<row; i++){
				for(int j=0; j<col; j++)
					System.out.print(X[i][j]+" ");
				System.out.print("\n");}
		}
	
		static String Encryption(String plainText, int key)
		{
			int i=-2,j=0;
			char[][] zigzag_array = new char[key][plainText.length()];
			while(true)
			{
				for(i=i+2; i<key; i++,j++)
				{
						if(j==plainText.length())
							break;
						//System.out.println("\n"+i+","+j+" -->"+plainText.charAt(j));
						zigzag_array[i][j] = plainText.charAt(j); 
				}
				for(i=i-2; i>=0; i--,j++)
				{
						if(j==plainText.length())
							break;
						//System.out.println("\n"+i+","+j+" -->"+plainText.charAt(j));
						zigzag_array[i][j] = plainText.charAt(j); 
				}
				if(j==plainText.length())
							break;
			}
			displayMatrix(zigzag_array,key,plainText.length());
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
			while(true)
			{
				for(i=i+2; i<key; i++,j++)
				{
						if(j==cypherText.length())
							break;
						zigzag_array[i][j] = '\u039A';
				}
				for(i=i-2; i>=0; i--,j++)
				{
						if(j==cypherText.length())
							break;
						zigzag_array[i][j] = '\u039A'; 
				}
				if(j==cypherText.length())
							break;
			}
			displayMatrix(zigzag_array,key,cypherText.length());
			int k=-1;
			for(i=0; i<key; i++)
			{
				for(j=0; j<cypherText.length(); j++)
				{
					if(zigzag_array[i][j]=='\u039A')
					{
						k++;
						//System.out.println(i+" "+j+"  "+zigzag_array[i][j]+","+cypherText.charAt(k));
						zigzag_array[i][j]=cypherText.charAt(k);
					}
				}
			}
			String ans = "";
			i=-2;j=0;
			while(true)
			{
				for(i=i+2; i<key; i++,j++)
				{
						if(j==cypherText.length())
							break;
						ans += zigzag_array[i][j];
				}
				for(i=i-2; i>=0; i--,j++)
				{
						if(j==cypherText.length())
							break;
						ans += zigzag_array[i][j]; 
				}
				if(j==cypherText.length())
							break;
			}
			return ans;
		}
				
		
		
		public static void main(String args[])
		{
			String message = "defend the east wall";
			int key = 3;
			String CypherText = Encryption(message, key);
			System.out.println("AFTTER ENCRYPTION: "+ CypherText);
			String PlainText = Decryption(CypherText, key);
			System.out.println("AFTTER DECRYPTION: "+ PlainText);
		}

}