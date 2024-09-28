package dbp.hackathon.QR;

import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.qrcode.QRCodeReader;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class QRCodeValidator {

    public String validateQRCode(String filePath) {
        try {
            File file = new File(filePath);
            BufferedImage bufferedImage = ImageIO.read(file);

            QRCodeReader qrCodeReader = new QRCodeReader();
            Result result = qrCodeReader.decode(new BufferedImageLuminanceSource(bufferedImage));

            return result.getText(); // Retorna el contenido del QR
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        } catch (NotFoundException e) {
            throw new RuntimeException("Código QR no encontrado: " + e.getMessage());
        }
    }
}
