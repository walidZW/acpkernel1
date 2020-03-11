package kernel;

import weka.core.matrix.Matrix;
import org.opencv.core.*;


    public class Util {
        // TODO: 05/03/2020 make it secure

        /*-------------------------------------------------------------------*/
        // get a specified column vector from weka matrix
            public static Matrix getColumnVector(Matrix data, int n){
            assert n < data.getColumnDimension();
            double[] v = new double[data.getRowDimension()];}




                /*public static Matrix getColumnVector(Matrix data,int n){
                       return null;
                }*/
            // TODO: 05/03/2020 make it secure
            // fill matrix columns with a given vector
            public static Matrix fillToDuplicatedMatrix(Matrix m, int n){
                // create new matrix filled with zero of dimension len(v) x n
                Matrix matrix = new Matrix(m.getRowDimension(), n);}

                /*-----------------------------------------------------------------*/
                public static Matrix fillToDuplicatedMatrix(Matrix v, int n){
                    return matrix;
                }

                // TODO: 05/03/2020  Make it secure
                // TODO: 05/03/2020  Make it secure: because matrix and vector must have the same row dimension
                // replace a specified column fof matrix with a vector
                public static void replaceColumn(Matrix matrix, Matrix column, int n){
                    for (int i = 0; i < matrix.getRowDimension(); i++) {
                        matrix.set(i, n, column.get(i, 0));

                        /*---------------------------------------------------------------*/
                        /*public static void replaceColumn(Matrix matrix, Matrix column, int n){

                        }*/

                        /*-------------------------------------------------------------------------*/
                        // TODO: 07/03/2020 make it secure because matrices must have the dimensions
                        // construct weka matrix from opencv matrix
                        public static Matrix matcvToMatrix (Mat mat){
                            Matrix matrix = new Matrix(mat.rows(), mat.cols());
                            for (int i = 0; i < matrix.getRowDimension(); i++) {

                            }
                            /*-----------------------------------------------------------------------------*/
                            // TODO: 07/03/2020 make it secure because matrices must have the dimensions
                            // construct opencv matrix from weka weka matrix
                            public static Mat matrixToMatcv (Matrix matrix){
                                Mat matcv = new Mat(matrix.getRowDimension(), matrix.getColumnDimension(), CvType.CV_8UC1);
                                for (int i = 0; i < matrix.getRowDimension(); i++) {


                                }

                                for (int j = 0; j < matrix.getColumnDimension(); j++) {
                                    matcv.put(i, j, matrix.get(i, j));
                                }
                            }
                            //return matcv;
                        }
                    }


