import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class PeriodicTableDataReader 
{
	public static void main(String[] args) throws Exception //if unanticipated error, gathers and stores this error
	{
		String filename = "elements.csv";
		File inputFile = new File(filename);
		if (!inputFile.exists())
			System.out.println(filename + " cannot be found");
		else
		{
			Scanner input = new Scanner(inputFile);
			//different kind of scanner which finds input from a file object (not from the user/their keyboard)
			//to test how long file is (and find out how many elements there are:
			int lineCount = 0;
			while (input.hasNextLine())
			{
				input.nextLine();
				lineCount++;
			}
			
			PeriodicTable pt = new PeriodicTable(lineCount);//calling constructor of periodicTable, which builds a table according to how many elements there are
			input.close();
			input = new Scanner(inputFile);
			
			String currentLine; //will keep track of entire line
			String[] elementData; //will be the array of strings the currentLine will be spit into
			Element e;
			//creating temporary variables
			String name, symbol, family;
			int atomicNum, mostStableState;
			double weight;
			boolean metal;
			
			//splitting strings on comma to create an array of strings which will be manipulated
			lineCount = 0;
			while (input.hasNextLine())
			{
				currentLine = input.nextLine();
				//splitting on comma, returning array where each element is up to the comma
				elementData = currentLine.split(",");
				//first element = the name
				name = elementData[0];
				//since every element is a string, using a wrapper class called integer, and 'parseInt' which take the element and putting it into static in class(???)
				atomicNum = Integer.parseInt(elementData[1]);
				symbol = elementData[2];
				//weight: used wrapper class called double, as well as "parseInt", parses string element into decimal number
				weight = Double.parseDouble(elementData[3]);
				//mostStableState: if the element is empty, set to -999; otherwise parse it into an integer class
				if (elementData[4].equals(""))
					mostStableState = -999;
				else
					mostStableState = Integer.parseInt(elementData[4]);
				family = elementData[5];
				//metal: if element has 'm' in it, set to true and otherwise false
				if (elementData[6].equals("M"))
					metal = true;
				else
					metal = false;
				
				//creating new element with the info
				e = new Element(name, atomicNum, symbol, weight, mostStableState, family, metal);
				//then using setElement to pass line number and setting the built element there
				pt.setElement(lineCount, e);
				//incrementing line and repeating
				lineCount++;
			}
			//close scanner, print out the table
			input.close();
			System.out.println(pt);
			System.out.println();
			
			Element foundEl = pt.getElement("N");
			System.out.println(foundEl);
			
			/*arrays are fixed in memory
			 making a compound class
			 bottom - up design: starting with specific class, then building compound class off of it
			 */
			}
		}
	//THIS CODE BELOW WILL BE POSTED ON MOODLE FOR REVIEW
	String element = "NaCl";
	public String[] parseOut(String userAnswer)
	{
		
		for (int i = 0; i < userAnswer.length(); i++)
		{
			Character ch = userAnswer.charAt(i);
			if (Character.isUpperCase(ch))
				//add ch to the compound object list (to correct index)
				userAnswer.split(ch);
		}
		
		
	}
}

