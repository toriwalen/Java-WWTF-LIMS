import java.util.ArrayList;
/**
 * Batch provides a template for building other batch classes.
 *
 * @author Tori Walen
 * @version 20211209
 */
public interface Batch
{
    public ArrayList<Object> print();
    public void add(Object objectIn);
    public Object remove(Object objectIn);
}
