package BlackRock;

public class LinkedListQs {

	public ListNode reverseListIt(ListNode head) {
		if(head==null|| head.next==null)
			return head;
		ListNode prev=null;
		ListNode curr=head;
		while(curr!=null){
			ListNode next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			
		}
		
		
		return prev;
	}
	
	public ListNode reverseList(ListNode head) {
		if(head==null|| head.next==null)
			return head;
		ListNode p=reverseList(head.next);
		head.next.next=head;
		head.next=null;
		return p;
		
	}
	
	/*public ListNode reverseBetween(ListNode head, int m, int n) {
        int count=1;
        ListNode runner=head,prev=null;
        ListNode revHead=null;
        int i=0;
        while(i<=m){
        	
        	
        }
        
        	
    }*/
	
	public boolean hasCycle(ListNode head) {
		
		if(head==null)
			return false;
		ListNode slowptr=head,fastptr=head.next;
		while(fastptr!=null &&fastptr.next!=null){
			fastptr=fastptr.next.next;
			slowptr=slowptr.next;
			if(slowptr==fastptr)
				return true;
		}
		
		
		
        return fastptr==null || fastptr.next==null;
    }
}
