package asl.console.connectionmanagement;

import asl.console.dataprocessing.DataProcessor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;


/**
 * Created by sengir on 19.04.16.
 */
public class DataReceiverBeanTest {
//    @Mock
//    private DataProcessor dataProcessor;

    @InjectMocks
    private DataReceiverBean dataReceiverBeanToTest;

    @BeforeClass
    public void prepareForTest() {
        dataReceiverBeanToTest = null;
        initMocks(this);
    }

    @Test
    public void testReceiveData() {
        dataReceiverBeanToTest.receiveData();
//        Assert.fail();
        //todo implement test
    }
}