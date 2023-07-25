
public class reverseKnodess {
    int val;
    reverseKnodess next;

    reverseKnodess() {
    }

    reverseKnodess(int val) {
        this.val = val;
    }

    reverseKnodess(int val, reverseKnodess next) {
        this.val = val;
        this.next = next;
    }
}

class reverseKnodes {
    static int lengthOfLL(reverseKnodess head) {
        int length = 0;

        while (head != null) {
            ++length;
            head = head.next;

        }
        return length;
    }

    public reverseKnodess reverseKGroup(reverseKnodess head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = lengthOfLL(head);

        reverseKnodess dummyHead = new reverseKnodess(0);

        dummyHead.next = head;

        reverseKnodess pre = dummyHead;
        reverseKnodess cur;
        reverseKnodess nex;

        while (length >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            length -= k;
        }
        return dummyHead.next;
    }
}