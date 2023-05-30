import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        int value = map.get("Two");

        map.remove("Two");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }




        Pair pair = Solution.findMostFrequentWord(new String[]{"a", "b", "c", "b", "a", "b"});
        System.out.println(pair.word + "_" + pair.count);

    }
}