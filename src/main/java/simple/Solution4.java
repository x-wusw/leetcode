package simple;
/*
     链表的中间结点
     给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     如果有两个中间结点，则返回第二个中间结点。
     思路：快慢指针，快的依一次走两步，慢的走一步当快的走到链表结尾，慢的刚好走到中间
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
public class Solution4 {
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null&& fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] n = new int[]{1,2,3,4,5,6};
        ListNode head = new ListNode(n);
        ListNode listNode = s.middleNode(head);
        System.out.println(listNode);

    }
}
