package kernel;

import javafx.scene.image.Image;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import weka.core.matrix.Matrix;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

//la classe java
public class ImageMat{

/*-----------------------------------------------------------------------------------------------*/
    // construct an opencv matrix from an image
    public static Mat imageToMatcv(String path) {
        Imgcodecs imgcodecs = new Imgcodecs();
        Mat matrix = imgcodecs.imread(path);

        return matrix;
    }
/*--------------------------------------------------------------------------------------------------------------*/
    // construct javafx image from an opencv matrix
    public static Image matcvToImage(Mat matrix){
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".bmp", matrix, matOfByte);
        byte[] byteArray = matOfByte.toArray();
        InputStream in = new ByteArrayInputStream(byteArray);
        javafx.scene.image.Image image = new javafx.scene.image.Image(in);
        return image;
    }
/*--------------------------------------------------------------------------------------------------------------------*/
    // construct weka one dimensional vector from an image
    public static Matrix imageToVector(String path){

        Mat mat = imageToMatcv(path);
        Matrix matrix = Util.matcvToMatrix(mat);
        double[] packedArray = matrix.getRowPackedCopy();
        return new Matrix(packedArray, packedArray.length);
    }

    /*------------------------------------------------------------------------------------------------------------*/
    public static Image vectorToImage(Matrix matrix) {
        int h = 112;
        int w = 92;
        Matrix out = new Matrix(h, w);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < h * w){
            out.set(k, j, matrix.get(i, 0));
            j++;
            i++;
            if (j == w - 1){
                k++;
                j = 0;
            }
        }

        return matcvToImage(Util.matrixToMatcv(matrix));
    }

}





