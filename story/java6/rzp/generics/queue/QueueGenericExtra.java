package rzp.generics.queue;

public class QueueGenericExtra<T> extends QueueGenericImpl<T> implements QueueExtra<T> {

    @Override
    public void offer(T[] items) throws QueueException, IllegalStateException {
        if (!initialized) {
            throw new IllegalStateException("Queue is not initialized");
        }
        if (items == null) {
            throw new QueueException("no items to add");
        }
        if (count + items.length > maxSize) {
            throw new QueueException("not enough space");
        }
        for (T item : items) {
            rear = (rear + 1) % maxSize;
            this.items[rear] = item;
            count++;
        }

    }
}
