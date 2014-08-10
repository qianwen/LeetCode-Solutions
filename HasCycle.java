/* Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 */

 /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 public class HasCycle {
 	public boolen hasCycle(ListNode head) {
 		if (head == null || head.next == null) {
 			return false;
 		} 
        
        ListNode slow = head.next;
        ListNode fast = head.next;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (fast == null) {
                return false;
            }
            
            if (slow.val == fast.val) {
                return true;
            }
        }
        
        return false;
 	}
 }