package NDD;

public class matrix {
    private int[][] matrix;
    private int[] cities;
    private int cost;

    public matrix(int[][] matrix) {
        this.matrix = matrix;
        this.cities = new int[matrix.length];
        this.cost = 0;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int travel(int city) {
        this.cities[city] = 1;
        int[] minIndex = this.getMinCity(city);
        int last = -1;
        while(minIndex[1] != -1) {
            this.cities[minIndex[1]] = 1;
            last = minIndex[1];
            this.cost += minIndex[0];
            minIndex = this.getMinCity(minIndex[1]);
        }

        return this.cost + this.matrix[last][city];
    }

    public void GTS2() {
        int min = 9999;
        int index = -1;
        int []arr = new int [6];
        int u=0;
        for (int i = 0; i < cities.length; i++) {
            this.cities = new int[matrix.length];
            this.cost = 0;
            int iMin = this.travel(i);
            if(min > iMin) {
                min = iMin;
                index = i;
                arr[u]=i;
                u++;
            }
        }
        System.out.println("Hanh trinh tot nhat voi chi phi la " + min + " bat dau tu " + index);
    }

    public int[] getMinCity(int city) {
        int[] result = new int[2];
        result[0] = 9999;
        result[1] = -1;
        for (int i = 0; i < this.matrix.length; i++)
            if (result[0] > this.matrix[city][i] && this.cities[i] == 0 && city != i) {
                result[0] = this.matrix[city][i];
                result[1] = i;
            }

        return result;
    }

}

