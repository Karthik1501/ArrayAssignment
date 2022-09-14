import java.util.*;
public class queue {

	public static void main(String[] args) {
		
		// create a priorityQueue FIFO  
		Queue<Integer> que= new LinkedList<>();
		
		//add element in priorityqueue
		que.add(101);
		que.add(102);
		que.add(103);
		que.add(104);
		que.add(105);
		//que.remove();
		//check if value present it return true otherwise false 
		System.out.println(que.contains(103));
		
		// it return peek of element . queue is it will be return null
		System.out.println("peek() : "+que.peek());
		
		//Retrieves, but does not remove, the head of this queue. queue is empty it throw a exception
		System.out.println("element() :"+que.element());
	 	
		
		// remove First index element 
		System.out.println(que.remove());
		
		System.out.println(que);
		
		deque();
	}
	
	public static void deque(){ 
		// Deque intrface 
		Deque<Integer> que1= new ArrayDeque<>();
		
		//it's normal queue add method
		que1.add(1);
		que1.add(3);
		
		// add element in first position
		que1.addFirst(2);
		
		// add element in last position
		que1.addLast(0);
		
		//getFirst method use to get first position element
		System.out.println("getFirst : "+que1.getFirst());
		
		//getLast method use to get last position element
		System.out.println("getLast : "+ que1.getLast());
		
		//removeFirst method use to get first position element
		System.out.println("getFirst : "+que1.removeFirst());
				
		//removeLast method use to get last position element
		System.out.println("getLast : "+ que1.removeLast());
		
		
		System.out.println(que1);
		
	}

}
