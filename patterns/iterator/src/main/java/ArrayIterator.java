import java.util.ArrayList;

public class ArrayIterator implements Iterator {
    int index;
    ArrayContainer arrayContainer = new ArrayContainer();

    @Override
    public boolean hasNext() {
        return (index < arrayContainer.array.length) ? true : false;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return arrayContainer.array[index++];
        }
        return null;
    }
}

