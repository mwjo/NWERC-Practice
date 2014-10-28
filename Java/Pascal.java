import java.util.Scanner;

public class Pascal
{	
	public int pascal(int i, int j) 
	{
       if ((j == 0) || (j == i)) return 1;
       else return pascal(i - 1, j - 1) + pascal(i - 1, j);
	}
	
	private boolean validInput(int row, int column)
	{
		if ( (row < 0) || (column < 0) || (row < column)) return false;
		else return true;
	}
	
	public void askForInput(Scanner in)
	{
		boolean valid = false;
		do 
		{
			System.out.print("Column: ");
			int column = Integer.valueOf(in.nextLine());
			System.out.print("Row: ");
			int row = Integer.valueOf(in.nextLine());
			if (validInput(row, column) == false)
			{
				System.out.println("Invalid input");
			}else
			{
				valid = true;
				System.out.println("Pascal("+column+","+row+") = "+pascal(row, column)+"\n");
			}
		}while (valid == false);
	}
	
	public static void main(String[] args)
	{   
		final String QUIT = "exit";
		String line = "";
		Pascal anObject = new Pascal();
		Scanner in = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			System.out.println("Press enter to continue, or type 'EXIT' to quit");
	        line = in.nextLine();
	        if (line.equals(QUIT)) {
	            System.out.println("You have exited the program");
	            repeat = false;
	        }else
	        {
	        	anObject.askForInput(in);
	        }
	    }
	}
}