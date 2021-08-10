package ir.maktab.first_java;

public class FirstJavaApp {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);

        numbers.set(5, 15);
        numbers.set(0, 9);

        System.out.println(numbers.indexOf(9));
        System.out.println(numbers.indexOf(10));
        System.out.println(numbers.indexOf(11));
        System.out.println(numbers.indexOf(12));
        System.out.println(numbers.indexOf(13));
        System.out.println(numbers.indexOf(14));
        System.out.println(numbers.indexOf(15));

        System.out.println(numbers.get(0));
        System.out.println(numbers.get(1));
        System.out.println(numbers.get(2));
        System.out.println(numbers.get(3));
        System.out.println(numbers.get(4));
        System.out.println(numbers.get(5));
        System.out.println(numbers.get(6));


    }
}
