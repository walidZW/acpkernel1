package kernel;
//la classe acp

import javafx.scene.image.Image;
import weka.core.matrix.Matrix;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Acp {

    private int totalTrainImagesNumber = 200;
    private int trainImagesNumber = 5;
    final int height = 112;
    final int width = 92;
    private String path;
    private final int perosnImages=10;

    // TODO: 03/03/2020 give a value to threshold
    private double threshold;
    private Matrix dataSet;
    private Matrix centers;
    private Matrix mean;
    private EigenSpace eigenSpace;


    // TODO: 03/03/2020 implement this method
    public Matrix importerImages(String path) throws IOException {

        File directory = new File(path);
        Matrix total = new Matrix(height * width, directory.listFiles().length * trainImagesNumber);
        int i = 0;
        int j = 0;
        File[] images = new File[10];
        for (File fd : directory.listFiles()) {
            images = fd.listFiles();
            for (i = 0; i < trainImagesNumber; i++) {
                Matrix mat = ImageMat.imageToVector(images[i].getPath());
                //Util.replaceColumn(dataSet, mat, i + j);
                Util.replaceColumn(total,mat,i+j);
            }
            j = j + trainImagesNumber;
        }

        return total;
    }


    public Matrix calculerVisageMoyen(Matrix dataSet){
        Matrix mean = new Matrix(dataSet.getRowDimension(), 1);
        int columnDim = dataSet.getColumnDimension();
        double s;
        for (int i = 0; i < dataSet.getRowDimension(); i++) {
            s = 0;
            for (int j = 0; j < dataSet.getColumnDimension(); j++) {
                s += dataSet.get(i, j);
            }
            mean.set(i, 0, Math.floor(s/columnDim));
        }
        return mean;
    }


    // TODO: 05/03/2020 Implement this method
    // used to calculate the reduced dimension of the new eigenspace
    public int reduireDimensions(Matrix eigenvectors){
        return 0;
    }


    // TODO: 05/03/2020 Implement this method
    // create the eigenspace from dataSet
    public EigenSpace creerEigenSpace(Matrix eigenvectors, int dim){
        return null;
    }



    // project data onto the new eigenspace
    public Matrix projectData(EigenSpace eigenSpace, Matrix dataSet){

        // creating empty matrix that will hold the projected data on the new face space
        Matrix projectedData = new Matrix(eigenSpace.getDimension(), dataSet.getColumnDimension());

        for (int i = 0; i < dataSet.getColumnDimension() ; i++) {
            // coordinates matrix is a p x 1 matrix
            Matrix coordinates = eigenSpace.getCoordinates(Util.getColumnVector(dataSet, i));
            // insert coordinates matrix in the projected dataMatrix
            Util.replaceColumn(projectedData, coordinates, i);
        }

        return projectedData;
    }


    // our main method used to train the model
    public Matrix trainModel() throws IOException {

        // import faced from database
        dataSet = importerImages(path);

        // calculate mean
        mean = calculerVisageMoyen(dataSet);

        // subtract mean from data set
        dataSet.minusEquals(Util.fillToDuplicatedMatrix(mean, dataSet.getColumnDimension()));

        // calculate the eigenvectors of the covariance matrix
        Matrix eigenvectors = dataSet.svd().getU();

        // the reduced eigenspace dimension
        int dim = reduireDimensions(eigenvectors);

        // create the eigenspace
        eigenSpace = creerEigenSpace(eigenvectors, dim);

        // project data onto the new eigenspace
        Matrix projectedDataSet = projectData(eigenSpace, dataSet);

        // TODO: 11/03/2020 you need to calculate centers

        return projectedDataSet;
    }


    // recognize the new image
    public Result recognize(String path){

        // suppose our model was trained

        // convert input face to vector
        Matrix inputFaceMatrix = ImageMat.imageToVector(path);

        // subtract mean from inputFaceMatrix
        inputFaceMatrix.minusEquals(mean);

        // project the inputFaceMatrix onto the eigen space
        Matrix projectedInputFaceMatrix = projectData(eigenSpace, inputFaceMatrix);


        // calculate distances
        ArrayList<Double> distances = new ArrayList<>();
        for (int i = 0; i < centers.getColumnDimension() ; i++) {

            distances.add(eigenSpace.getDistance(Util.getColumnVector(centers, i), projectedInputFaceMatrix));
        }

        int foundFaces = 0;
        Iterator<Double> iterator = distances.iterator();
        while (iterator.hasNext()){
            if (iterator.next() <= threshold){
                foundFaces++;
            }
        }
        if (foundFaces == 0){
            return Result.REJETE;
        }
        if (foundFaces == 1){
            return Result.RECONNUE;
        }
        return Result.CONFUSION;
    }

}