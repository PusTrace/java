package rzp.exceptions.queue;

public class queueimpl implements Queue {
    public int[] items; // массив для хранения элементов
    public int maxSize; // максимальный размер очереди
    private int front;   // указатель на начало очереди
    public int rear;    // указатель на конец очереди
    public int count;   // количество элементов в очереди

    // Реализация методов будет здесь

    @Override
    public void init(int maxSize) throws QueueException {
        if (items != null) {
            throw new QueueException("queue is already initialized");
        }
        this.maxSize = maxSize;
        this.items = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
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
    public boolean contains(int item){
        if (isEmpty()) {
            return false;
        }
        for (int i = 0 ; i < count ; i++ ) {
            if (items[(front + i) % maxSize] == item) {
            return true;
            }
        }
        return false;

    }
    // with exceptions
    @Override
    public int peek() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("queue is empty");
        }
        return items[front];
    }

    @Override
    public int poll() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("queue is empty");
        }
        int item = items[front];
        front = (front + 1) % maxSize;
        count--;
        return item;
    }

    @Override
    public void offer(int item) throws QueueException {
        if (isFull()) {
            throw new QueueException("queue is full");
        }
        rear = (rear + 1) % maxSize;
        items[rear] = item;
        count++;
    }
}
