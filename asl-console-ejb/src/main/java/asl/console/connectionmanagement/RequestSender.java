package asl.console.connectionmanagement;

import javax.ejb.Local;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface RequestSender {
    void sendRequest(Object request); //todo change parameter type to more appropriate class
}
