package problems.dsa.days.day3;

public class ReverseNodesK {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode current = head;
        ListNode groupPrev = null;

        int length = getListLength(head);

        while (length > k) {
            ListNode groupStart = current;

            for (int i = 0; i < k; i++) {
                ListNode nextNode = current.next;
                current.next = groupPrev;
                groupPrev = current;
                current = nextNode;
            }

            prevGroupTail.next = groupPrev;
            groupStart.next = current;

            prevGroupTail = groupStart;
            length -= k;
        }

        return dummy.next;
    }

    private static int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    //
    public static ListNode reverse(ListNode head, ListNode headRef)
    {
        ListNode first, rest;

        // empty list base case
        if (head == null) {
            return headRef;
        }

        first = head;           // suppose first = {1, 2, 3}
        rest = first.next;      // rest = {2, 3}

        // base case: the list has only one node
        if (rest == null)
        {
            // fix the head pointer here
            headRef = first;
            return headRef;
        }

        // recursively reverse the smaller {2, 3} case
        // after: rest = {3, 2}
        headRef = reverse(rest, headRef);

        // put the first item at the end of the list
        rest.next = first;
        first.next = null;      // (tricky step — make a drawing)

        return headRef;
    }
    public static void main(String[] args) {
        int[] keys = { 8, 6, 4, 9, 3, 1 };

        ListNode head = null;
        for (int key: keys) {
            head = new ListNode(key, head);
        }

        System.out.println("Original List:");
        printList(head);
        //head=reverse(head,head);// total reverse
        head=reverseKGroup(head,2);
        printList(head);

    }
}
