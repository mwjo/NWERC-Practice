import java.util.Scanner;

public class BalancedParenthesis {

	private boolean checkValidity(String str, int currentParenthesis, int currentIndex)
	{
		if (currentIndex < str.length())
		{
			char val = str.charAt(currentIndex);
	   	    currentIndex++;
	   	    if (val == "(".charAt(0))
	   	    {
	   	    	currentParenthesis++;
	   	    	return checkValidity(str, currentParenthesis, currentIndex);
	   	    }
	   	    else if (val == ")".charAt(0))
	   	    {
	   	    	if (currentParenthesis > 0)
	   	    	{
	   	    		currentParenthesis--;
	   	    		return checkValidity(str, currentParenthesis, currentIndex);
	   	    	}else{
	   	    		return false;
	   	    	}
	   	    }
		}
		if (currentIndex < str.length()) return checkValidity(str, currentParenthesis, currentIndex);
		else if (currentParenthesis != 0) return false;
		else return true;
	}
	
	public static void main(String[] args)
	{ 
		Balanced anObject = new Balanced();
		System.out.println(anObject.checkValidity("I told him (that it’s not (yet) done). (But he wasn’t listening)", 0, 0));
		System.out.println(anObject.checkValidity("(if (zero? x) max (/ 1 x))", 0, 0));
		System.out.println(anObject.checkValidity(":-)", 0, 0));
		System.out.println(anObject.checkValidity("())(", 0, 0));
		
		final String exit = "exit";
		String line = "";
		Scanner in = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			System.out.println("\nEnter your input, or type 'exit' to quit");
	        line = in.nextLine();
	        if (line.equals(exit)) {
	            System.out.println("You have exited the program");
	            repeat = false;
	        }else
	        {
	        	System.out.println(anObject.checkValidity(line, 0, 0));
	        }
	    }
	}
}