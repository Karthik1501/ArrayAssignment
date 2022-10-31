package test;
import java.util.*;
public class Oct31Five {
	
		public Node first;
		public Node last;

		class Node {
			public int value;
			public Node next = null;

			public Node(int value) {
				this.value = value;
				this.next = null;
			}

		}

		public void add(int value) {
			Node newNode = new Node(value);
			if (last != null) {
				last.next = newNode;
			} 
			if(first == null)
				first = newNode;

			last = newNode;
		}

		public void nextGreater() {
			Node head = first;
			int max = 0;
			while (head != null) {	
				
				Node second = head.next;
				max = 0;

				while (second != null) {
					
					if (head.value < second.value) {
						max = second.value;
						break;
					}

					second = second.next;
				}
				System.out.print(max+" ");

				head = head.next;

			}
		}

		public static void main(String[] args) {
			Oct31Five myll = new Oct31Five();
			myll.add(2);
			myll.add(7);
			myll.add(4);
			myll.add(3);
			myll.add(5);

			myll.nextGreater();
		}

	
}
