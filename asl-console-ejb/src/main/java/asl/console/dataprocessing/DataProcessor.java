package asl.console.dataprocessing;

import javax.ejb.Local;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface DataProcessor {
    void storeDataInDb(Object data); //todo change parameter and return types to more appropriate ones
    Object retrieveDataFromDb(); //todo change parameter and return types to more appropriate ones
    Object getConfiguration(); //todo change parameter and return types to more appropriate ones
    Object processData(Object data); //todo change parameter and return types to more appropriate ones
}
