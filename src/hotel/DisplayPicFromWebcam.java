/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author trinh
 */
public class DisplayPicFromWebcam {
    
    public DisplayPicFromWebcam(JLabel profile)
    {
        displayImage(Mat2BufferedImage(Imgcodecs.imread("camera.jpg")), profile);
    }
    
    public Image Mat2BufferedImage(Mat m) {

        int type = BufferedImage.TYPE_BYTE_GRAY;
        if ( m.channels() > 1 ) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels()*m.cols()*m.rows();
        byte [] b = new byte[bufferSize];
        m.get(0,0,b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);  
        return image;
    }
            

    public ImageIcon ResizeImagefromMat(Image img, JLabel profile)
    {
        Image newImg = img.getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImg);
        return icon;
    }
    
    public void displayImage(Image img, JLabel profile)
    {   
        profile.setIcon(ResizeImagefromMat(img, profile));    
    }        
        
    
}
