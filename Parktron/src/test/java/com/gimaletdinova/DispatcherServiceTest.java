package com.gimaletdinova;

import com.gimaletdinova.db.TestDataBaseConfig;
import com.gimaletdinova.entity.Car;
import com.gimaletdinova.entity.Client;
import com.gimaletdinova.entity.Dispatcher;
import com.gimaletdinova.service.CarService;
import com.gimaletdinova.service.DispatcherService;
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
public class DispatcherServiceTest {
    @Autowired
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Autowired
    private DispatcherService dispatcherService;

    @Before
    public void setUp() throws Exception {

        em = emf.createEntityManager();
    }

    @Test
    public void testDispatcherFunctions() throws Exception {

        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE DISPATCHERS (id INTEGER PRIMARY KEY, fio VARCHAR(50))");

            dispatcherService.addDispatcher(new Dispatcher("Ivanov Ivan Ivanovich"));
            dispatcherService.addDispatcher(new Dispatcher("Tom Bush"));
            dispatcherService.addDispatcher(new Dispatcher("Barak Obama"));

            List<Dispatcher> savedDispatchers = dispatcherService.getAll();
            assertEquals(3, savedDispatchers.size());

            savedDispatchers.add(dispatcherService.addDispatcher(new Dispatcher("Sansharov Valentin Lvovich")));
            assertEquals(4, savedDispatchers.size());

            dispatcherService.delete(2);
            savedDispatchers = dispatcherService.getAll();
            assertEquals(3, savedDispatchers.size());

            Dispatcher dispatcher = dispatcherService.getByFio("Ivanov Ivan Ivanovich");
            assertEquals("Ivanov Ivan Ivanovich", dispatcher.getFio());

            dispatcherService.editDispatcher(new Dispatcher("Loy Bred Samuel"));
            savedDispatchers = dispatcherService.getAll();
            assertEquals(4, savedDispatchers.size());

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
