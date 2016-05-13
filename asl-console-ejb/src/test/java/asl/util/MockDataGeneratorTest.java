package asl.util;

import asl.mock.MockDataGeneratorBean;
import org.mockito.InjectMocks;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sengir on 19.04.16.
 */
public class MockDataGeneratorTest {
    @InjectMocks
    private MockDataGeneratorBean mockDataGeneratorBeanToTest;

    @BeforeClass
    public void setUp() {
        mockDataGeneratorBeanToTest = null;
        initMocks(this);
    }

    @Test
    public void testGetData() {
        String s = mockDataGeneratorBeanToTest.getData();
        assert(s.equals("Hey, it's dummy data!"));
    }
}
