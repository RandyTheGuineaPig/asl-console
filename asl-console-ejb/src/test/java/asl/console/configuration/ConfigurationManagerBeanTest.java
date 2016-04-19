package asl.console.configuration;

import asl.console.databaseconnection.DatabaseConnector;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sengir on 19.04.16.
 */
public class ConfigurationManagerBeanTest {
//    @Mock
//    private DatabaseConnector databaseConnector;

    @InjectMocks
    private ConfigurationManagerBean configurationManagerBeanToTest;

    @BeforeClass
    public void prepareForTest() {
        configurationManagerBeanToTest = null;
        initMocks(this);
    }

    @Test
    public void testRetrieveConfiguration() {
        configurationManagerBeanToTest.retrieveConfiguration();
//        Assert.fail();
        //todo implement test
    }

    @Test
    public void testStoreConfiguration() {
        configurationManagerBeanToTest.storeConfiguration(new Object());
//        Assert.fail();
        //todo implement test
    }
}