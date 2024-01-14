import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

/**
 * @author ryanw
 */
public class GreedyAlgorithm2 {

    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        // 初始化广播电台及其覆盖区域
        broadcasts.put("K1", new HashSet<>(Arrays.asList("北京", "上海", "天津")));
        broadcasts.put("K2", new HashSet<>(Arrays.asList("广州", "北京", "深圳")));
        broadcasts.put("K3", new HashSet<>(Arrays.asList("成都", "上海", "杭州")));
        broadcasts.put("K4", new HashSet<>(Arrays.asList("上海", "天津")));
        broadcasts.put("K5", new HashSet<>(Arrays.asList("杭州", "大连")));

        // 所有需要覆盖的区域
        HashSet<String> allAreas = new HashSet<>(Arrays.asList("北京", "上海", "天津", "广州", "深圳", "成都", "杭州", "大连"));

        ArrayList<String> selects = selectStations(broadcasts, allAreas);
        System.out.println("选择的电台：" + selects);
    }

    public static ArrayList<String> selectStations(HashMap<String, HashSet<String>> broadcasts, HashSet<String> allAreas) {
        ArrayList<String> selects = new ArrayList<>();

        while (!allAreas.isEmpty()) {
            String bestStation = null;
            HashSet<String> areasCovered = new HashSet<>();

            for (String station : broadcasts.keySet()) {
                HashSet<String> areas = new HashSet<>(broadcasts.get(station));
                areas.retainAll(allAreas);

                if (areas.size() > areasCovered.size()) {
                    bestStation = station;
                    areasCovered = areas;
                }
            }

            if (bestStation != null) {
                selects.add(bestStation);
                allAreas.removeAll(areasCovered);
            }
        }

        // 最终想要的是station的名字，就是一堆key
        return selects;
    }
}
