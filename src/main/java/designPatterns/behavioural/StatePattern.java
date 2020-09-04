package designPatterns.behavioural;

public class StatePattern {
}

class Order {
    private Status status;

    public Order() {
        this.status = new OrderCreated();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String receive() {
        return status.receiveOrder(this);
    }

    public String close() {
        return status.closeOrder(this);
    }

}

interface Status {
    String createOrder(Order order);

    String receiveOrder(Order order);

    String closeOrder(Order order);
}

class OrderCreated implements Status {

    @Override
    public String createOrder(Order order) {
        throw new RuntimeException("Order already created");
    }

    @Override
    public String receiveOrder(Order order) {
        order.setStatus(new OrderReceived());
        return "Order received";
    }

    @Override
    public String closeOrder(Order order) {
        throw new RuntimeException("Can not close this order");
    }
}

class OrderReceived implements Status {

    @Override
    public String createOrder(Order order) {
        throw new RuntimeException("Order already created");
    }

    @Override
    public String receiveOrder(Order order) {
        throw new RuntimeException("Order already created");
    }

    @Override
    public String closeOrder(Order order) {
        order.setStatus(new OrderClosed());
        return "Order closed";
    }
}

class OrderClosed implements Status {

    @Override
    public String createOrder(Order order) {
        throw new RuntimeException("Order already created");
    }

    @Override
    public String receiveOrder(Order order) {
        throw new RuntimeException("Order already created");
    }

    @Override
    public String closeOrder(Order order) {
        throw new RuntimeException("Order already closed");
    }
}
