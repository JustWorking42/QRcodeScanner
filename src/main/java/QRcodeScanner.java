import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class QRcodeScanner {
    private static JFrame window = new JFrame("Scanner");
    private static Dimension size = WebcamResolution.VGA.getSize();

    public static void webcamWindow(Webcam camera) {
        camera.setViewSize(size);
        WebcamPanel camPanel = new WebcamPanel(camera, size, false);
        camPanel.setDrawMode(WebcamPanel.DrawMode.FIT);
        camPanel.start();
        window.add(camPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(1200, 600));
        window.setResizable(true);
        window.pack();
        window.setVisible(true);
        BufferedImage image;
        Result result = null;


        while ((image = camera.getImage()) != null) {
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ignored) { }
            if (result != null) {
                System.out.println( result.getText());
            }
        }
    }
}
