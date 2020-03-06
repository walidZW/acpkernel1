package kernel;

import weka.core.matrix.Matrix;

import java.util.ArrayList;

//la classe eigenspace
public class EigenSpace {



/*---------------------------------------------------------------------------*/
    private int dimension=-1;
    Matrix base=null;
    Matrix centers=null; // nb de classes puis la dimension
  /*-----------------------------------------------------------------------------*/
    public EigenSpace(Matrix s)
    {
        this.base=s;
        this.dimension=base.getColumnDimension()*base.getRowDimension() ;
    }
/*--------------------------------------------------------------------------------*/
    public Matrix GetCoordinates( Matrix y) throws Exception {
        Matrix x=base.transpose().times(y);
        return x;
    }

    /*-----------------------------------------------------------------------*/
    public double[] getdistance(Matrix img) throws Exception {
        Matrix c=GetCoordinates(img);
        double[][] p=c.getArrayCopy();
        double sum=0;
        double min=-1;
        for (int i=0;i<40;i++) {
            for (int j = 0 ; j < this.dimension ; j++)
            {
                sum += Math.pow(centers[i][j] - p[1][j], 2);
            }

            if (sum < min) {
                min = sum;
            }else if(min==-1) min=sum;

            sum=0;
        }
        return Math.sqrt(min);
    }

    /*--------------------------------------------------------------------------------*/

    public double[][] calculatecenters(double[][] dataset){
        int step=0;
        for (int i=0;i<dataset.length;i++)
        {

            Image1.VectorToImage(dataset[i]);
        }


    }

    /*--------------------------------------------------------------------------------*/


}
