package thamlamtoiuu;
import java.util.Arrays;

public class mang1chieu {
    private int[]  baccuadinh;
    private int[] tendinh;
    private int[] mauDaTo;
    public mang1chieu(int[] tencuadinh,int[] baccuadinh){
        this.baccuadinh = new int[baccuadinh.length];
        this.tendinh = new int [tencuadinh.length];
        this.mauDaTo = new int[tencuadinh.length];
        for(int i = 0 ; i < tencuadinh.length;i++){
            this.baccuadinh[i] = baccuadinh[i];
            this.tendinh[i] = tencuadinh[i];
        }
    }

    public int[] getBaccuadinh() {
        return baccuadinh;
    }

    public void setBaccuadinh(int[] baccuadinh) {
        this.baccuadinh = baccuadinh;
    }

    public void setTencuadinh(int[] tencuadinh) {
        this.tendinh = tencuadinh;
    }

    public int[] getTendinh() {
        return tendinh;
    }
    public void sort(){
        for (int i = 0 ; i < tendinh.length;i++)
            for (int j = tendinh.length-1 ; j > i;j--){
                if(baccuadinh[i]<baccuadinh[j-1])
                    this.swap(i,j - 1);
            }
    }
    public void swap(int a, int b){
        int tmp1 = tendinh[a];
        tendinh[a] = tendinh[b];
        tendinh[b] = tmp1;
        int tmp2 = baccuadinh[a];
        baccuadinh[a] = baccuadinh[b];
        baccuadinh[b] = tmp2;
    }

    public void toMau_1(int[][] graph) {
        int []m = new int [graph.length];
        int n=graph.length, p=0, q=0, sm=0;
        int kt;
        for (int i = 0; i < n; i++)
            if (m[i] == 0) {
                sm++; //Dem so mau
                m[i] = sm;
                for (int j = i + 1;j < n; j++) //Kiem tra xem nhung dinh nao co the gan bang mau sm nua khong
                    if (graph[i][j] == 0 && m[j] == 0) {
                        kt=1;
                        for (int k = i + 1; k < j; k++)
                            if (graph[k][j] == 1 && (m[i] == m[k])){
                                kt = 0;
                                break;
                            }
                        if (kt == 1) m[j] = sm;
                    }
            }

        // print

        for(int i = 1; i <= sm; i++) {
            System.out.print( "Mau " + i + ": ");
            for(int j = 0; j < n; j++)
                if(m[j] == i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }

    public void toMau_2(int[][] graph) {
        while (checkZero() != 0) {
            int index = vertextMax(graph.length);
            baccuadinh[index] = 0;
            mauDaTo[index] = mauDaTo[index] * -1 + 1;
            for(int i = 0; i < graph.length; i++)
                if (graph[index][i] == 1) {
                    if (mauDaTo[i] <= 0)
                        mauDaTo[i] = mauDaTo[index]*-1;
                    if (baccuadinh[i] > 0)
                        baccuadinh[i] -= 1;
                }
        }

        int max = getColorMax(graph.length);

        for (int i = 0; i < graph.length; i++) {
            if (mauDaTo[i] < 0)
                mauDaTo[i] = mauDaTo[i]*-1 + 1;
        }

//        for(int i = 1 ; i <= max + 1; i++)
//            System.out.println("Mau " + i + ": " + demMau(mauDaTo, i));
        for(int i=1; i <= max + 1; i++) {
            System.out.print( "Mau " + i + ": ");
            for(int j=0;j<graph.length;j++)
                if(mauDaTo[j]==i)
                    System.out.print( j + " ");
            System.out.println();
        }
    }

    public void toMau_3(int[][] graph) {
        int mau = 1;
        int[] maudato = new int[graph.length];
        this.sort();
        for(int i = 0 ; i < graph.length; i++)
            mau = KiemTra(maudato, graph, this.getTendinh()[i], mau);

        for(int i = 1 ; i <= max_3(maudato); i++)
            System.out.println("Mau " + i + ": " + demMau(maudato, i));
    }

    public int KiemTra(int[] maudato, int[][] graph, int dinh, int mau) {
        if (maudato[dinh] != 0) return mau;
        maudato[dinh] = mau;
        for (int i = 0; i < maudato.length; i++) {
            if (graph[dinh][i] == 0 && maudato[i] == 0 && CheckMauKe(maudato, graph, i, mau))
                maudato[i] = mau;
        }
        mau += 1;

        return mau;
    }

    public static int max_3(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            if (max < arr[i])
                max = arr[i];
        return max;
    }

    public static boolean CheckMauKe(int[] maudato, int[][] graph,int dinh, int mau) {
        for(int i = 0; i < graph.length; i++) {
            if(graph[dinh][i] == 1)
                if(maudato[i] == mau)
                    return false;
        }

        return true;
    }

    public static int demMau(int[] arr, int i) {
        int dem = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i)
                dem ++;
        }

        return dem;
    }

    private int getColorMax(int a) {
        int max = -1;
        for (int i = 0;i < a; i++)
            if(max < mauDaTo[i])
                max = mauDaTo[i];

        return max;
    }

    private int vertextMax(int a) {
        int max = -1;
        int index = -1;
        for (int i = 0;i < a; i++)
            if(max < baccuadinh[i]) {
                max = baccuadinh[i];
                index = i;
            }

        return index;
    }

    public int checkZero() {
        int sum = 0;
        for (int i = 0; i <baccuadinh.length; i++)
            sum += baccuadinh[i];

        return sum;
    }

    @Override
    public String toString() {
        return "mang1chieu{" +
                "baccuadinh=" + Arrays.toString(baccuadinh) +
                ", tendinh=" + Arrays.toString(tendinh) +
                '}';
    }
}
