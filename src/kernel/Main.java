package kernel;
import weka.core.matrix.*;

import java.awt.image.BufferedImage;
public class Main {
    public static void main(String[] args) {

       ImageMat img1=new ImageMat("/acpkernel1/orl/PERSON1/1.bmp");
       Matrix mat2=  img1.imageToMatrix();

System.out.println(mat2);}}