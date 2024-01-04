import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val < b.val ? -1 : 1);

        for (ListNode head : lists) {
            if (head == null) continue;
            ListNode node = head;
            while (node != null) {
                pq.offer(node);
                node = node.next;
            }
        }

        ListNode head = pq.poll();
        ListNode node = head;
        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            nextNode.next = null;
            node.next = nextNode;
            node = nextNode;
        }
        return head;
    }
}