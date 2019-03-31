package clientapp;

import com.procourier.model.Order;
import http.GetOrderByIdClient;
import http.GetOrdersClient;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GetOrderByIdClient byIdClient = new GetOrderByIdClient();
        GetOrdersClient allClient = new GetOrdersClient();

        //Order order = byIdClient.getOrder(1L);
        //System.out.println(order);
        List<Order> orders = allClient.getOrders();
        System.out.println(orders);
    }
}

