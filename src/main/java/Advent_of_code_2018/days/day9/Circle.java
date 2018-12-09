package Advent_of_code_2018.days.day9;

public class Circle<T> {
    Node<T> root;
    Node<T> current;

    public Circle(T i) {
        root = new Node<>(i);
        root.next = root;
        root.prev = root;

        current = root;
    }

    public void add(T v) {
        var node = new Node(v);
        node.next = current.next;
        node.prev = current;
        current.next.prev = node;
        current.next = node;
        current = node;

    }

    public void next() {
        current = current.next;
    }

    public void back(int nSteps) {
        for (int i = 0; i < nSteps; i++) {
            current = current.prev;
        }
    }

    public T remove() {
        var val = current.value;
        current.next.prev = current.prev;
        current.prev.next = current.next;
        current = current.next;
        return val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmp = root;
        do {
            if (tmp.equals(current)) sb.append("(");
            sb.append(tmp.value);
            if (tmp.equals(current)) sb.append(")");
            sb.append(", ");
            tmp = tmp.next;
        } while (!tmp.equals(root));
        return sb.toString();
    }

    class Node<T> {

        private T value;
        private Node<T> prev;
        private Node<T> next;

        public Node(T i) {
            this.value = i;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
