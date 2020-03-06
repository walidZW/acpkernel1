package kernel;
import weka.core.matrix.*;
public class Main {

    public static void main(String[] args) {

        ImageMat img1=new ImageMat("/acpkernel1/orl/PERSON1/1.bmp");
        Matrix mat1=img1.imageToMatrix();

        System.out.println(mat1);
    }
}
