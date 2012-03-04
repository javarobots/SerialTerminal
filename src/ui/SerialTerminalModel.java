package ui;

import java.util.List;
import java.util.Observable;
import util.rxtx.RxTxUtilities;

/**
 *
 * @author javarobots
 */
public class SerialTerminalModel extends Observable {

    private List<String> mAvailablePorts;

    public SerialTerminalModel(){
        mAvailablePorts = RxTxUtilities.getAvailablePorts();
        setChanged();
    }

    public List<String> getAvailablePorts() {
        return mAvailablePorts;
    }

}
