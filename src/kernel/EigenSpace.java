package kernel;


import weka.core.matrix.Matrix;

//la classe eigenspace
public class EigenSpace {

    private int dimension;
    private Matrix base;


    public EigenSpace(Matrix s, int dim)
    {
        this.base=s;
        this.dimension=dim;
    }

    public Matrix getCoordinates( Matrix y){
        // x is one dimensional column vector
        Matrix x = base.transpose().times(y);
        return x;
    }


    public double getDistance(Matrix vector1, Matrix vector2){

        // vector1 and vector2 must have the same dimension
        assert vector1.getRowDimension() == vector2.getRowDimension();

        int dim = vector1.getRowDimension();

        int s = 0;
        for (int i = 0; i < dim; i++) {
            s += Math.pow(vector1.get(i, 0) - vector2.get(i, 0), 2);
        }
        return Math.sqrt(s);
    }


    // setter and getters
    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

}