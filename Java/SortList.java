/* Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

 public class SortList {
    // use merge sort 
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = getMid(head);
        
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftHead = head;
        
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        
        return merge(leftHead, rightHead);
    }
    
    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // see Merge Two Sorted Lists
    private static ListNode merge(ListNode l1, ListNode l2) {
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