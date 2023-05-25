import java.util.LinkedList;
import java.util.Queue;

public class CustomersMain {
    public static void main(String[] args) {
        LinkedList<Customer> customers = new LinkedList<>();
        customers.add(new Customer());
        customers.add(new Customer());
        customers.add(new Customer());
        customers.get(1).setState(Customer.State.LEFT);

        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getState());
        }

        Queue<Customer> toBeServed = new LinkedList<>(customers);

        serve(toBeServed);

        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getState());
        }
    }

    public static void serve(Queue<Customer> toBeServed) {
        while (!toBeServed.isEmpty()) {
            Customer customer = toBeServed.remove();
            if (customer.getState() == Customer.State.WAITING) {
                customer.setState(Customer.State.SERVED);
            }
        }
    }
}
