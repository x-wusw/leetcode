package pagereplacement.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    LRU（least recently used）最近最少使用，首先淘汰最长时间未被使用的页面
    RU总体上是这样的，最近使用的放在最左边，最近没用的放到最右边，来了一个新的数，如果内存满了，把旧的数淘汰掉
    解决：链表（处理新老关系）+哈希（查询在不在），分析如下
    --  底层应该用链表，按照数据的新旧程度来排列，旧的在左边，新的在右边，新来一个加到尾部，删除是删头,除了这两个操作，
    还有就是把一个数据从中间拿出来放尾巴上（这个数组就很难做到）
    --  这里还有一个需求，就是要知道这个数据有没有存在于链表中，如果不在链表中，加到尾巴即可，如果已经在链表中，就只要更细数据的位置,
    如何查找这个数据在不在呢，这就用哈希表。
    --  考虑删除操作，要把当前节点的前一个节点的指针的改变，获取它前一个节点，方便的数据结构就是 双向链表
    所以我们用的数据结构就是 LinkedList(底层是双向链表)+ HashMap,而实际上可以直接用LinkedHashMap更为方便。看面试官要求是啥了。
 */
//解法一：使用LinkedHashMap
public class LRU {
    int capactity;
    Map<Integer,Integer> map;
    public LRU(int capactity){
        this.capactity = capactity;
        map = new LinkedHashMap<Integer, Integer>();
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        //先删除旧的位置，再放入新的位置
        Integer value = map.remove(key);
        map.put(key,value);
        return value;
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        map.put(key,value);
        //超出capacity，删除最久没用的,利用迭代器，删除第一个
        if(map.size()>capactity){
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

    public static void main(String[] args) {
        LRU l = new LRU(5);
       // Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < 6; i++) {
            l.put(i,i+10);
        }
        System.out.println(l.map);
        l.get(2);//访问key，将key放在tail
        System.out.println(l.map);


    }

}

