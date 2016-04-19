package asl.console.usermgmt;

import org.mockito.InjectMocks;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sengir on 19.04.16.
 */
public class CredentialsValidatorBeanTest {
    @InjectMocks
    private CredentialsValidatorBean credentialsValidatorBeanToTest;

    @BeforeClass
    public void prepareForTest() {
        credentialsValidatorBeanToTest = null;
        initMocks(this);
    }

    @Test
    public void testPrepareRequest() {
        credentialsValidatorBeanToTest.validate(new Object());
//        Assert.fail();
        //todo implement test
    }
}