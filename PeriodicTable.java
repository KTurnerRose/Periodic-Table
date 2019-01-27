
public class PeriodicTable 
{
	//instance variables
	private Element[] table;
	
	//constructor
	public PeriodicTable (int numOfElements)
	{
		table = new Element[numOfElements];
		/*
		- LIST CREATION: List<Element> table = new ArrayList<Element>(); when ArrayList is a linked list
		- generics allow u to announce what a specific list contains ("is of")
		- all lists follow the same api (Application Programming Interface - gives you the signature of methods) -->   
		*/
	}
	
	//mutator
	public void setElement(int i, Element e)
	{
		table[i] = e;
	}
	
	public Element getElement(String symbol)
	{
		//you give it the symbol and it returns the entire element object (it's in effect an accessor)
		//precondition:  table is sorted by symbol
		//returns null if it can't return the object
		for (int i = 0; i < table.length; i++)
		{
			String currentSymbol = table[i].getSymbol();
			if (currentSymbol.equals(symbol)) // == tests memory addresses --> the method would only return null
			{
				return table[i];
			}
		}
		return null;
	}

	public String toString()
	{
		String output = "";
		for (Element e : table)
			output += e.toString() + "\n ";
		return output;
	}
	
	public void sortByName()
	{
		for (int i = 1; i < table.length; i++)
		{
			Element temp = table[i];
			int possibleIndex = i;
			while (possibleIndex >0 && temp.getName().compareTo(table[possibleIndex - 1].getName()) < 0) //for ascending sort
			{
				table[possibleIndex] = table[possibleIndex-1];
				possibleIndex--;
			}
		}
	}
	
	public void sortBySymbol()
	{
		//insertion sort
		for (int i = 1; i < table.length; i++)
		{
			Element temp = table[i];
			int possibleIndex = i;
			while (possibleIndex >0 && temp.getSymbol().compareTo(table[possibleIndex - 1].getSymbol()) < 0) //for ascending sort
			{
				table[possibleIndex] = table[possibleIndex-1];
				possibleIndex--;
			}
		}
	}
	
	/*
	public static void insertionSortAscending(int[] arr)
	{
		for(int k = 1; k < arr.length; k++)
		{
			int temp = arr[k];
			int possibleIdx = k;
			while (possibleIdx > 0 && temp < arr[possibleIdx - 1])
			{
				arr[possibleIdx] = arr[possibleIdx - 1];
				possibleIdx--;
			}
			arr[possibleIdx] = temp;
			
			ex./arr= {1,2,4,5,9,2,3,7,3,8};
			 k = 5; possibleIdx = 5; temp = 2;
			 2 < arr[possibleIdx-1] ---> 2 < arr[4] ---> 2 < 9 TRUE
			 	---> temp = 2; arr[4] AKA 9 moves to arr[5]; temp = arr[4]; AKA 2 moves to arr[4], 9 moves to arr[5]
			 
		}
	}
	public static void ascendingOrder(int arr)
	{
		for (int k = 0; k < arr.length; k++)
		{
			int lowPosition = k; //assuming starting value is smallest
			for(int j = k+1; j < arr.length; j++)
			{
				if (arr[j] < arr[lowPosition])
					lowPosition = j;
				
			}
			int temp = arr[k];
			arr[k] = arr[lowPosition];
			arr[lowPosition] = temp;
	}
	*/
	public void sortByAtomicWeight()
	{
		for (int i = 0; i < table.length; i++)
		{
			if(table[i].getAtomicNumber() > table[i+1].getAtomicNumber())
			{
				//table[i] moves in front of table[i+1]
				Element temp = table[i];
				Element temp2 = table[i+1];
				table[i+1] = temp;
				table[i] = temp2;
			}
		}
	}
	
	public static int binarySearch (int[] periodicTable, int target)
	{
		//precondition: array is sorted
		int left = 0; int right = periodicTable.length();
		while (left <= right)
		{
			int med = (left+right)/2;
			if(target > periodicTable[med])
				left = med-1;
			else if(target < periodicTable[med])
				right = med+1;
			else
				return med;
		}
		return -1;
	}
	
	public static int binarySearch (int[] periodicTable, Element element)
	{
		//precondition: array is sorted
		int left = 0; int right = periodicTable.length();
		name = element.getName();
		while (left <= right)
		{
			int med = (left+right)/2;
			if(name.compareTo(periodicTable[med]) > 0)
				left = med-1;
			else if(name.compareTo(periodicTable[med]) < 0)
				right = med+1;
			else
				return med;
		}
		return -1;
	}
	
}
