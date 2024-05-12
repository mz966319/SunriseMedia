/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SunriseMedia;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author mbaiu
 */
public class ImageHandler {
    public static List<String> getImagesPathList(String folderPath) throws IOException {
        List<String> imagesPathList = new ArrayList<String>();
        File[] files = new File(folderPath).listFiles();

        for (File file : files) {
            if (file.isFile()) {
                if(file.getName().contains(".png") || file.getName().contains(".jpeg") || file.getName().contains(".jpg"))
                imagesPathList.add(file.getPath());
            }
        }

        return imagesPathList;
    }
    
    public static void overLayTwoImages(String logoPath, String ImagePath,String resultPathName){
        
        try
{

    BufferedImage image = ImageIO.read(new File(ImagePath));
    BufferedImage logoImage = ImageIO.read(new File(logoPath));

//    if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) 
   // {
        float alpha = 1f;
//        float alpha = 0.5f;
        int compositeRule = AlphaComposite.SRC_OVER;
        AlphaComposite ac;
        int imgW = image.getWidth();
        int imgH = image.getHeight();
        BufferedImage overlay = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = overlay.createGraphics();
        ac = AlphaComposite.getInstance(compositeRule, alpha);
        g.drawImage(image,0,0,null);
        g.setComposite(ac);
        
        int logoWidth= (int) (imgW*0.19);
        int logoHeight = (int) (imgH*0.15);
        
        int logoXPosition = imgW-logoWidth;
        int logoYPosition = 5;
        
        System.out.println("W:"+imgW+" H:"+imgH);
        System.out.println("x:"+logoXPosition+" y:"+logoYPosition);
        
        g.drawImage(logoImage,logoXPosition,logoYPosition,logoWidth,logoHeight,null);
        g.setComposite(ac);
        ImageIO.write(overlay, "PNG", new File(resultPathName));
        g.dispose();
    //}
//    else
//    {
//        System.err.println(" dymension not match ");
//    }
}
catch (IOException e)
{
}
        
    }

}
