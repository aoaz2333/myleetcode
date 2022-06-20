package mango.listandarray.llinkedlist;

/**
 * 合并两个升序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class code21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = null;
        ListNode nowList = null;

        while (null != list1 && null != list2) {
            if (list1.val <= list2.val) {
                if (null == newList) {
                    newList = list1;
                    nowList = list1;
                } else {
                    nowList.next = list1;
                    nowList = nowList.next;
                }

                list1 = list1.next;
            } else {
                if (null == newList) {
                    newList = list2;
                    nowList = list2;
                } else {
                    nowList.next = list2;
                    nowList = nowList.next;
                }

                list2 = list2.next;
            }
        }

        while (null != list1){
            if (null == newList) {
                newList = list1;
                nowList = list1;
            } else {
                nowList.next = list1;
                nowList = nowList.next;
            }

            list1 = list1.next;
        }

        while(null != list2){
            if (null == newList) {
                newList = list2;
                nowList = list2;
            } else {
                nowList.next = list2;
                nowList = nowList.next;
            }

            list2 = list2.next;
        }

        return newList;
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
