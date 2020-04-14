package medium;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *  给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 思路：
 *     （1）反转链表，求和，再反转
 *     （2）使用stack先进后出的特点
 */
public class Solution14 {
    /**第一种反转链表
     * 时间：O(max(m,n))
     * 空间：O(1)
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //将两个链表反转
        ListNode newl1 = reverse(l1);
        ListNode newl2 = reverse(l2);
        //标记是否有进位
        int carry = 0;
        ListNode after = null;
        while(newl1 != null || newl2 != null || carry !=0){
            int n1 = newl1==null ? 0 : newl1.val;
            int n2 = newl2==null ? 0 : newl2.val;
            newl1 = newl1 == null ? newl1 : newl1.next;
            newl2 = newl2 == null ? newl2 : newl2.next;
            //求和
            int sum = n1 + n2 + carry;
            //把低位放在链表尾端
            ListNode tmp = new ListNode(sum%10);
            tmp.next = after;
            after = tmp;
            carry = sum/10;
        }
        return after;
    }
    /**
    *将给定头结点的链表反转
    */
    private ListNode reverse(ListNode head){
        ListNode pre  = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    /**利用stack
     *时间:O(max(m,n))
     *空间:O(m+n) m与n分别为两个链表的长度 把链表入栈所用的空间。
     */
    private ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //java stack源码 推荐栈相关的用ArrayDeque类来实现 遵循官方建议所以用ArrayDeque
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();

        //将两个链表分别入栈
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2= l2.next;
        }

        int carry =0;
        ListNode after = null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0){
            //栈先进后出的性质 所以取出的是最后入栈的元素 并求和
            int n1 = stack1.isEmpty()?0:stack1.pop();
            int n2 = stack2.isEmpty()?0:stack2.pop();
            int sum = n1+n2+carry;

            //根据和求当前位置的值 和 进位的值 并连接上链表
            ListNode tmp = new ListNode(sum%10);
            tmp.next = after;
            after = tmp;
            carry=sum/10;
        }
        return after;
    }

    public static void main(String[] args) {
        Solution14 s = new Solution14();
        ListNode listNodes1 = new ListNode(1);
        ListNode listNodes2 = new ListNode(3);
        ListNode listNodes3 = new ListNode(2);
        listNodes1.next = listNodes2;
        listNodes2.next = listNodes3;

        ListNode listNodes10 = new ListNode(3);
        ListNode listNodes20 = new ListNode(1);
        ListNode listNodes30 = new ListNode(9);
        listNodes10.next = listNodes20;
        listNodes20.next = listNodes30;

        ListNode head = null;
        head = s.addTwoNumbers1(listNodes1,listNodes10);
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}
