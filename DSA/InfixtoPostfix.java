import java.lang.*;
import java.util.*;
import java.util.Stack;

class InfixtoPostfix {
    public static int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static String InfixtoPostfix(String exp) {
        Stack<Character> s = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } 
            else if (ch == '(') {
                s.push(ch);
            } 
            else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    result.append(s.pop());
                }
                if (!s.isEmpty() && s.peek() == '(') {
                    s.pop();
                } 
                else {
                    return "Invalid Expression"; // invalid expression
                }
            } 
            else {
                while (!s.isEmpty() && prec(ch) <= prec(s.peek())) {
                    result.append(s.pop());
                }
                s.push(ch);
            }
        }

        // Pop all the operators from the stack
        while (!s.isEmpty()) {
            if (s.peek() == '(') {
                return "Invalid Expression"; // invalid expression
            }
            result.append(s.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Postfix expression: " + InfixtoPostfix(exp));
    }
}
