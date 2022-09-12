import java.util.*;
public class vectorCollection {

	public static void main(String[] args) {
		//create a vector
		Vector<Integer> vector = new Vector<Integer>();
        
		//adding elements add() method
		vector.add(12);
		vector.add(23);
		vector.add(34);
		vector.add(20);
		
		//adding elements addElement() method
		vector.addElement(54);
		
		//remove element by index
		vector.remove(0);
		//add element by index
		vector.set(0, 10);
		// if element present or not
		System.out.println(vector.contains(20));
		// return the size of vector
		System.out.println("vector size : "+ vector.size());
		System.out.println("get element by index : "+ vector.get(0));
		System.out.println("indexof use to find index : "+ vector.indexOf(34));
		System.out.println(vector);
	}

}
