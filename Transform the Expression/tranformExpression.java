import java.util.*;

class tranformExpression
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String expression = scanner.nextLine();
            String rpn = toRPN(expression);
            System.out.println(rpn);
        }

        scanner.close();
    }

    public static String toRPN(String expression) {
        StringBuilder rpn = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetter(ch)) {
                rpn.append(ch);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    rpn.append(operators.pop());
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    rpn.append(operators.pop());
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            rpn.append(operators.pop());
        }

        return rpn.toString();
    }

    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
