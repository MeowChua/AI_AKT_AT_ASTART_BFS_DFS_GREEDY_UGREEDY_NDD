package NDD;

public class Main {
        public static void main(String[] args) {
            int[][] a = {{0, 20, 42, 31, 6, 24},
                    {10, 0, 17, 6, 35, 18},
                    {25, 5, 0, 27, 14, 9},
                    {12, 9, 24, 0, 30, 12},
                    {14, 7, 21, 15, 0, 38},
                    {40, 15, 16, 5, 20, 0}};
            matrix matrix = new matrix(a);
            System.out.println(matrix.travel(0));
            matrix.GTS2();
        }
}
