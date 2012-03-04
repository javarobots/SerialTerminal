package util.rxtx;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author javarobots
 */
public class SerialDataListener implements SerialPortEventListener {

    private InputStream mInputStream;
    private byte[] buffer = new byte[1024];
    private JTextArea mOutputTextArea;

    public SerialDataListener(InputStream inStream, JTextArea textArea){
        mInputStream = inStream;
        mOutputTextArea = textArea;
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        try {
            int bytesRead = mInputStream.read(buffer);
            while(bytesRead > 0){
                mOutputTextArea.append(new String(buffer,0,bytesRead));
                bytesRead = mInputStream.read(buffer);
            }
        } catch (IOException ex) {
            Logger.getLogger(SerialDataListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
