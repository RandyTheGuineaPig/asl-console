package asl.console.connectionmanagement;

import javax.ejb.Local;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface DataReceiver {
    void receiveData(); //todo add parameter to method signature
}
