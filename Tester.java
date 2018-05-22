public class Tester {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> deq = new StudentArrayDeque<>();
        deq.addFirst(18);
        deq.addFirst(11);
        deq.addFirst(18);
        deq.addFirst(17);
        deq.addLast(43);
        deq.addFirst(15);
        deq.addLast(28);
        System.out.println(deq.removeFirst());
        System.out.println(deq.removeLast());
    }
}
