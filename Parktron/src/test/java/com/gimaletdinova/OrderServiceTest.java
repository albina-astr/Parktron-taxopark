package com.gimaletdinova;

import com.gimaletdinova.db.TestDataBaseConfig;
import com.gimaletdinova.entity.*;
import com.gimaletdinova.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.gimaletdinova.RunApplication.getDBConnection;
import static org.junit.Assert.assertEquals;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class OrderServiceTest {
    @Autowired
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Autowired
    private OrderService orderService;
    @Autowired
    private CarService carService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private DispatcherService dispatcherService;
    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {

        em = emf.createEntityManager();
    }

    @Test
    public void testOrderFunctions() throws Exception {

        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE CARS (stateNumber VARCHAR(50) PRIMARY KEY, isOwn INT, make  VARCHAR(50), color VARCHAR(30), comfortLevel INTEGER)");
            stmt.execute("CREATE TABLE CLIENTS (id INTEGER PRIMARY KEY )");
            stmt.execute("CREATE TABLE DISPATCHERS (id INTEGER PRIMARY KEY, fio VARCHAR(50))");
            stmt.execute("CREATE TABLE DRIVERS (id INTEGER PRIMARY KEY, fio VARCHAR(50))");
            stmt.execute("CREATE TABLE ORDERS (id INTEGER PRIMARY KEY , dispatcher VARCHAR, client VARCHAR, arrivalPoint VARCHAR )");

            Car car1 = new Car("м123ееRUS", 0, "Ferrari", "red", 1);
            Car car2 = new Car("ф456уаRUS", 0, "Ferrari", "red", 5);
            Car car3 = new Car("п612егRUS", 1, "Porsche", "blue", 1);
            Car car4 = new Car("ч423уьRUS", 1, "Ford", "silver", 1);
            Car car5 = new Car("ц652зхRUS", 1, "Ford", "orange", 2);

            Client client1 = new Client();
            Client client2 = new Client();
            Client client3 = new Client();

            Dispatcher dispatcher1 = new Dispatcher("Ivanov Ivan Ivanovich");
            Dispatcher dispatcher2 = new Dispatcher("Tom Bush");
            Dispatcher dispatcher3 = new Dispatcher("Barak Obama");

            Driver driver1 = new Driver("Tommy Alex Layer");
            Driver driver2 = new Driver("Zhukov Semen Vladislavovich");
            Driver driver3 = new Driver("Krykov Slava Andreevich");

            carService.addCar(car1);
            carService.addCar(car2);
            carService.addCar(car3);
            carService.addCar(car4);
            carService.addCar(car5);

            clientService.addClient(client1);
            clientService.addClient(client2);
            clientService.addClient(client3);

            dispatcherService.addDispatcher(dispatcher1);
            dispatcherService.addDispatcher(dispatcher2);
            dispatcherService.addDispatcher(dispatcher3);

            driverService.addDriver(driver1);
            driverService.addDriver(driver2);
            driverService.addDriver(driver3);

            Order order1 = new Order(dispatcher1, client1, "Moscow");
            Order order2 = new Order(dispatcher2, client2, "Kazan");
            Order order3 = new Order(dispatcher3, client3, "Odintsovo");

            order1.setEstimatedCost(100);
            order1.setRealCost(150);
            order1.setEndPoint("Podolck");

            order2.setEstimatedCost(150);
            order2.setRealCost(150);
            order2.setEndPoint("Kazan");

            order3.setEstimatedCost(200);
            order3.setRealCost(150);
            order3.setEndPoint("Bakovka");

            orderService.addOrder(order1);
            orderService.addOrder(order2);
            orderService.addOrder(order3);

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
