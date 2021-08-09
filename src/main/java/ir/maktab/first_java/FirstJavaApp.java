package ir.maktab.first_java;

public class FirstJavaApp {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        System.out.println(numbers.isEmpty());
        numbers.add(1);
        System.out.println(numbers.isEmpty());
    }
}
