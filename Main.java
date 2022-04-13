import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] word = scanner.nextLine().toCharArray();
        boolean status = true;
        int currentState = 1;
        boolean stopFlag = false;
        for (char symbol : word) {
            if (stopFlag)
                break;
            switch (currentState) {
                case 1 -> {
                    switch (symbol) {
                        case 'a' -> currentState = 2;
                        case 'b' -> {
                            currentState = 4;
                            status = false;
                        }
                        case 'c' -> currentState = 1;
                    }
                }
                case 2 -> {
                    switch (symbol) {
                        case 'a' -> currentState = 3;
                        case 'b' -> currentState = 1;
                        case 'c' -> {
                            status = false;
                            stopFlag = true;
                        }
                    }
                }
                case 3 -> {
                    switch (symbol) {
                        case 'a' -> currentState = 3;
                        case 'b' -> {
                            currentState = 4;
                            status = false;
                        }
                        case 'c' -> {
                            status = false;
                            stopFlag = true;
                        }
                    }
                }
                case 4 -> {
                    switch (symbol) {
                        case 'a', 'b' -> {
                            status = false;
                            stopFlag = true;
                        }
                        case 'c' -> {
                            currentState = 3;
                            status = true;
                        }
                    }
                }
            }
        }
        System.out.println(status);
    }
}



