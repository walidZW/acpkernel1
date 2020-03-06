package kernel;
import weka.core.matrix.*;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.lang.model.type.NullType;
import javax.print.DocFlavor;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URL;

public class ImageMat {
private String path;

/*--------------------------------------*/
    public ImageMat(String pat){
        this.path=pat;
        System.out.println("paht : " + this.path);
    }


    public Matrix imageToMatrix() {
        try {
            BufferedImage img = ImageIO.read(new File(this.path));
            Raster raster = img.getData();
            int w = raster.getWidth(), h = raster.getHeight();
            Matrix pixels = new Matrix(w,h);
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    pixels.set(x,  y, raster.getSample(x, y, 0));
                }
            }
            return pixels;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /*-----------------------------------------------*/



    public java.awt.Image MatrixToImage(Matrix pixels) {
        int w = pixels.getColumnDimension();
        int h = pixels.getRowDimension();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = (WritableRaster) image.getData();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                raster.setSample(i, j, 0, pixels.get(i, j));
            }
        }
        File output = new File("check.jpg");
        try {
            ImageIO.write(image, "jpg", output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}




