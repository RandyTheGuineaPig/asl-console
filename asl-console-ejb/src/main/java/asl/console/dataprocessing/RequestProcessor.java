package asl.console.dataprocessing;

import javax.ejb.Local;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface RequestProcessor {
    void prepareRequest(); //todo add a parameter
}
