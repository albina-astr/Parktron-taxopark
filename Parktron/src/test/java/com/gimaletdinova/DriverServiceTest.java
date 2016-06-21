package com.gimaletdinova;

import com.gimaletdinova.db.TestDataBaseConfig;
import com.gimaletdinova.entity.Car;
import com.gimaletdinova.entity.Dispatcher;
import com.gimaletdinova.entity.Driver;
import com.gimaletdinova.service.CarService;
import com.gimaletdinova.service.DriverService;
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
public class DriverServiceTest {
    @Autowired
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {

        em = emf.createEntityManager();
    }

    @Test
    public void testDriverFunctions() throws Exception {

        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE DRIVERS (id INTEGER PRIMARY KEY, fio VARCHAR(50))");

            driverService.addDriver(new Driver("Tommy Alex Layer"));
            driverService.addDriver(new Driver("Zhukov Semen Vladislavovich"));
            driverService.addDriver(new Driver("Krykov Slava Andreevich"));

            List<Driver> savedDrivers = driverService.getAll();
            assertEquals(3, savedDrivers.size());

            savedDrivers.add(driverService.addDriver(new Driver("Tomspon Sam Bush")));
            assertEquals(4, savedDrivers.size());

            driverService.delete(2);
            savedDrivers = driverService.getAll();
            assertEquals(3, savedDrivers.size());

            Driver driver = driverService.getByFio("Tomspon Sam Bush");
            assertEquals("Tomspon Sam Bush", driver.getFio());

            driverService.editDriver(new Driver("Voronov Slava Andreevich"));
            savedDrivers = driverService.getAll();
            assertEquals(4, savedDrivers.size());

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
