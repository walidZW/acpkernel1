package kernel;
//la classe acp

import java.awt.*;

public class Acp {
    private int totalTrainImagesNumber = 200;
    private int trainImagesNumber = 5;
    // TODO: 03/03/2020 give a value to threshold
    private double threshold;
    private double[][] dataSet;

    private EigenSpace eigenSpace = null;

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
