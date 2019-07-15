package com.general.linkedlist;

public class DLLDemo {

	public static void main(String[] args) throws Exception {
		DoublyLinkedList dll=new DoublyLinkedList();
		System.out.println(dll);
		dll.insertAtBegin(0);
		System.out.println(dll);
		dll.insertAtEnd(1005);;
		System.out.println(dll);
		int i=2;
		//dll.insertAtPos(i, i);
		while(i<15){
			dll.insertAtPos(i, i);
			i++;
		}
		System.out.println(dll);
		dll.deleteFirst();
		System.out.println(dll);
		dll.deleteLast();
		System.out.println(dll);
		i=2;
		while(i<15){
			dll.deletePos(1);
			
			System.out.println(dll);
			i++;
		}
		
		/*while(i<10){
			
		}*/
	}

}
