package Greedy;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String []args) throws FileNotFoundException, IOException {
        greedy gd = new greedy();
        for(int i=0;i<gd.n;i++){ //In mang ra man hinh de theo doi
            for(int j=0;j<gd.n;j++) System.out.print( gd.a[i][j] + "  ");
            System.out.println();
        } System.out.println();
        gd.xuly();
        gd.xuatkq();

    }
}
