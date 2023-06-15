import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class WildcardsMain {
    public static void main(String[] args) {
        // ? = wildcard


        List<Integer> listOfInts = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        listOfInts.add(10); // autoboxing

        List<Bit> listOfBits = new ArrayList<>();
        listOfBits.add(new Bit());

        List<Number> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(Integer.valueOf(1));

        Bit bit = new Bit();
        Integer integer = 5;
        Number number = integer;

        List<?> listOfNumberInheritants = listOfBits;


        // в нём лежит лист оф *какой-то класс-предок Integer*
        // из супера ничего нельзя извлекать, кроме Object
        // потому что это может быть list of Object
        List<? super Integer> listSuper = listOfInts;

        listSuper = new ArrayList<Object>();
        // для консьюмера важно, что мы можем туда положить Integer


        // в нём лежит лист оф *какой-то класс-потомок Number*
        // в extends ничего нельзя добавлять, кроме null
        // потому что единственное валидное значение для всех потомков это null
        List<? extends Number> listExtends = listOfInts;
        listExtends = listOfBits;

        listExtends.add(null);
        // для продьюсера важно, что мы можем оттуда извлечь валидный Number


        // PECS
        // producer extends, consumer super
        // если у нас есть коллекция-продьюсер, то она будет extends (producer = выдает значения)
        // если у нас есть коллекция-консьюмер, то она будет super   (consumer = потребляет значения)
        fillWithIntegers(listOfNumbers, 1, 10);
        fillWithIntegers(listOfInts, 1, 10);

        System.out.println(sumNumbers(listOfInts));

        func((x) -> System.out.println(x)); // consumer
        func(() -> Math.random()); // supplier


        // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
        Predicate<String> isEmpty = String::isEmpty; // принимает значение String, возвращает boolean
        Function<String, Integer> len = String::length; // принимает значение String, возвращает Integer
        Supplier<String> helloWorlder = () -> "Hello World!"; // ничего не принимает, возвращает String
        Consumer<String> printer = System.out::println;// принимает значение String, ничего не возвращает
        UnaryOperator<String> duplicateString = s -> s + s; // принимает значение String, возвращает значение String
        BinaryOperator<String> concatString = (s1, s2) -> s1 + s2; // принимает 2 значения String, возвращает значение String
        BiFunction<String, Integer, String> concatStringWithInteger = (s, i) -> s + i; // принимает String, Integer, возвращает String

    }

    public static void func(Supplier<? extends Number> numberSupply) {
        System.out.println(numberSupply.get());
    }

    public static void func(Consumer<? super Integer> integerConsumer) {
        integerConsumer.accept(10);
    }

    // даём коллекцию, даём числа 5 и 10, он добавляет туда 5, 6, 7, 8, 9
    // это CONSUMER. Мы хотим видеть коллекцию, способную ПРИНИМАТЬ Ingeger
    // любая коллекция предков Integer может принимать Integer
    // (потому что Integer можно привести к любому его предку)
    public static void fillWithIntegers(List<? super Integer> numbers, int start, int end) {
        for (int i = start; i < end; i++) {
            numbers.add(i); // автоупаковка в Integer, затем ВОЗМОЖНО приведение типа
        }
    }

    // мы можем принять коллекцию намберов
    // является """родительской коллекцией"""
    // можем """приводить""" коллекции of потомки
    //
    // это PRODUCER. Мы хотим видеть коллекцию, способную ВЫДАВАТЬ Number
    // любая коллекция потомков Number может выдать объект, который можно привести к Number
    // (к классу-предку)
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        // мы точно знаем, что содержимое numbers наследуется от Number
        // мы работает с листом List<Number>
        for (Number n: numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }




}
