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
            if (index == lastNode) throw new RuntimeException("This value doesnot exist in the the collections.");
            index = index.afterNode;
            counter++;
        }
        return counter;
    }


    public boolean contains(int value) {
        Node index = firstNode;
        while (index != null) {
            if (index.value == value) return true;
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
//this is little complicated in the general of the fortuante manner in the new letter genration of the bpost.hos.orchestration.Servic
//    public void reverse() {
//        Node index = firstNode;
//        Node afterindex=index.afterNode;
//        while (afterindex != lastNode) {
//            if (index != firstNode) {
//                afterindex.afterNode=index;
//            }
//            index=index.afterNode;
//            afterindex=index.afterNode;
//        }
//        //now swap the first and last Node
//        Node temp=firstNode;
//        firstNode=lastNode;
//        lastNode=temp;
//        lastNode.afterNode=null;
//    }


}
