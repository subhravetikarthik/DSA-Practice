/**
 * Remove all duplicates from linkedlist.
 * I/P: 1->2->2->3->4->->5->5
 * O/P: 1->3->4
 */

public class RemoveAllDuplicates {

    public static void main(String[] args) {

        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(3);
        head.next.next.next.next = new ListNode<>(4);
        head.next.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next.next = new ListNode<>(5);

        ListNode<Integer> res = removeAllDuplicates(head);
        while(res!=null) {
            System.out.print(res.val + "  ");
            res = res.next;
        }
        System.out.println();
    }

    private static ListNode<Integer> removeAllDuplicates(ListNode<Integer> head) {
        if(head == null) return null;

        ListNode<Integer> curr = head;
        ListNode<Integer> h = null;
        ListNode<Integer> t = null;

        while(curr!=null) {
            if(curr.next == null || (curr.val.intValue() != curr.next.val.intValue())) {
                if(h == null) {
                    h = curr;
                    t = curr;
                } else {
                    t.next = curr;
                    t = t.next;
                }
                curr = curr.next;
            } else {
                int dup = curr.val;
                while(curr != null && curr.val == dup) {
                    curr = curr.next;
                }
            }
        }
        if(t !=null) {
            t.next = null;
        }
        return h;
    }
}
