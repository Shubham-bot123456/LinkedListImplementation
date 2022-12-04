import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addFirst(6);
        /*
        10<-20<-30
         */
        linkedList.reverse();
        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}