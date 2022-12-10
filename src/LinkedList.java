import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkedList {
    Node firstNode;
    Node lastNode;

    public class Node {
        int value;
        Node afterNode;
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (firstNode == null) {
            firstNode = lastNode = node;
        } else {
            node.afterNode = firstNode;
            firstNode = node;
        }
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (firstNode == null)
            firstNode = lastNode = node;
        else {
            lastNode.afterNode = node;
            lastNode = node;
        }
    }

    public int indexof(int value) {
        int counter = 0;
        Node index = firstNode;
        while (index.value != value) {
            if (index == lastNode)
                throw new RuntimeException("This value doesnot exist in the the collections.");
            index = index.afterNode;
            counter++;
        }
        return counter;
    }

    public boolean contains(int value) {
        Node index = firstNode;
        while (index != null) {
            if (index.value == value)
                return true;
            index = index.afterNode;
        }
        return false;
    }

    public void removeFirst() {
        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.afterNode;
        }
    }

    public void removeLast() {
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            Node index = firstNode;
            while (index != lastNode) {
                if (index.afterNode == lastNode)
                    break;
                else
                    index = index.afterNode;
            }
            index.afterNode = null;
            lastNode = index;
        }
    }

    public int size() {
        int counter = 1;
        Node index = firstNode;
        while (index != lastNode) {
            index = index.afterNode;
            counter++;
        }
        return counter;

    }

    public int[] toArray() {
        int[] array = new int[size()];
        if (firstNode == lastNode) {
            array[0] = firstNode.value;
        } else {
            Node index = firstNode;
            int counter = 0;
            while (index != lastNode) {
                array[counter] = index.value;
                index = index.afterNode;
                counter++;
            }
            array[counter] = lastNode.value;
        }
        return array;
    }

    /*
    how to reverse  a linked list
    three things to keep in  mind 1. previous , 2. current , 3. nextNode.
     */
    public void reverse() {
        if (firstNode.afterNode == null) return;
        if (firstNode == null) return;
        Node previous = firstNode;
        Node current = firstNode.afterNode;
        Node nextNode = current.afterNode;
        while (current != null) {
            current.afterNode = previous;
            if (current == lastNode) {
                break;
            }
            previous = current;
            current = nextNode;
            nextNode = current.afterNode;
        }
        lastNode = firstNode;
        firstNode = current;
        lastNode.afterNode = null;
    }


    /*
    find the k th  node from last.
     */

    public int kthNodeFromLast(int index) {
        int kthNodefromFirst = this.size() - 1 - index;
        Node indexNode = firstNode;
        int counter = 0;
        while (counter != kthNodefromFirst) {
            indexNode = indexNode.afterNode;
            counter++;
        }
        return indexNode.value;
    }


    public int kthNodeinOneGo(int index) {
        Node previousNode = firstNode;
        Node indexNode = firstNode;
        for (int i = 0; i < index; i++) {
            indexNode = indexNode.afterNode;
        }
        while (indexNode != lastNode) {
            indexNode = indexNode.afterNode;
            previousNode = previousNode.afterNode;
        }
        return previousNode.value;

    }

}
