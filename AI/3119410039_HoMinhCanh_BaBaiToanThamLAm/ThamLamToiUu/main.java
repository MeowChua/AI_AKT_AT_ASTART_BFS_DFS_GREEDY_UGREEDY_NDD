package thamlamtoiuu;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    static int mau = 1;
    public void xuly(){
        int [][]a ={
                {0,1,1,1,0,0,0,0,0,0,1,1},

                {1,0,1,1,0,0,0,0,0,0,0,0},

                {1,1,0,1,0,0,0,0,0,0,0,0},

                {1,1,1,0,0,0,0,0,0,0,0,0},

                {0,0,0,0,0,1,1,0,0,1,0,0},

                {0,0,0,0,1,0,1,0,0,1,0,0},

                {0,0,0,0,1,1,0,0,0,1,0,0},

                {0,0,0,0,0,0,0,0,1,1,0,0},

                {0,0,0,0,0,0,0,1,0,1,0,0},

                {0,0,0,0,1,1,1,1,1,0,0,0},

                {1,0,0,0,0,0,0,0,0,0,0,1},

                {1,0,0,0,0,0,0,0,0,0,1,0}
        };

        int [] bac = new chucnang().tinhbac(a);
        int tendinh[]= new int [a.length];
        for(int i = 0 ; i < a.length;i++)
            tendinh[i]=i;

        mang1chieu mang = new mang1chieu(tendinh,bac);
        int[] maudato = new int[a.length];


        System.out.println("TO MAU 1");

        mang.toMau_1(a);

        System.out.println("TO MAU 2");

        mang = new mang1chieu(tendinh,bac);
        mang.toMau_2(a);

        System.out.println("TO MAU 3");
        mang = new mang1chieu(tendinh,bac);

        mang.toMau_3(a);

    }

    /// --------------------- TO MAU NANG CAO

    /// --------------------- TO MAU NANG CAO

    public static int demMau(int[] arr, int i) {
        int dem = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i)
                dem ++;
        }

        return dem;
    }

    public static int max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            if (max < arr[i])
                max = arr[i];
        return max;
    }

    public static void KiemTra(int[] maudato, int[][] graph, int dinh) {
        if (maudato[dinh] != 0) return;
        maudato[dinh] = mau;
        for (int i = 0; i < maudato.length; i++) {
            if (graph[dinh][i] == 0 && maudato[i] == 0 && CheckMauKe(maudato, graph, i, mau))
                maudato[i] = mau;
        }
        mau += 1;
    }

    public static boolean CheckMauKe(int[] maudato, int[][] graph,int dinh, int mau) {
        for(int i = 0; i < graph.length; i++) {
            if(graph[dinh][i] == 1)
                if(maudato[i] == mau)
                    return false;
        }

        return true;
    }

    public static void main(String []args){
        new main().xuly();
    }
}

