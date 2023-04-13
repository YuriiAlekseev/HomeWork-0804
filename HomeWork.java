import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class HomeWork 
    public static void main(String[] args) {
        System.out.println(isCorrectParentheses("()")); // true
        System.out.println(isCorrectParentheses("(")); // false
        System.out.println(isCorrectParentheses("())")); // false
        System.out.println(isCorrectParentheses("((()))")); // true
        System.out.println(isCorrectParentheses("()[]{}<>")); // true
        System.out.println(isCorrectParentheses("([)]")); // false
        System.out.println(isCorrectParentheses("][]")); // false
        System.out.println("[]{<()[]<>>}"); // true
    }
/**
 * Дана последовательность скобочек. Проверить, что она является корректной.
 */
static boolean isCorrectParentheses(String parentheses) {
    // TODO: 07.04.2023 Вписать решение!
    // Нужно завести маппинг скобочек либо ( -> ), либо ) -> ( и так для каждой пары
    // Нужно использовать Deque.
    // Открывающуюся скобку вносим в Deque (insertFirst)
    // Если встретилась закрывающаяся скобка, то (Deque#pollFirst) и сравниваем ее с
    // встретившейся
    
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put('>', '<');
        brackets.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (char c : parentheses.toCharArray()) {
            if (brackets.containsValue(c)) {

                stack.push(c);
            } else if (brackets.containsKey(c)) {

                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    
}
