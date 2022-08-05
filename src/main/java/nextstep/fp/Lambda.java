package nextstep.fp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda implements Conditional{
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello from thread");
//            }
//        }).start();
        // 추상메서드(abstract method) 가 한개인 Runnable 인터페이스를 파라미터로 받아 생성하는 Thread를 람다식으로 변경
        new Thread(() -> System.out.println("Hello from thread"));
    }

    public static int sumAll(List<Integer> numbers,Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }

        return total;
    }

    public static int sumAllEven(List<Integer> numbers,Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAllOverThree(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            if (number > 3) {
                total += number;
            }
        }

        return total;
    }

    @Override
    public boolean test(Integer number) {
        return false;
    }
}
