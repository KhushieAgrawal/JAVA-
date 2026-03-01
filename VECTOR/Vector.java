import java.util.Arrays;

class Vector {
    private double[] elements;

    public Vector(double[] elements) {
        this.elements = elements;
    }

    public Vector add(Vector v) throws VectorException {
        if (elements.length != v.elements.length)
            throw new VectorException("Vector size mismatch");

        double[] res = new double[elements.length];
        for (int i = 0; i < elements.length; i++)
            res[i] = elements[i] + v.elements[i];

        return new Vector(res);
    }

    public Vector subtract(Vector v) throws VectorException {
        if (elements.length != v.elements.length)
            throw new VectorException("Vector size mismatch");

        double[] res = new double[elements.length];
        for (int i = 0; i < elements.length; i++)
            res[i] = elements[i] - v.elements[i];

        return new Vector(res);
    }

    public double dotProduct(Vector v) throws VectorException {
        if (elements.length != v.elements.length)
            throw new VectorException("Vector size mismatch");

        double dot = 0;
        for (int i = 0; i < elements.length; i++)
            dot += elements[i] * v.elements[i];

        return dot;
    }

   
    public void printVector(Vector v) {
        System.out.println(Arrays.toString(v.elements));
    }
}
