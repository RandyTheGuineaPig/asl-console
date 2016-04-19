package asl.util;

import javax.ejb.Stateless;

/**
 * Created by sengir on 19.04.16.
 */
@Stateless
public class MockDataGeneratorBean implements MockDataGenerator {
    @Override
    public String getData() {
        return "Hey, it's dummy data!";
    }
}
