package rzp.exceptions.queue;

public class queueExtraImpl extends queueimpl implements QueueExtra {
    @Override
    public void offer(int... items) throws QueueException, IllegalStateException {
        if (this.items == null ) {
            throw new IllegalStateException("Queue is not initialized");
        }
        if (items == null || items.length == 0) {
            throw new QueueException("no items to add");
        }
        if (count + items.length > maxSize) {
            throw new QueueException("not enough space");
        }
        for (int item : items) {
            if (isFull()){
                throw new QueueException("queue is full");
            }
            rear = (rear + 1) % maxSize;
            this.items[rear] = item;
            count++;
        }

    }
}
