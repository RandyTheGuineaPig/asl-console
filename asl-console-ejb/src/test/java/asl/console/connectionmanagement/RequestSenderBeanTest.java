package asl.console.connectionmanagement;

import org.mockito.InjectMocks;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ObjectFactoryAnnotation;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sengir on 19.04.16.
 */
public class RequestSenderBeanTest {
    @InjectMocks
    private RequestSenderBean requestSenderBeanToTest;

    @BeforeClass
    public void prepareForTest() {
        requestSenderBeanToTest = null;
        initMocks(this);
    }

    @Test
    public void testSendRequest() {
        requestSenderBeanToTest.sendRequest(new Object());
//        Assert.fail();
        //todo implement test
    }
}