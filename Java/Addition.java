import java.io.*;
import java.util.*;

public class Addition
{
	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		
		String[] sizes = line.split("\\s+");
		int n = Integer.valueOf(sizes[0]);
		int s = Integer.valueOf(sizes[1]);
		int[] array = new int[n];
		
		line = in.nextLine();
		String[] integers = line.split("\\s+");
		for (int i = 0; i < integers.length; i++)
		{
			array[i] = Integer.valueOf(integers[i]);
		}
		
		Arrays.sort(array);
		
		int val;
		
		for (int i = 0; i < n; i++)
		{
			val = array[i];
			int lookingFor = s - val;

			boolean found = false;
			for (int lef = i+1, right = n; lef < right;) {
				int mid = (lef + right) / 2;
				if (array[mid] == lookingFor) {
					found = true;
					break;
				}
				if (array[mid] < lookingFor) lef = mid + 1;
				if (array[mid] > lookingFor) right = mid;
			}
			if (found) {
				System.out.println("" + val + " " + lookingFor);
				return;
			}
		}
		System.out.println("Impossible");
	}
}
