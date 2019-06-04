/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String path = "C:\\Users\\trinh\\Documents\\GitHub\\HotelBookingSystem\\src\\Image\\camera.jpg";
        
        displayImage(Mat2BufferedImage(Imgcodecs.imread(path)), profile);

        try {

           Connection conn = LoginConnection.getConnection();

            String updateSQL = "update manager_info set profile = ? where manager_info.username = '" + Login.userField.getText() + "'"; 
            
            PreparedStatement preparedStmt = conn.prepareStatement(updateSQL);
 
            preparedStmt.setString(1, path);
 
            preparedStmt.executeUpdate();
                        
            } catch (SQLException ex) {
                Logger.getLogger(HotelJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
