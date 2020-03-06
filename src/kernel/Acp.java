package kernel;
//la classe acp

import weka.core.matrix.Matrix;

import java.io.File;
import java.util.ArrayList;

public class Acp {
    private int totalTrainImagesNumber = 200;
    private int trainImagesNumber = 5;
    // TODO: 03/03/2020 give a value to threshold
    private double threshold;
    private double[][] dataSet;

    private EigenSpace eigenSpace = null;


   // la méthode ImporterImages: importation des images depuis la base de donnée ORL)
    public Matrix ImporterImages(){
        File directory=new File("/acpkernel/orl/");
        ArrayList<Matrix> trainingimages=new ArrayList<>();
        for(File fd : directory.listFiles() ){
              for(File ff :fd.listFiles()) {
                  //get the image

                  //convert the image to matrix

              }

        }




    }
    

    public Acp(double[][] dataSet){
        this.dataSet = dataSet;
    }

    // TODO: 03/03/2020 implement this method
    public void importFaces(){

    }
    // TODO: 03/03/2020 implement this method
    public double[] calculerVisageMoyen(double[][] dataSet){
        return null;
    }

    // used to calculate the reduced dimension of the new eigenspace
    public int getEigenSpaceDimension(){
        return 0;
    }


    // create the eigenspace from dataSet
    public EigenSpace creerEigenSpace(double[][] dataSet, int dim){
        return null;
    }


    // our main method used to train the model
    public void trainModel(){

    }


    // recognize the new image
    public Result reconize(Image inputFace){
        return null;
    }

}
