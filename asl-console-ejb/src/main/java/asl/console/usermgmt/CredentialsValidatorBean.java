package asl.console.usermgmt;

import javax.ejb.Stateless;

/**
 * Created by sengir on 19.04.16.
 */
@Stateless
public class CredentialsValidatorBean implements CredentialsValidator {
    @Override
    public boolean validate(Object credentials) {
        //todo implement actual logic
        return true;
    }
}
