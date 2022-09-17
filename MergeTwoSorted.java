public class MergeTwoSorted {
    // Merge two sorted list and return it as a new list(with dummy).
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // check inputs null or not
        if (list1 == null && list2 != null)
            return list2;
        if (list1 != null && list2 == null)
            return list1;
        if (list1 == null && list2 == null)
            return list1;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        // while loop to insert value into linked list
        // as increasing order
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }

    public static void main(String[] args) throws Exception {
        MergeTwoSorted merge = new MergeTwoSorted();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode out = merge.mergeTwoLists(list1, list2);
        while (out != null) {
            System.out.println(out.val);
            out = out.next;
        }

    }
}
