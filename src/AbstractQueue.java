public abstract class AbstractQueue implements Queue {
    protected int size = 0;

    @Override
    public abstract void enqueue(Object object);

    @Override
    public abstract Object element();

    @Override
    public abstract Object dequeue();

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public abstract void clear();

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        for (int i = 0; i < size; i++) {
            array[i] = dequeue();
            enqueue(array[i]);
        }

        return array;
    }
}