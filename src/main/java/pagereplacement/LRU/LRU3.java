package pagereplacement.LRU;

import java.util.HashMap;
import java.util.Map;

//解法三：使用单链表
public class LRU3 {
    private class ListNode {
        int key, val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;     //key-> node.pre
    private ListNode head;  //dummy
    private ListNode tail;

    public LRU3(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(-1, -1);
        tail = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //map中存放的是要找的节点的前驱
        ListNode pre = map.get(key);
        ListNode cur = pre.next;

        //把当前节点删掉并移到尾部
        if (cur != tail) {
            pre.next = cur.next;
            map.put(cur.next.key, pre); //更新它后面node的前驱
            map.put(cur.key, tail);
            moveToTail(cur);
        }
        return cur.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).next.val = value;
            return;
        }
        //不存在就new一个
        ListNode node = new ListNode(key, value);
        map.put(key, tail); //当前node的pre是tail
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            map.put(head.next.next.key, head);
            head.next = head.next.next;
        }
    }

    private void moveToTail(ListNode node) {
        node.next = null;
        tail.next = node;
        tail = tail.next;
    }
}
