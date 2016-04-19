package asl.console.connectionmanagement;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;

/**
 * Created by sengir on 19.04.16.
 */
@Singleton
public class RequestSenderBean implements RequestSender {
    @Override
    @Asynchronous
    public void sendRequest(Object request) {
        //todo implement sending requests
    }
}
