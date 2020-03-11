package kernel;

import weka.core.EuclideanDistance;
import weka.core.matrix.Matrix;

import java.util.ArrayList;

//la classe eigenspace
public class EigenSpace {



/*---------------------------------------------------------------------------*/
    private int dimension=-1;
    private Matrix base=null;
    private Matrix centers=null; // nb de classes puis la dimension
    private int nbcent;
  /*-----------------------------------------------------------------------------*/
    public EigenSpace(Matrix s,Matrix cent,int nb)
    {
        this.base=s;
        this.dimension=base.getRowDimension() ;
        this.centers=cent;
        this.nbcent=nb;
    }
/*--------------------------------------------------------------------------------*/
    public Matrix GetCoordinates( Matrix y) throws Exception {
        Matrix x=base.transpose().times(y);
        return x;
    }

    /*-----------------------------------------------------------------------*/
    public double[] getDistance(Matrix img) throws Exception {
        Matrix c=GetCoordinates(img);
        double[] dist=new double[this.centers.getColumnDimension()];
        double[][] p=c.getArrayCopy();

        EuclideanDistance distance=new EuclideanDistance();
        for (int i=0;i<this.centers.getColumnDimension();i++) {
           /* for (int j = 0 ; j < this.dimension ; j++)
            {
                //sum += Math.pow(centers[i][j] - p[1][j], 2);
            }*/

           dist[i]=distance.distance(img,(Matrix)this.centers.getco);

        }

        return dist;
    }

    /*--------------------------------------------------------------------------------*/

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Matrix calculatecenters(Matrix[][] dataset){
        int step=0;
        for (int i=0;i<this.nbcent;i++)
        {
          for(int j=0;j<5;j++){
              //get a submatrix
     //Matrix mat=new Matrix();

              //calculate mean

              //add column to new matrix

          }

        }

        return null;
    }

    /*--------------------------------------------------------------------------------*/


}
