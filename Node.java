
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node<T>
{
    private T data;
    private Node<T> next;

    /**
     * Constructor for objects of class Node
     */
    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public Object getData(){
        return data;
    }
    public Node<T> getNextNode(){
        return next;
    }
    public void setNextNode(Node<T> next){
        this.next = next;
    }
    public void setData(T data){
        this.data = data;
    }
    public boolean hasNext(){
        if(next == null){
            return false;
        }
        else{
            return true;
        }
    }
}
