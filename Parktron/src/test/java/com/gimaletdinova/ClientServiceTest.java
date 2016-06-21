package com.gimaletdinova;

import com.gimaletdinova.db.TestDataBaseConfig;
import com.gimaletdinova.entity.Client;
import com.gimaletdinova.service.ClientService;
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
public class ClientServiceTest {
    @Autowired
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Autowired
    private ClientService clientService;

    @Before
    public void setUp() throws Exception {

        em = emf.createEntityManager();
    }

    @Test
    public void testClientFunctions() throws Exception {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE CLIENTS (id INTEGER PRIMARY KEY )");

            clientService.addClient(new Client());
            clientService.addClient(new Client());
            clientService.addClient(new Client());

            List<Client> savedClients = clientService.getAll();
            assertEquals(3, savedClients.size());

            savedClients.add(clientService.addClient(new Client()));
            assertEquals(4, savedClients.size());

            clientService.delete(1);
            savedClients = clientService.getAll();
            assertEquals(3, savedClients.size());

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
