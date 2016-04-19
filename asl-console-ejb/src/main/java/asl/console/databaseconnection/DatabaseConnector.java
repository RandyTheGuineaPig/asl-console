package asl.console.databaseconnection;

import javax.ejb.Local;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface DatabaseConnector {
    void storeInDb(Object object); //todo change method signature to more appropriate
    Object getFromDb(Object object); //todo change method signature to more appropriate
}
