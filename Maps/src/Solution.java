import java.util.HashMap;
import java.util.Map;

public class Solution {
    // дан массив слов, нужно вернуть самое часто встречающееся слово. Если массив пустой, вернуть пустую строку.
    // (версия с возвратом пары)
    public static Pair findMostFrequentWord(String[] text) {
        int max = 0;
        String maxWord = "";
        Map<String, Integer> words = new HashMap<>();
        for (String word: text) {
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
            if (words.get(word) > max) {
                max = words.get(word);
                maxWord = word;
            }
        }

//        int max = 0;
//        String maxWord = "";
//        for (Map.Entry<String, Integer> wordCount: words.entrySet()) {
//            if (wordCount.getValue() > max) {
//                max = wordCount.getValue();
//                maxWord = wordCount.getKey();
//            }
//        }

        return new Pair(maxWord, max);
    }
}
