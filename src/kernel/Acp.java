package kernel;
//la classe acp

import javafx.scene.image.Image;
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


    public ArrayList<Matrix> ImporterImages(){
        File directory=new File("/acpkernel/orl/");
        ArrayList<Matrix> trainingimages=new ArrayList<>();
        for(File fd : directory.listFiles() ){
              for(File ff :fd.listFiles()) {
                  //get the image
                  ImageMat image= new ImageMat(ff.getPath());
                  //convert the image to matrix
                  trainingimages.add(image.imageToMatrix());
              }

        }
         return trainingimages;
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





    /*------------------------------------------------------------------------------*/
    // data projection on the new space
    public double[][] projectData(EigenSpace eigenSpace, Matrix mat){
        double[][] dataSet=mat.getArray();
        double[][] projectedData = new double[dataSet.length][eigenSpace.getDimension()];
        for (int i = 0; i < dataSet.length; i++){
            double[] coordinates = eigenSpace.GetCoordinates(dataSet);
            projectedData[i] = coordinates;
        }
        return projectedData;
    }

    /*---------------------------------------------------------------------------------*/
    public double[][] trainModel(){

        // import images
        ArrayList<Matrix> data=this.ImporterImages();

        // calculate the mean
        double[] mean = calculerVisageMoyen(dataSet);

        // create data set matrix
        Matrix dataSetMatrix = new Matrix(dataSet);

        // subtract the mean from the data set
        dataSetMatrix.minus(new Matrix(mean, 1));

        // get covariance matrix eigenvalues and eigenvectors
        Matrix eigenVectors = dataSetMatrix.svd().getU();

        // create the eigenspace
        int dim = reduireDimension(eigenVectors.getRowDimension()); // eigenspace dimension
        eigenSpace = creerEigenSpace(eigenVectors.getArray(), dim);

        // data projection on the new space
        double[][] projectedDataSet = projectData(eigenSpace, dataSet);

        return projectedDataSet;
    }

    /*------------------------------------------------------------------*/

    public Result recognize(ImageMat inputFace, double[][] projectedDataSet){

        assert eigenSpace != null;

        double[] faceData = inputFace.// normalement imagetovector
        // calculate distances
        ArrayList<Double> distances = new ArrayList<>();
        for (int i = 0; i < totalTrainImagesNumber; i++){
            distances.add(eigenSpace.getDistance(faceData));
        }

        int elementsLessThanThresholdNum = 0;
        for (double d:distances
        ) {
            if (d <= threshold){
                elementsLessThanThresholdNum ++;
            }
        }
        if (elementsLessThanThresholdNum == 0){
            return Result.REJETE;
        }
        if (elementsLessThanThresholdNum == 1){
            return Result.RECONNUE;
        }
        else {
            return Result.CONFUSION;
        }
    }
 /*------------------------------------------------------------------------*/

public Matrix reduireDimension(EigenSpace eg){
    return null;
}




    // setters and getters
    public int getTotalTrainImagesNumber() {
        return totalTrainImagesNumber;
    }

    public void setTotalTrainImagesNumber(int totalTrainImagesNumber) {
        this.totalTrainImagesNumber = totalTrainImagesNumber;
    }

    public int getTrainImagesNumber() {
        return trainImagesNumber;
    }

    public void setTrainImagesNumber(int trainImagesNumber) {
        this.trainImagesNumber = trainImagesNumber;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }


    /*------------------------------------------------------------------*/









    // recognize the new image
/*    public Result reconize(Image inputFace){
        return null;
    }*/
  /*-----------------------------------------------------------------*/






}
