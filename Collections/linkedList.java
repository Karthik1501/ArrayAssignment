import java.util.*;
public class linkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> l_list = new LinkedList<>();
		
		// add() method use to add element
		l_list.add("Java");
		l_list.add("C++");
		
		// addFirst() method use to add element	at First position	
		l_list.addLast("C");
		
		// addLast() method use to add element	at last position
		l_list.addFirst("Python");
		
		// it's remove first index
		l_list.removeFirst();
		
		// addLast() method use to add element	at last position
		l_list.addFirst("Python");
				
	    //remove last index
		l_list.removeLast();
		
		
	   System.out.println("Get element by first index :" + l_list.getFirst());
	   
	   System.out.println("Get element by last index :" +l_list.getLast());

		System.out.println(l_list);
	}

}
