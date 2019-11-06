/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.ultilities.helpers;

import base.configurations.constants.SystemConstants;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import org.apache.commons.io.FilenameUtils;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Khang
 */
public class FileHelper extends Helper {

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel origin = null;
        FileChannel destination = null;
        try {
            origin = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();

            long count = 0;
            long size = origin.size();
            while ((count += destination.transferFrom(origin, count, size - count)) < size);
        } finally {
            if (origin != null) {
                origin.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

    public static String writeImageToFolder(String srcPath, String desPath, String fileName) throws IOException {
        if (srcPath.isEmpty()) {
            return new StringBuilder().toString();
        }

        String fName = fileName.isEmpty() ? "tempImg" : fileName;
        String imgPath = new StringBuilder(desPath).append("/").append(fName).append(".jpg").toString();
        String fullImgPath = new StringBuilder(SystemConstants.DOMAIN_FOLDER).append(imgPath).toString();

        BufferedImage bimage = ImageIO.read(new File(srcPath));
//        Graphics2D g2 = bimage.createGraphics();
//        g2.drawImage(img, 0, 0, null);
//        g2.dispose();

        ImageIO.write(bimage, "jpg", new File(new StringBuilder(SystemConstants.DOMAIN_FOLDER).append(imgPath).toString()));
        return imgPath;

    }

    

    public static String removeExtensionFromFileName(String fileName) {
        return FilenameUtils.removeExtension(fileName);
    }

}
