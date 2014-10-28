import java.io.*;
import java.util.Scanner;

public class Autocomplete {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		
		String[] sizes = line.split("\\s+");
		int dict_size = Integer.valueOf(sizes[0]);
		int frag_size = Integer.valueOf(sizes[1]);
		
		line = in.nextLine();
		String[] full_words = line.split("\\s+");
		
		line = in.nextLine();
		String[] partial_words = line.split("\\s+");
		
		int out = 0;
		int address = 0;
		String to_output = "";
		for (int i = 0; i < frag_size; i++)
		{
			String val = partial_words[i];
			out = 0;
			for (int x = 0; x < dict_size; x++)
			{
				if (full_words[x].startsWith(val))
				{
					out++;
					address = x;
					to_output = full_words[x];
				}
			}
			if (out == 0)
			{
				System.out.println("NONE");
			}else if (out == 1)
			{
				System.out.println(to_output);
			}else
			{
				System.out.println("AMBIGUOUS");
			}
		}	
		
	}

}
