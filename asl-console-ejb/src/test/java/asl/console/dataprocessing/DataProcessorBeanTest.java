package asl.console.dataprocessing;

import org.mockito.InjectMocks;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sengir on 19.04.16.
 */
public class DataProcessorBeanTest {
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