package com.gimaletdinova;

import com.gimaletdinova.db.TestDataBaseConfig;
import com.gimaletdinova.entity.Car;
import com.gimaletdinova.service.CarService;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.gimaletdinova.RunApplication.getDBConnection;
import static org.junit.Assert.*;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class CarServiceTest {
    @Autowired
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Autowired
    private CarService carService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testBankFunctions() throws Exception {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE CARS (stateNumber VARCHAR(50) PRIMARY KEY, isOwn INT, make  VARCHAR(50), color VARCHAR(30), comfortLevel INTEGER)");

            carService.addCar(new Car("м123ееRUS", 0, "Ferrari", "red", 1));
            carService.addCar(new Car("ф456уаRUS", 0, "Ferrari", "red", 5));
            carService.addCar(new Car("п612егRUS", 1, "Porsche", "blue", 1));
            carService.addCar(new Car("ч423уьRUS", 1, "Ford", "silver", 1));
            carService.addCar(new Car("ц652зхRUS", 1, "Ford", "orange", 2));

            List<Car> savedCars = carService.getAll();
            assertEquals(5, savedCars.size());

            List<Car> carsByMake = carService.getByMake("Ferrari");
            assertEquals(2, carsByMake.size());

            List<Car> carsByComfortLevel = carService.getByComfortLevel(1);
            assertEquals(3, carsByComfortLevel.size());

            carService.editCar(new Car("м123ееRUS", 0, "Ferrari", "purple", 1));
            savedCars = carService.getAll();
            assertEquals(5, savedCars.size());

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
