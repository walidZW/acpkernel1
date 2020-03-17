package kernel;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import weka.core.matrix.*;

import javax.imageio.ImageIO;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.opencv.core.Core;

public class Main extends Application {

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat matrix1 = ImageMat.imageToMatcv("orl/PERSON1/1.bmp");
        Mat matrix2 = ImageMat.imageToMatcv("orl/PERSON2/1.bmp");
        Mat matrix3 = ImageMat.imageToMatcv("orl/PERSON3/1.bmp");



        Image image1 = ImageMat.matcvToImage(matrix1);
        Image image2 = ImageMat.matcvToImage(matrix2);
        Image image3 = ImageMat.matcvToImage(matrix3);


        Group group = new Group();
        HBox hBox = new HBox();

        ImageView imageView1 = new ImageView( image1);
        ImageView imageView2 = new ImageView( image2);
        ImageView imageView3 = new ImageView((image3));



        hBox.getChildren().addAll(imageView1, imageView2, imageView3);
        group.getChildren().add(hBox);

        Scene scene = new Scene(group, 400, 400);





    }



}
