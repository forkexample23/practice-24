import java.util.*;

public class Solutions {
    public static void main(String[] args) {

        List<Integer> listWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 5, 6);



        List<String> names = new ArrayList<>();

        System.out.println(listWithDuplicates);
        System.out.println(removeDuplicates(listWithDuplicates));

        System.out.println();

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        System.out.println(intersection(set1, set2));

        String[] stringArray = {"a", "b", "c", "c"};
        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(removeDuplicatesFromArray(stringArray)));


        System.out.println();


        int[] intArray = {1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(removeDuplicatesFromArrayOfPrimitives(intArray)));

    }


    // дан список уникальных строк, нужно вернуть отсортированный список этих строк
    public static List<String> sort(List<String> strings) {
        Set<String> sorted = new TreeSet<>(strings);
        return new ArrayList<>(sorted);
    }



    // даны два множества. Нужно вернуть множество, содержащее элементы, которые есть в обоих множествах. (пересечение)
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {


        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2); // оставляет элементы, содержащиеся в set2

//        result.removeAll(set2); // удаляет элементы, содержащиеся в set2


//        Set<Integer> result = new HashSet<>();
//
//        for (Integer number: set1) {
//            if (set2.contains(number)) {
//                result.add(number);
//            }
//        }


        return result;
    }

    // дан лист с дубликатами. Нужно вернуть лист без дубликатов.
    public static List<Integer> removeDuplicates(List<Integer> listWithDuplicates) {
        Set<Integer> noDuplicates = new HashSet<>(listWithDuplicates);
        return new ArrayList<>(noDuplicates);
    }

    // дан массив с дубликатами. Нужно вернуть массив без дубликатов.
    public static String[] removeDuplicatesFromArray(String[] arrayWithDuplicates) {
        Set<String> noDuplicates = new HashSet<>(List.of(arrayWithDuplicates));
        List<String> noDuplicatesList = new ArrayList<>(noDuplicates);
        String[] result = noDuplicatesList.toArray(new String[]{});
        return result;
    }

    // дан массив с дубликатами. Нужно вернуть массив без дубликатов.
    public static int[] removeDuplicatesFromArrayOfPrimitives(int[] arrayWithDuplicates) {
        Set<Integer> noDuplicates = new HashSet<>();

        for (int i = 0; i < arrayWithDuplicates.length; i++) {
            noDuplicates.add(arrayWithDuplicates[i]);
        }


        List<Integer> noDuplicatesList = new ArrayList<>(noDuplicates);
        Integer[] result = noDuplicatesList.toArray(new Integer[]{});

        int[] resultPrimitive = new int[result.length];

        for (int i = 0; i < result.length; i++) {
            resultPrimitive[i] = result[i];
        }

        return resultPrimitive;
    }

}
