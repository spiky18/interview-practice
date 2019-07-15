package com.leetcode;

public class SortLinkedList {
	public ListNode sortList(ListNode head) {
        if(head==null)
            return head;
        ListNode count=head;
        int i=1;
        while(count.next!=null){
            count=count.next;
            i++;
        }
        //System.out.print(i);
        return mergeSort(head,1,i);
    }
    
    public ListNode mergeSort(ListNode head,int start,int end){
        if(end>start){
            int mid=start+(end-start)/2;
            int i=start;
            ListNode midNode=head;
            while(i<mid){
                midNode=midNode.next;
                i++;
            }
            ListNode nextMidNode=midNode.next;
            midNode.next=null;
            ListNode left=mergeSort(head,start,mid);
            ListNode right=mergeSort(nextMidNode,mid+1,end);
            return merge(left,right);
        }
        return head;
    }
    
    public ListNode merge(ListNode left,ListNode right){
        ListNode leftptr=left;
        ListNode rightptr=right;
        ListNode prev=null,head=null;
        while(leftptr!=null && rightptr!=null){
            if(leftptr.val<=rightptr.val){
            	if(prev==null){
            		prev=leftptr;
            		}
            	else
            		{
            			prev.next=leftptr;
            			prev=prev.next;
            		}
                leftptr=leftptr.next;
            }
            else{
            	if(prev==null){
            		prev=rightptr;
            		rightptr=rightptr.next;
            		}
            	else
            	{
        			prev.next=rightptr;
        			ListNode temp2=rightptr.next;
        			rightptr.next=leftptr;
        			prev=prev.next;
        			rightptr=temp2;
        		}
            }
            if(head==null)
            	head=prev;
            
        }
        if(leftptr==null )
            prev.next=rightptr;
        else if(rightptr==null)
        	prev.next=leftptr;
        return head;
    }
    
    public static void main(String[] args) {
		ListNode list=new ListNode(5);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(7);
		ListNode l4=new ListNode(3);
		list.next=l2;
		l2.next=l3;
		l3.next=l4;
		System.out.println(list.toString());
		SortLinkedList obj =new SortLinkedList();
		list=obj.sortList(list);
		System.out.println(list);
	}
}
