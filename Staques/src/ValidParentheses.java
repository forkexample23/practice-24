import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("((())())))"));
        System.out.println(isValid("))))"));
        System.out.println(isValid("(((((((((("));
        System.out.println(isValid("((()))"));
        System.out.println(isValid("())(()"));
    }



    //      ((())())))
    // проверить что данная скобочная последовательность является правильной
    public static boolean isValid(String sequence) {
        // ((())())))
        // будем добавлять открывающие скобки в стек
        // если видим закрывающую (и стек не пустой) то закрываем скобку и удаляем открывающую со стека
        // ))))
        // ((((((((((
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(') {
                stack.push(sequence.charAt(i));
            } else if (sequence.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    // та же задача, но у нас может быть 3 типа скобок: {}, [], ()
    public static boolean isValidThree(String sequence) {
        return false;
    }

    // обратная польская нотация
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/
    public static int evalRPN(String[] tokens) {
        return 0;
    }

}