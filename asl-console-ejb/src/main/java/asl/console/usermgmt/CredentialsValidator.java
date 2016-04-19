package asl.console.usermgmt;

import javax.ejb.Local;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface CredentialsValidator {
    boolean validate(Object credentials); //todo change parameter type
}
