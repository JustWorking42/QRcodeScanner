import com.github.sarxos.webcam.Webcam;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Webcam webcam = Webcam.getDefault();
        QRcodeScanner.webcamWindow(webcam);
    }
}