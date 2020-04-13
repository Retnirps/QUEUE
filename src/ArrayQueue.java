public class ArrayQueue extends AbstractQueue {
    private Object[] elements = new Object[0];
    private int head = 0;
    private int tail = 0;

    /*public static void main(String[] args) {
        ArrayQueue s = new ArrayQueue();
        s.enqueue(5);
        s.enqueue(10);
        s.enqueue(15);
        Object[] a = s.toArray();
    }*/

    private void smartArray(char ch) {
        if (ch == '+') {
            if (tail == elements.length) {
                Object[] temp = new Object[elements.length + 1];
                System.arraycopy(elements, 0, temp, 0, elements.length);
                elements = temp;
            }
        }
        if (ch == '-') {
            Object[] temp = new Object[elements.length - 1];
            System.arraycopy(elements, 1, temp, 0, elements.length - 1);
            elements = temp;
            //head = 0;
            tail--;
        }
    }

    @Override
    public void enqueue(Object object) {
        smartArray('+');

        if (tail != elements.length) {
            elements[tail] = object;
            tail = (tail + 1); //% elements.length;
        }

        size++;
    }

    @Override
    public Object element() {
        return elements[head];
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object obj = elements[head];
        elements[head] = null;
        //head = (head + 1);
        smartArray('-');
        size--;
        return obj;
    }

    @Override
    public void clear() {
        //head = 0;
        elements = new Object[0];
        tail = 0;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        return elements;
    }
}