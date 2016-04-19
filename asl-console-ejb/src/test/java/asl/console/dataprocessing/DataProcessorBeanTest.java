package asl.console.dataprocessing;

import asl.console.databaseconnection.DatabaseConnector;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by sengir on 19.04.16.
 */
public class DataProcessorBeanTest {
//    @Mock
//    DatabaseConnector databaseConnector;

    @InjectMocks
    private DataProcessorBean dataProcessorBeanToTest;

    @BeforeClass
    public void prepareForTest() {
        dataProcessorBeanToTest = null;
        initMocks(this);
    }

    @Test
    public void testGetConfiguration() {
        dataProcessorBeanToTest.getConfiguration();
//        Assert.fail();
        //todo implement test
    }

    @Test
    public void testProcessData() {
        dataProcessorBeanToTest.processData(new Object());
//        Assert.fail();
        //todo implement test
    }

    @Test
    public void testRetrieveDataFromDb() {
        dataProcessorBeanToTest.retrieveDataFromDb();
//        Assert.fail();
        //todo implement test
    }

    @Test
    public void testStoreDataInDb() {
        dataProcessorBeanToTest.storeDataInDb(new Object());
//        Assert.fail();
        //todo implement test
    }
}