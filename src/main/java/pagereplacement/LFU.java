package pagereplacement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
    LFU(Least Frequently Used)最不经常使用算法
    淘汰一定时期内被访问次数最少的元素。如果元素的一定时间内的访问次数相同时，
    则比较他们的最新一次的访问时间。
 */
public class LFU<k, v> {
    private final int capcity;

    private Map<k, v> cache = new HashMap<k, v>();

    private Map<k, HitRate> count = new HashMap<k, HitRate>();

    public LFU(int capcity) {
        this.capcity = capcity;
    }

    public void put(k key, v value) {
        v v = cache.get(key);
        if (v == null) {
            if (cache.size() == capcity) {
                removeElement();
            }
            count.put(key, new HitRate(key, 1, System.nanoTime()));
        } else {
            addHitCount(key);
        }
        cache.put(key, value);
    }

    public v get(k key) {
        v value = cache.get(key);
        if (value != null) {
            addHitCount(key);
            return value;
        }
        return null;
    }

    //移除元素
    private void removeElement() {
        HitRate hr = Collections.min(count.values());
        cache.remove(hr.key);
        count.remove(hr.key);
    }

    //更新访问元素状态
    private void addHitCount(k key) {
        HitRate hitRate = count.get(key);
        hitRate.hitCount = hitRate.hitCount + 1;
        hitRate.lastTime = System.nanoTime();
    }

    //内部类
    class HitRate implements Comparable<HitRate> {
        private k key;
        private int hitCount;
        private long lastTime;

        private HitRate(k key, int hitCount, long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }


        public int compareTo(HitRate o) {
            int compare = Integer.compare(this.hitCount, o.hitCount);
            return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
        }
    }


    public static void main(String[] args) {
        LFU<Integer, Integer> cache = new LFU<>(3);
        cache.put(2, 2);
        cache.put(1, 1);

        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        cache.put(3, 3);
        cache.put(4, 4);

        //1、2元素都有访问次数，放入3后缓存满，加入4时淘汰3
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        //System.out.println(cache.get(1));
        System.out.println(cache.get(4));

        cache.put(5, 5);
        //目前2访问2次，1访问一次，4访问一次，由于4的时间比较新，放入5的时候移除1元素。
        System.out.println("-=-=-=-");
        cache.cache.entrySet().forEach(entry -> {
            System.out.println(entry.getValue());
        });

    }
}