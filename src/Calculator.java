import java.util.Scanner;

public class Calculator {
    private boolean stopCall = false;
    private boolean cancelCall = true;
    private final Scanner scanner = new Scanner(System.in);
    private final String operationsList = "+-*/";

    public void calculate() {
        stopCall = false;
        cancelCall = true;
        int operand1 = 0, operand2;
        char operation;
        while (true) {
            if (cancelCall) {
                System.out.println("Type in the first number:");
                cancelCall = false;
                operand1 = scanOperand();
                if (stopCall) {
                    break;
                }
                if (cancelCall) {
                    continue;
                }
            }

            
            System.out.println("Type in the operation:");
            operation = scanOperation();
            if (stopCall) {
                break;
            }
            if (cancelCall) {
                continue;
            }

            System.out.println("Type in the second number:");
            operand2 = scanOperand();
            if (stopCall) {
                break;
            }
            if (cancelCall) {
                continue;
            }

            switch (operation) {
                case '+':
                    operand1 += operand2;
                    break;
                case '-':
                    operand1 -= operand2;
                    break;
                case '*':
                    operand1 *= operand2;
                    break;
                case '/':
                    operand1 /= operand2;
            }
            System.out.println(operand1);
        }
    }

    private char scanOperation() {
        char operation;
        while (!isStop() && !isCancel()) {
            operation = scanner.next().charAt(0);
            if (operationsList.contains("" + operation)) {
                return operation;
            } else {
                System.out.println("Invalid operation! Use one of these: " + operationsList + "!");
            }
        }
        stopCall = isStop();
        cancelCall = isCancel();
        scanner.next();
        return 0;
    }

    private int scanOperand() {
        while (!isStop() && !isCancel()) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Not a number! Try again!");
            }
        }
        stopCall = isStop();
        cancelCall = isCancel();
        scanner.next();
        return 0;
    }

    private boolean isCancel() {
        return scanner.hasNext("c");
    }

    private boolean isStop() {
        return scanner.hasNext("s");
    }
}