import java.util.ArrayList;

public class Node<T> {
    private T data;
    private Node<T> parent;
    private ArrayList<Node<T>> children;

    public Node(T data){
        this.data = data;
        this.children = new ArrayList<>();
        this.parent = null;
    }

    public Node(T data, Node<T> parent){
        this.data = data;
        this.parent = parent;
        parent.addChild(this);
    }

    public void addChild(Node<T> child){
        children.add(child);
    }
}
