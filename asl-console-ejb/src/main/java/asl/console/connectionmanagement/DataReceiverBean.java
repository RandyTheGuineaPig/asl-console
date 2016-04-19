package asl.console.connectionmanagement;

import asl.console.dataprocessing.DataProcessor;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 * Created by sengir on 19.04.16.
 */
@Singleton
public class DataReceiverBean implements DataReceiver {
    @EJB
    private DataProcessor dataProcessor;

    @Override
    @Asynchronous
    public void receiveData() {
        //todo implement data receiving logic - this should listen for incoming events
    }
}
