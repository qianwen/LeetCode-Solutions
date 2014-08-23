/* Linked List Cycle II 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
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

 public class DetectCycle {
 	public boolen DetectCycle(ListNode head) {
 		if (head == null || head.next == null) {
 			return null;
 		} 
        
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // slow and fast meet at a node inside the cycle 
            // break from the while loop
            if (fast == slow) {
                break;
            }
        }
        
        // make sure there is a cycle found inside the while loop
        if (slow == null || fast == null || fast.next == null) {
            return null;
        }
        
        // let the slow start from the head
        slow = head;
        // slow and fast are in the same pace now
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
 	}
 }