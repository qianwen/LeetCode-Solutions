/* Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 */

 public class ReorderList {
    // use merge sort 
    public static void main(String[] args) {
       	ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
 
		printList(n1);
 
		reorderList(n1);
 
		printList(n1);
    }
    
    // see Merge Two Sorted Lists
    private static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;// need to close first part
        
        // reverse order for second part
        second = reverseOrder(second);
        
        // merge two list
        while(second != null) {
            ListNode p1 = head.next;
            ListNode p2 = second.next;
            
            head.next = second;
            second.next = p1;
            
            head = p1;
            second = p2;
        }
    }

     public static ListNode reverseOrder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = head;
        ListNode cur = head.next;
        
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        
        head.next = null;
        
        return pre;
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