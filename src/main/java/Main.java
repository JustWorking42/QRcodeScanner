import com.github.sarxos.webcam.Webcam;

public class Main {
    private final static int TYPE_START_QR = 0;
    private final static int TYPE_START_SPEECH = 1;

    public static void main(String[] args) {
        int typeStart = 0;
        switch (typeStart) {
            case TYPE_START_QR:
                Webcam webcam = Webcam.getDefault();
                QrCodeScanner.webcamWindow(webcam);
                break;
            case TYPE_START_SPEECH:

                break;
        }
    }
}