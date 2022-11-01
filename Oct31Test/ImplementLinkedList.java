package test;
import java.util.*;
public class ImplementLinkedList {
	
		public Node head=null;
		Node tail = null;
		int size=0;
		

		class Node {
			
			public int value;
			public Node next;

			public Node(int value) {
				this.value = value;
				this.next = null;
			}

		}

		public void add(int value) {
			size++;
			Node newNode = new Node(value);
			
			if(head == null)
				head = newNode;
			else
				tail.next=newNode;
			
			tail= newNode;
		}
		
		public void print() {
			Node curr=head;
			
			while(curr!=null) {
				System.out.print(curr.value+" ");
				curr=curr.next;
			}
		}
		
		public int[] nextGreater() {
			int[] res=new int[size];
			int index =0;
			Node head = this.head;
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
				res[index++] = max;
				//System.out.print(max+" ");

				head = head.next;

			}
			return res;
		}

		public static void main(String[] args) {
			ImplementLinkedList myll = new ImplementLinkedList();
			myll.add(2);
			myll.add(7);
			myll.add(4);
			myll.add(3);
			myll.add(5);
			
			myll.print();
			System.out.println("\n"+Arrays.toString(myll.nextGreater()));
		}

	
}
