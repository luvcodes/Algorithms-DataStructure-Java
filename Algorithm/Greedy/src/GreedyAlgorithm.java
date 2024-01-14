
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ryanw
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建广播电台
        HashMap<String,HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();

        // 将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map中，5个电台，对应5个hashset
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        // 用于存储最终选择的电台集合
        ArrayList<String> selects = new ArrayList<String>();

        // 在遍历的过程中，存放遍历过程中的电台覆盖的地区和allAreas的交集
        HashSet<String> tempSet = new HashSet<String>();

        // 定义maxKey，保存在一次遍历过程中，能够覆盖最多城市的对应的电台key
        String maxKey = null;

        // 如果allAreas 不为0, 则表示还没有覆盖到所有的地区
        while(allAreas.size() != 0) {
            // 每进行一次while, 需要置空maxKey
            // 因为每次都要选择一次maxKey
            maxKey = null;

            // 遍历 broadcasts, 取出对应key (就是电台编号)
            for(String key : broadcasts.keySet()) {
                //每进行一次for, 都清空一次tempSet
                tempSet.clear();

                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);

                //求出tempSet和allAreas集合的交集, 交集会赋给tempSet
                tempSet.retainAll(allAreas);

                // tempSet 为空的情况发生在当前电台覆盖的区域都已经被之前选中的电台覆盖了。
                // 这就是为什么需要检查 tempSet.size() > 0，以确保当前电台能至少覆盖一个新的区域。
                if(tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }

            // 如果maxKey != null, 就应该将maxKey加入selects
            if(maxKey != null) {
                selects.add(maxKey);
                // 将maxKey指向的广播电台所覆盖的地区，从allAreas中去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }




        // [K1,K2,K3,K5]
        System.out.println("得到的选择结果是" + selects);
    }
}
