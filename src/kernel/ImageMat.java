package kernel;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
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
import java.io.IOException;
import java.net.URL;

public class ImageMat {
    private String path;

    /*--------------------------------------*/
    public ImageMat(String pat) {
        this.path = pat;
        System.out.println("paht : " + this.path);
    }

    /*------------------------------------------------------------------*/
    public Matrix imageToMatrix() {
      /*  try {

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
        }*/

        File f = new File(this.path);
        BufferedImage buf = null;
        try {
            buf = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        int j = 0;
        double[][] tab = new double[buf.getHeight()][buf.getWidth()];
        for (i = 0; i < buf.getWidth(); ++i) {
            for (j = 0; j < buf.getHeight(); ++j) {
                tab[j][i] = (double) buf.getRGB(i, j);
            }
        }
        Matrix mat = new Matrix(tab);
        return mat;
    }

    /*-----------------------------------------------*/
// of mohammed
    public static Mat imageToMatcv(String path) {
        Imgcodecs imgcodecs = new Imgcodecs();
        Mat matrix = imgcodecs.imread(path);

        return matrix;
    }

    /*--------------------------------------------------------------*/


    public BufferedImage MatrixToImage(Matrix pixels) {
        int w = pixels.getColumnDimension();
        int h = pixels.getRowDimension();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        double[][] tab = pixels.getArray();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                image.setRGB(i, j, (int) tab[j][i]);
            }
        }
        return image;
    }
    /*---------------------------------------------------------------------*/

    // construct javafx image from an opencv matrix
    public static Image matcvToImage(Mat matrix) {
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".bmp", matrix, matOfByte);
        return null; // a revoir
    }
        /*---------------------------------------------------------*/


      /*public Matrix ImageToVect(){
            return null;
        } */

        /*---------------------------------------------------------*/
    /*public Matrix VectToImage(){
return null;}
*/
        /*------------------------------------------------------*/


    }






