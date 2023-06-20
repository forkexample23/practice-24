import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream.iterate(0, n -> n + 1).limit(3).forEach(System.out::println);
        Stream.generate(Math::random).limit(3).forEach(System.out::println);

        new Random().ints().limit(3).forEach(System.out::println);
        new Random().ints(10, 100).limit(3).forEach(System.out::println);



        List<User> users = new ArrayList<>();


        users.add(new User("ivan0"));
        users.add(new User("ivan1"));
        users.add(new User("ivan2"));

        // users = new ArrayList<>();

        User user = users.get(1);
        user.name = "Alex";

        users.forEach(u -> System.out.println(u.name));


        users.stream()
                .limit(2)
                .peek(u -> u.name = u.name + "!") // здесь берутся ИЗНАЧАЛЬНЫЕ юзеры
                .map(u -> new User(u.name))
                .peek(u -> u.name = u.name + "?")
                .forEach(u -> System.out.println(u.name));

        users.forEach(u -> System.out.println(u.name));

        users.get(2).name = "100";

        users.forEach(u -> System.out.println(u.name));


        System.out.println(
        new Random().ints(1, 100)
                .filter(n -> n > 0 && n % 2 == 0)
                .limit(10)
                .peek(System.out::println)
                .sorted()
                .distinct()
                .skip(2)
                .mapToObj(x -> "" + x + x)
                .peek(System.out::println)
                .reduce("start:", (x, y) -> x + " " + y));

        new Random().ints(1, 100)
                .filter(n -> n > 0 && n % 2 == 0)
                .limit(10)
                .sorted()
                .distinct()
                .skip(2)
                .anyMatch(x -> x > 5000);

        Stream<Integer> ints = new Random().ints().boxed().limit(10);

        Stream<Integer> ints8 = ints.skip(2);


        System.out.println(get5Random(users));

    }

    public static void rename(User user) {
        user.name = "renamed_" + user.name;
    }

    // дан список User, нужно вернуть 5 случайных, если их меньше, то вернуть всех
    public static List<User> get5Random(List<User> users) {
        return new Random().ints(0, users.size())
                .distinct()
                .limit(users.size() > 5 ? 5 : users.size())
                .mapToObj(i -> users.get(i))
                .collect(Collectors.toList());
    }



}