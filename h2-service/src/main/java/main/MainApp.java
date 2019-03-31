package main;

import com.procourier.model.*;
import service.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Server.createWebServer("-webPort", "10500").start();
        OrderService orderService = OrderService.getInstance();

        //region Construct Order #1
        Product phone = new Product(1000L, "Huawei P30",
                "New Phone", 270L);
        Product laptop = new Product(1500L, "Sony Vayo",
                "Old laptop", 1200L);
        Address emagAddress = new Address("Bucuresti", "Bucuresti",
                "Soseaua Virtutii", "28");
        Address johnAddress = new Address("Dolj", "Craiova",
                "Ecaterina Teodoriu", "14");
        Address proCourier = new Address("Timis", "Timisoara",
                "Ecaterina Teodoriu", "14");
        Courier courier_1 = new Courier("ProCourier", proCourier,
                12L, 13L);
        Buyer john = new Buyer("John", johnAddress);

        Seller emag = new Seller("Emag", emagAddress);

        OrderLine olPhone = new OrderLine(phone, 10L);
        OrderLine olLaptop = new OrderLine(laptop, 7L);

        List<OrderLine> orderLines_1 = new ArrayList<>();
        orderLines_1.add(olPhone);
        orderLines_1.add(olLaptop);
        Order order_1 = new Order(emag, john, courier_1, orderLines_1);
        //endregion

        //region Construct Order #2
        Product tv = new Product(800L, "Samsung 40NU7122",
                "4K Ultra HD LED TV", 12600L);
        Product toothbrush = new Product(20L, "Oral-B Vitality",
                "Electric toothbrush", 180L);
        Product airPods = new Product(250L, "Apple AirPods",
                "Wireless earpods", 65L);
        Address amazonAddress = new Address("Bavaria", "Munchen",
                "Aubinger Str.", "34");
        Address chrisAddress = new Address("Arges", "Pitesti",
                "Victor Babes", "5");
        Address ups = new Address("Viena", "Viena",
                "Hetzendorfer Str.", "27");
        Courier courier_2 = new Courier("UPS", ups,
                15L, 18L);
        Buyer chris = new Buyer("Chris", chrisAddress);

        Seller amazon = new Seller("Amazon", amazonAddress);

        OrderLine olTv = new OrderLine(tv, 1L);
        OrderLine olToothbrush = new OrderLine(toothbrush, 3L);
        OrderLine olAirPods = new OrderLine(airPods, 2L);

        List<OrderLine> orderLines_2 = new ArrayList<>();
        orderLines_2.add(olTv);
        orderLines_2.add(olToothbrush);
        orderLines_2.add(olAirPods);
        Order order_2 = new Order(amazon, chris, courier_2, orderLines_2);
        //endregion

        orderService.addOrder(order_1);
        orderService.addOrder(order_2);

        System.out.println("Succes!");
    }
}

