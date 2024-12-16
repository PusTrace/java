package rzp.generics.queue;

public class QueueGenericImpl<T> implements Queue<T> {
    protected T[] items;
    protected int maxSize;
    protected int front;
    protected int rear;
    protected int count;
    protected boolean initialized = false;

    @Override
    public void init(int maxSize) throws QueueException {
        if (initialized) {
            throw new QueueException("queue is already initialized");
        }
        this.maxSize = maxSize;
        this.items = (T[]) new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
        this.initialized = true;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == maxSize;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < count; i++) {
            int index = (front + i) % maxSize;
            if (items[index].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T peek() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("queue is empty");
        }
        return items[front];
    }

    @Override
    public T poll() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("queue is empty");
        }
        T item = items[front];
        items[front] = null;
        front = (front + 1) % maxSize;
        count--;
        return item;
    }

    @Override
    public void offer(T item) throws QueueException {
        if (isFull()) {
            throw new QueueException("queue is full");
        }
        rear = (rear + 1) % maxSize;
        items[rear] = item;
        count++;
    }
}
