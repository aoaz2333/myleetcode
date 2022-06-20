package mango.listandarray.llinkedlist;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class code23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }

        //虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        //优先级队列，最小堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (ListNode a, ListNode b) -> (a.val - b.val));

        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }

        while(!priorityQueue.isEmpty()){
            ListNode minNode = priorityQueue.poll();
            p.next = minNode;
            if (null != minNode.next){
                priorityQueue.add(minNode.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
