/* Merge Two Sorted Lists 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */

public class MergeSortedLists {
	public static void main(String[] args) {
		// List 1: 1->3->7->11->null
        // List 2: 2->5->6->8->10->null

        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n7 = new ListNode(7);
        ListNode n11 = new ListNode(11);

        n1.next = n3;
        n3.next = n7;
        n7.next = n11;
        n11.next = null;

        ListNode n2 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n8 = new ListNode(8);
        ListNode n10 = new ListNode(10);

        n2.next = n5;
        n5.next = n6;
        n6.next = n8;
        n8.next = n10;
        n10.next = null;
        
        printList(mergeSortedLists2(n1, n2));
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

    // recursive 
	public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		if (l1.val < l2.val) {
        	l1.next = mergeSortedLists(l1.next, l2);
        	return l1;
        } else {
        	l2.next = mergeSortedLists(l1, l2.next);
        	return l2;
       }
	}

	public static ListNode mergeSortedLists2(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		ListNode fakeHead = new ListNode(0);
		ListNode result = fakeHead;
        
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				result.next = l1;
				l1 = l1.next;
			} else {
				result.next = l2;
				l2 = l2.next;
			}

			result = result.next;
		}
        
        if (l1 != null) {
        	result.next = l1;
        }
        
        if (l2 != null) {
        	result.next = l2;
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
