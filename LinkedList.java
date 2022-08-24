public class LinkedList {
    private ListNode head1 = null;
    private ListNode head2 = null;

    // Merge two sorted list and return it as a new list(with dummy).
    public ListNode MergeSortedList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                curr.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            curr = curr.next;
        }
        while (head2 != null) {
            curr.next = new ListNode(head2.val);
            head2 = head2.next;
            curr = curr.next;
        }
        while (head1 != null) {
            curr.next = new ListNode(head1.val);
            head1 = head1.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();

        list.head1 = new ListNode(1);
        list.head1.next = new ListNode(2);
        list.head1.next.next = new ListNode(2);
        list.head1.next.next.next = new ListNode(2);

        list.head2 = new ListNode(-1);
        list.head2.next = new ListNode(3);
        list.head2.next.next = new ListNode(4);
        list.head2.next.next.next = new ListNode(5);

        ListNode merge = list.MergeSortedList(list.head1, list.head2);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}
