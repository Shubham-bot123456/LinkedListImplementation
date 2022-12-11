import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(100);
        linkedList.addLast(6);
        System.out.println(linkedList.size());
        /*
        10<-20<-30
         */
//        linkedList.reverse();
        System.out.println(linkedList.kthNodeFromLast(2));
        System.out.println(linkedList.kthNodeinOneGo(2));
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println(balancedorNot("((1+2)(1+3))"));


    }


    public static boolean balancedorNot(String string) {
        String[] stringarray = string.split("");
        Stack<String> stack = new Stack<>();
        for (String i : stringarray) {
            if (i.equals("(")) stack.push(i);
            if (i.equals(")")) {
                try {
                    stack.pop();
                }catch(Exception e){
                    return false;
                }

            }

        }
        return !(stack.size() > 0);

    }


}