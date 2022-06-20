package mango.listandarray.llinkedlist;

/**
 * 获取倒数第k个节点，时间复杂度为 O(n)
 * <p>
 * 双指针同时向后遍历，第1个指针先走K步，第2个指针再出发
 * 这样再第2个指针到达终点时，第一个指针也到达k点
 */
public class last_k_node {
    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = head.next;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}
