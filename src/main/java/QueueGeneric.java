import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueGeneric<T> implements IQueueGeneric<T> {

    private List<T> elements = new ArrayList<T>();
    private int maxSize = 5;

    public QueueGeneric(int maxSize) {
        this.maxSize = maxSize; 
    }

    @Override
    public boolean offer(T obj) {
        if (elements.size() < maxSize&& obj!=null) 
            elements.add(obj);
        else
            return false;

        return true;
    }

    @Override
    public T poll() {
        T element = peek();
        if (elements.size() > 0) { 
            elements.remove(0);
        }
        return element;
    }

    @Override
    public T remove() throws NoSuchElementException{ 
        T element = poll();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    @Override
    public T peek() {
        T element;
        if (elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }

    @Override
    public T element() {
        T element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

}
