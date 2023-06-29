

public class reverseKnodes {
    int val;
    reverseKnodes next;
    reverseKnodes() {}
    reverseKnodes(int val) { this.val = val; }
    reverseKnodes(int val, reverseKnodes next) { this.val = val; this.next = next; }
}
 
class Solution {
    static int lengthOfLL(reverseKnodes head){
      int length = 0;

      while(head!=null){
          ++length;
          head = head.next;

      }
      return length;
    }
    public reverseKnodes reverseKGroup(reverseKnodes head, int k) {
        if(head == null|| head.next == null) return head;

        int length = lengthOfLL(head);

        reverseKnodes dummyHead = new reverseKnodes(0);

        dummyHead.next =  head;

        reverseKnodes pre = dummyHead;
        reverseKnodes cur;
        reverseKnodes nex;

        while(length >= k){
            cur = pre.next;
            nex = cur.next;
            for(int i = 1;i<k;i++){
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            length-=k;
        }
        return dummyHead.next;
    }
}