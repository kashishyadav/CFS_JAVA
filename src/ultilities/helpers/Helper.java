/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities.helpers;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Khang
 */
public class Helper {

    public static Image ResizeImage(String imagePath, int width, int height) {
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon MyImage = new ImageIcon(imagePath);
            Image img = MyImage.getImage();
            Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            //ImageIcon image = new ImageIcon(newImg);
            return newImg;
        }
        return null;
    }

    public static ImageIcon convertImageToImageIcon(Image img) {
        if (img == null) {
            return null;
        }
        ImageIcon image = new ImageIcon(img);
        return image;
    }
}
