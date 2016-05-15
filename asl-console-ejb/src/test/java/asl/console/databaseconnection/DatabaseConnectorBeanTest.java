package asl.console.databaseconnection;

import asl.console.configuration.ConfigurationManagerBean;
import asl.exceptions.InvalidEntityException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sengir on 19.04.16.
 */
public class DatabaseConnectorBeanTest {
    @InjectMocks
    private DatabaseConnectorBean databaseConnectorBeanToTest;

    @BeforeClass
    public void prepareForTest() {
        databaseConnectorBeanToTest = null;
        initMocks(this);
    }

    @Test(expectedExceptions = {InvalidEntityException.class})
    public void testGetFromDb() throws SQLException, InvalidEntityException {
        databaseConnectorBeanToTest.getFromDb(new Object());
//        Assert.fail();
        //todo implement test
    }

    @Test(expectedExceptions = {InvalidEntityException.class})
    public void testStoreInDb() throws SQLException, InvalidEntityException {
        databaseConnectorBeanToTest.storeInDb(new Object());
//        Assert.fail();
        //todo implement test
    }
}