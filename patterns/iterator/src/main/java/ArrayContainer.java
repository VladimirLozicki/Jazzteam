public class ArrayContainer implements Container {
    String[] array = {"0", "1", "2", "3", "4", "5"};

    public String[] getArray() {
        return array;
    }

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }
}
