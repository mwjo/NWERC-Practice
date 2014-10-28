import java.util.Scanner;

//Implements the Rabin and Karp algorithm for string matching

public class RabinAndKarp 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String needle = in.nextLine();
		String haystack = in.nextLine();
		
		int[] output = getOutput(needle, haystack);
		printOutput(output);
	}
	
	static void printOutput(int[] output)
	{
		for (int i = 0; i < output.length; i++)
		{	
			if (output[i] == 1) System.out.print("^");
			else System.out.print(" ");
		}
	}
	
	static int getHash(String input)
	{
		int hash = 0;
		char val;
		for (int i = 0; i < input.length(); i++)
		{
			val = input.charAt(i);
			hash += (int)val;
		}
		return hash;
	}
	
	static int[] getOutput(String needle, String haystack)
	{
		String output = "";
		int needleLength = needle.length();
		int haystackLength = haystack.length();
		int[] positions = new int[haystackLength];
		
		int hashNeedle = getHash(needle);
		int hashHaystack = getHash(haystack.substring(0, needleLength));
		
		if (hashHaystack == hashNeedle)
		{
			if (haystack.substring(0, needleLength).equals(needle))
			{
				positions[0] = 1;
			}
		}
		
		for (int i = 1; i <= (haystackLength - (needleLength)); i++)
		{
			hashHaystack -= (int)haystack.charAt(i-1);
			hashHaystack += (int)haystack.charAt(needleLength+i-1);
			if (hashHaystack == hashNeedle)
			{
				if (haystack.substring(i, needleLength+i).equals(needle))
				{
					positions[i] = 1;
				}
			}
		}
		
		return positions;
	}
}
