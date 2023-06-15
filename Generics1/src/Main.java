import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<String> text = new ArrayList<>();

        Pair<Integer, String> pair = findMostFrequentWord(text);
        int count = pair.getE1();
        String word = pair.getE2();

        List<Visitor> visitors = new ArrayList<>();
        findMostFrequent(visitors);


    }

    public static Pair<Integer, ?> findMostFrequent(List<?> list) {
        int count = 10;
        return new Pair<>(count, list.get(0));
    }

    // метод принимает текст, нужно вернуть самое популярное слово И его количество в тексте
    public static Pair<Integer, String> findMostFrequentWord(List<String> text) {
        int count = 10;
        String mostFrequentWord = "the";
        return new Pair<>(count, mostFrequentWord);
    }

    // метод принимает список посетителей, нужно вернуть самого частого посетителя И его количество посещений
    public static Pair<Integer, Visitor> findMostFrequentVisitor(List<Visitor> visitors) {
        int count = 10;
        Visitor mostFrequentVisitor = new Visitor();
        return new Pair<>(count, mostFrequentVisitor);
    }


}