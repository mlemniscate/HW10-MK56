package ir.maktab.first_java;

public class FirstJavaApp {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);
        System.out.println(numbers.indexOf(12));
        System.out.println(numbers.indexOf(15));
        System.out.println(numbers.indexOf(18));
    }
}
