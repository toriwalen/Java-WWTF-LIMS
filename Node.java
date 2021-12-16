
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
    
    /**
     * @param - none
     * @return - returns data object stored in node.
     */
    public Object getData(){
        return data;
    }
    
    /**
     * @param - none
     * @return - returns the next node.
     */
    public Node<T> getNextNode(){
        return next;
    }
    
    /**
     * @param - requires a node to be passed in.
     * @return - none
     */
    public void setNextNode(Node<T> next){
        this.next = next;
    }
    
    /**
     * Mutator method for the data variable.
     * 
     * @param - requires an object to be passed in
     * @return - none
     */
    public void setData(T data){
        this.data = data;
    }
    
    /**
     * If the next variable is null, this method returns false. If this node has a next variable assigned to another node
     * it returns true.
     * 
     * @param - none
     * @return - returns true if next is not null.
     */
    public boolean hasNext(){
        if(next == null){
            return false;
        }
        else{
            return true;
        }
    }
}
