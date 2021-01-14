import java.util.*;
import java.io.*;

class CaesarCypher{
	
		static String Encryption(String plainText)
		{
			String ans=" ";
			String normalAlpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ \n";
			String encryptedAlpha = "defghijklmnopqrstuvwxyzabcDEFGHIJKLMNOPQRSTUVWXYZABC \n";
			for ( int i=0; i<plainText.length(); i++ )
				ans += encryptedAlpha.charAt(normalAlpha.indexOf(plainText.charAt(i)));
			return ans;
		}
		static String Decryption(String cypherText)
		{
			String ans=" ";
			String normalAlpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ \n";
			String encryptedAlpha = "defghijklmnopqrstuvwxyzabcDEFGHIJKLMNOPQRSTUVWXYZABC \n";
			for ( int i=0; i<cypherText.length(); i++ )
				 ans += normalAlpha.charAt(encryptedAlpha.indexOf(cypherText.charAt(i)));
			return ans;
		}

		public static void main(String args[])
		{
			String message = "";
			String ans1,ans2;
			try 
			{
				File TextFile = new File("CaesarText.txt");
				Scanner myReader = new Scanner(TextFile);
				while (myReader.hasNextLine())             // hasNext() reads every word but does not read space( ) and nextline(\n).
					message += myReader.nextLine() + "\n"; // hasNextLine() reads every sentence but does not read next line(\n).
                myReader.close();
				System.out.println("MESSAGE FROM FILE: \n"+message);
				FileWriter myWriter = new FileWriter("CaesarTextPart2.txt");
				String x=Encryption(message);
				myWriter.write("ENCRYPTION\n"+x);
				myWriter.write("\nDECRYPTION OF ABOVE MESSAGE\n"+Decryption(x));
				myWriter.close();
			} 
			catch (Exception e) 
			{  System.out.println("WRONG FILE GIVEN");}
		
		}

}