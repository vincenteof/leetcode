package AddTwoNumbers;

// no.2
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addWithCarry(l1, l2, 0);
    }

    public ListNode addWithCarry(ListNode l1, ListNode l2, int carry) {
        if (l1 == null) {
            return addOneCarry(l2, carry);
        }
        if (l2 == null) {
            return addOneCarry(l1, carry);
        }
        int sum = l1.val + l2.val + carry;
        int currentBit = sum % 10;
        int currentCarry = sum / 10;
        ListNode subRet = addWithCarry(l1.next, l2.next, currentCarry);
        ListNode current = new ListNode(currentBit);
        current.next = subRet;
        return current;
    }

    public ListNode addOneCarry(ListNode l, int carry) {
        if (carry == 0) {
            return l;
        }
        ListNode one = new ListNode(carry);
        return addTwoNumbers(l, one);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}