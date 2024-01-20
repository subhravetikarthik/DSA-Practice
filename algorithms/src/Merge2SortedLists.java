/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */

public class Merge2SortedLists {
    public static void main(String[] args) {
        ListNode<Integer> list1 = new ListNode<>(1);
        list1.next = new ListNode<>(2);
        list1.next.next = new ListNode<>(4);

        ListNode<Integer> list2 = new ListNode<>(1);
        list2.next = new ListNode<>(3);
        list2.next.next = new ListNode<>(5);

        ListNode<Integer> res = mergeTwoLists(list1, list2);
        printListNode(res);
    }

    public static ListNode<Integer> mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        return mergeListsUtil(list1, list2, new ListNode<>(Integer.MIN_VALUE));
    }

    public static ListNode<Integer> mergeListsUtil(ListNode<Integer> list1, ListNode<Integer> list2, ListNode<Integer> res) {
        ListNode<Integer> p1 = list1;
        ListNode<Integer> p2 = list2;
        ListNode<Integer> resHead = res;

        while(p1!=null && p2!=null) {
            if(p1.val <= p2.val) {
                resHead.next = new ListNode<>(p1.val);
                p1 = p1.next;
            } else {
                // p1.val > p2.val
                resHead.next = new ListNode<>(p2.val);
                p2 = p2.next;
            }
            resHead = resHead.next;
        }

        while(p1!=null) {
            resHead.next = new ListNode<>(p1.val);
            resHead = resHead.next;
            p1 = p1.next;
        }

        while(p2!=null) {
            resHead.next = new ListNode<>(p2.val);
            resHead = resHead.next;
            p2 = p2.next;
        }

        return res.next;
    }

    private static void printListNode(ListNode<Integer> head) {
        while(head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print(head.val);
    }
}
