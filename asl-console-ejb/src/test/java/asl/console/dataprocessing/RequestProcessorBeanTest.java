package asl.console.dataprocessing;

import asl.console.configuration.ConfigurationManager;
import asl.console.connectionmanagement.RequestSender;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sengir on 19.04.16.
 */
public class RequestProcessorBeanTest {
//    @Mock
//    private RequestSender requestSender;
//
//    @Mock
//    private ConfigurationManager configurationManager;

    @InjectMocks
    private RequestProcessorBean requestProcessorBeanToTest;

    @BeforeClass
    public void prepareForTest() {
        requestProcessorBeanToTest = null;
        initMocks(this);
    }

    @Test
    public void testPrepareRequest() {
        requestProcessorBeanToTest.prepareRequest();
//        Assert.fail();
        //todo implement test
    }
}