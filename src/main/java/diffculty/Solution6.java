package diffculty;


/*
    合并k个链表
 */
public class Solution6 {
    /*private ListNode mergehelp(ListNode[] listNodes){
        if(listNodes == null || listNodes.length == 0){
            return null;
        }else {
            return help(listNodes,0,listNodes.length-1);
        }
    }

    //通过mid将数组一分为二，并不断缩小规模，当规模为1时返回并开始合并两个链表，不断增大其规模，整体看就是不断缩小-最后不断扩大的过程
    private ListNode help(ListNode[] listNodes,int start,int end){
        if(start == end){
            return listNodes[start];
        }
        int mid = start + (end-start)/2;
        //拆分
        ListNode left = help(listNodes,start,mid);
        ListNode right = help(listNodes,mid+1,end);
        //合并
        return merge(left,right);
    }

    //合并两个有序链表
    private ListNode merge(ListNode a,ListNode b){
        if(a == null || b == null){
            return (a == null) ? b : a;
        }
        if(a.val < b.val){
            a.next = merge(a.next,b);
            return a;
        }else {
            b.next = merge(b.next,a);
            return b;
        }

    }*/
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        ListNode listNodes1 = new ListNode(1);
        ListNode listNodes2 = new ListNode(3);
        ListNode listNodes3 = new ListNode(2);
        listNodes1.next = listNodes2;
        listNodes2.next = listNodes3;
        while (listNodes1!=null){
            System.out.print(listNodes1.val+"->");
            listNodes1 = listNodes1.next;
        }
        System.out.println();
        ListNode listNodes10 = new ListNode(3);
        ListNode listNodes20 = new ListNode(1);
        ListNode listNodes30 = new ListNode(9);
        listNodes10.next = listNodes20;
        listNodes20.next = listNodes30;
        while (listNodes10!=null){
            System.out.print(listNodes10.val+"->");
            listNodes10 = listNodes10.next;
        }
        System.out.println();
        ListNode[] listNodes = {new ListNode(1),new ListNode(4),new ListNode(2),new ListNode(3),new ListNode(0)};
        ListNode node = s.mergeKLists(listNodes);
        while (node != null){
            System.out.print(node.val+"->");
            node = node.next;

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

