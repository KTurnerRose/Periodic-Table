import java.util.List;
import java.util.ArrayList;
public class Compound 
{
	private List<Component> components;
	//list composed of Component (the data type) objects
	//lists DONT have constructors or instance variables
	private PeriodicTable pt;
	
	public Compound(List<Component> components, PeriodicTable pt)
	{
		this.components = components; 
		this.pt = pt;
	}
	
	public double getAtomicWeight()
	{
		/*for (int i = 0; i< components.size(); i++)
		{
			//size = length but for lists
			String sym = components.get(i).getSymbol();
			int freq = components.get(i).getFrequency();
		}
		for (int i = 0; i< components.size(); i++)
		{
			Component c = components.get(i);
			String sym = c.getSymbol();
			int freq = c.getFrequency();
		}
		*/
		double weight = 0.0;
		for (Component c : components)
		{
			/*Component = data type of each element in list 'components'
			c = components[i] AKA components.get(i)*/
			String sym = c.getSymbol();
			int freq = c.getFrequency();
			Element e = pt.getElement(sym);
			double eWeight = e.getAtomicWeight();
			double cWeight = eWeight * freq;
			weight+= cWeight;
			/* IN ONE LINE:
			   weight += pt.getElement(c.getSymbol()).getAtomicWeight() * c.getFrequency();*/
		}
		return weight;
	}
	
	public interface List<E> //contains only signatures of methods
	{
		boolean add(E e); //no implementation of this method (parameter = element of the list type)
		//ex./ components.add(new Component ("H", 2)
		
		void add(int index, E e); //inserts specified element at the specified position in this list.
		
		E remove(int index); //passed the index and removes element at that index
		
		//ex./ ArrayList<Student> students = new ArrayList<Student>(); --> correct syntax
	}
	
}
