import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.*;


public class Main {
    public static void main(String[] args) {
        Consumer<String> consumer = (x) -> {
            System.out.println("consumer " + x);
        };
        BiConsumer<String, String> biConsumer = (x, y) -> {
            System.out.println("biconsumer " + x + " " + y);
        };

        consumer.accept("string");
        biConsumer.accept("s1", "s2");

        IntConsumer intConsumer = (i) -> System.out.println("int " + i);

        List<String> list = List.of("s1", "s2", "s3", "s4");
        Consumer<Object> objectConsumer = (obj) -> System.out.println("Object consumer " + obj);
        list.forEach(objectConsumer); // лист параметризован String, консьюмер может быть консьюмером его или суперкласса
        // консьюмер стрингов, консьюмер обжектов, коньюмер CharSequence

        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(-10,
                                null,
                                new TreeNode(2, null, null)),
                        null),
                new TreeNode(10,
                        new TreeNode(6, null, null),
                        new TreeNode(15, null, null)));

        TreeNodeConsumer classConsumer = new TreeNodeConsumer();
        Consumer<TreeNode> lambdaConsumer = treeNode -> {
            if (treeNode == null) {
                System.out.println("Node is null");
                return;
            }
            System.out.println("Node has value " + treeNode.value);
            System.out.println("Left child is " + (treeNode.left != null ? treeNode.left.value : "null"));
            System.out.println("Right child is " + (treeNode.right != null ? treeNode.right.value : "null"));
        };

        classConsumer.accept(root);
        lambdaConsumer.accept(root.left);

        System.out.println();
        System.out.println("Predicate:");
        System.out.println();

        Predicate<TreeNode> treeNodeIsNotNull = treeNode -> treeNode != null;
        Predicate<TreeNode> treeNodePositiveValue = treeNode -> treeNode.value > 0;
        System.out.println(treeNodeIsNotNull.test(root));

        printConditional(inOrder(root), x -> x != null);
        System.out.println();
        printConditional(inOrder(root), treeNodeIsNotNull.and(treeNodePositiveValue));
        System.out.println();
        // printConditional(inOrder(root), treeNode -> treeNodeIsNotNull.test(treeNode) && treeNodePositiveValue.test(treeNode));
        int sumOfTree = inOrder(root).stream()
                .filter(treeNodeIsNotNull) // предикат
//                .filter(treeNodePositiveValue) // предикат
                .mapToInt(treeNode -> treeNode.value * 2) // функция
                .reduce(0, (sum, value) -> sum + value); // оператор
        System.out.println(sumOfTree);

        Function<TreeNode, Integer> treeNodeIntegerValueExtractor = treeNode -> treeNode.value;
        treeNodeIntegerValueExtractor.apply(root);

        ToIntFunction<TreeNode> treeNodeIntValueExtractor = treeNode -> treeNode.value;
        treeNodeIntValueExtractor.applyAsInt(root);

        // взять лист, отфильтровать его от null значений, отфильтровать от отрицательных значений
        // заменить все значения на умноженные на 2
        // просуммировать все значения

        System.out.println();
        System.out.println("Method reference: ");
        System.out.println();

        // System.out::println
        // x -> System.out.println(x)

        // System.out::println
        // accept "заменяется" на println

        printConditional(inOrder(root), Objects::nonNull); // x -> Objects.nonNull(x)



        int sumOfTree2 = inOrder(root).stream()
                .filter(Objects::nonNull) // предикат
                .mapToInt(treeNode -> treeNode.value * 2) // функция
                .peek(System.out::println)
                .peek(Main::print)
//                .peek(treeNodeValue -> System.out.println(treeNodeValue))
//                .reduce(0, (a, b) -> a + b); // оператор
//                .reduce(0, Integer::sum); // оператор
//              .reduce(0, (a, b) -> Integer.sum(a, b));
                .reduce(0, new IntBinaryOperator() {
                    @Override
                    public int applyAsInt(int a, int b) {
                        return Integer.sum(a, b);
                    }
                });

    }

    public static <T> void print(T t) {
        System.out.println(t);
    }

    // принимает лист объектов и условие. Делает с объектами что-то, если условие правда.
    public static void printConditional(List<TreeNode> treeNodes, Predicate<TreeNode> condition) {
        for (TreeNode treeNode: treeNodes) {
            if (condition.test(treeNode)) {
                System.out.println(treeNode.value);
            }
        }
    }

    public static List<TreeNode> inOrder(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();

        if (root == null) {
            result.add(null);
            return result;
        }
        result.addAll(inOrder(root.left));
        result.add(root);
        result.addAll(inOrder(root.right));

        return result;
    }

}