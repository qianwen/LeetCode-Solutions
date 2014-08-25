/* Insertion Sort List 
 * Sort a linked list using insertion sort.
 */

 public class InsertionSortList {
 	public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(7);
        ListNode n6 = new ListNode(11);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        
       // printList(insertionSortList(n1));
    }
    
    public static void printList(ListNode x) {
		if (x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null && head.next == null) {
			return head;
		} 

		ListNode fakeHead = new ListNode(0);
		ListNode curr = head;
        
        while (curr != null) {
        	ListNode next = curr.next;
            ListNode prev = fakeHead;
            
            //find out the inserting position
        	while (prev.next != null && prev.next.val < curr.val) {
        		prev = prev.next;
        	}
            
            //insert into the sorted part  
            curr.next = prev.next;
            prev.next = curr;
            curr = next;

            printList(fakeHead.next);
        }

        return fakeHead.next;
    }
 }

//Definition for singly-linked list.
class ListNode {
 	public int val;
 	public ListNode next;

 	public ListNode(int x) {
        val = x;
        this.next = null;
     }
}