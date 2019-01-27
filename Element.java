
public class Element
{
	//instance variables
	private int atomicNumber;
	private String symbol;
	private String name;
	private double atomicWeight;
	private int mostStableOxidationState;
	private String family;
	private boolean metal;
	
	//constructors
	public Element(String name, int num, String symbol, double weight, int mostStableOxState, String family, boolean metal)
	{
		this.name = name; atomicNumber = num; this.symbol = symbol; atomicWeight = weight;
		this.mostStableOxidationState = mostStableOxState; this.family = family; this.metal = metal;
	}
	
	//accessors
	public int getAtomicNumber() {return atomicNumber;}
	public String getSymbol() {return symbol;}
	public String getName() {return name;}
	public double getAtomicWeight() {return atomicWeight;}
	public int getMostStableOxState() {return mostStableOxidationState;}
	public String getFamily() {return family;}
	public boolean isMetal() {return metal;}

	public String toString()
	{
		return name + ", Symbol " + symbol + ", Family "+ family+ ", Atomic Number " + atomicNumber + ", Atomic Weight " + atomicWeight + ", Most stable oxidation state " + mostStableOxidationState + ", is a metal: " + metal;
	}
} 

