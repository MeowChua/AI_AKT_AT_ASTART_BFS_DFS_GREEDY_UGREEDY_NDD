package AKT_8PUZZLE;

public class matrix {
    private int arr[][];
    private int i;
    public matrix(int [][]arr,int i){
        this.i=i;
        this.arr=arr;
    }
    public matrix(){}

    public int[][] getArr() {
        return arr;
    }

    public int getI() {
        return i;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    public void setI(int i) {
        this.i = i;
    }
}
