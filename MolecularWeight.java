import java.util.Scanner;
import java.util.ArrayList;
public class MolecularWeight 
{
	private PeriodicTable pt; //periodic table taken as input
	private String errorMsg;
	
	Scanner userInput = new Scanner(System.in);
	String userAnswer = userInput.next();
	System.out.println("Enter the name of an element compound, like H20 or NaCl.");
	parseOut(userAnswer);
	
	public MolecularWeight(PeriodicTable pt)
	{
		this.pt = pt;
		runMolecularWeight();
	}
	
	public void runMolecularWeight()
	{
		/*
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("SanSerif", Font.BOLD, 20)));
		UIManager.put("OptionPane.messageForeground")
		*/
	}
	//parse out components (separated by capital letter) of an element and add them to a compound object

	public String[] parseOut(String userAnswer)
	{
		/*Character.isUpperCase(char)
		String str = "ThisIsAString";
            String res = "";
            for(int i = 0; i < str.length(); i++) {
                    Character ch = str.charAt(i);
                    if(Character.isUpperCase(ch))
                            res += " " + Character.toLowerCase(ch);
                    else
                            res += ch;
       */
		char current, next;
		ArrayList<Integer> startPosOfComponent = new ArrayList<Integer>();
		for (int i = 0; i < userAnswer.length(); i++)
		{
			Character ch = userAnswer.charAt(i);
			if (Character.isUpperCase(ch))
				//add ch to the compound object list (to correct index)
				startPosOfComponent.add(new Integer(i));
		}
		
		
	}
}
