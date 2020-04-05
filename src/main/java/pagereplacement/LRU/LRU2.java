package pagereplacement.LRU;
import java.util.HashMap;
import java.util.Map;

//解法二：使用双链表+HashMap
public class LRU2 { //定义双向链表节点
    private class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;     //key->node
    private ListNode head;  //dummy head
    private ListNode tail;  //dummy tail

    public LRU2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        //先把这个节点删除，再接到尾部
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);

        return node.val;
    }

    public void put(int key, int value) {
        //直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        //不存在，new一个出来,如果超出容量，把头去掉
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        moveToTail(node);

        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    private void moveToTail(ListNode node) {
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }
}
