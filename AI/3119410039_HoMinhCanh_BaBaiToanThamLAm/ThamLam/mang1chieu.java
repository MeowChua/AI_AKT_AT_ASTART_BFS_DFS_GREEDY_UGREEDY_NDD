package ThamLam;

import java.util.Arrays;

public class mang1chieu {
    private int[]  baccuadinh;
    private int[] tendinh;
    public mang1chieu(int[] tencuadinh,int[] baccuadinh){
        this.baccuadinh=new int[baccuadinh.length];
        this.tendinh=new int [tencuadinh.length];
        for(int i = 0 ; i < tencuadinh.length;i++){
            this.baccuadinh[i]=baccuadinh[i];
            this.tendinh[i]=tencuadinh[i];
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
        for(int i = 0 ; i <baccuadinh.length;i++){
            System.out.print(baccuadinh[i]);
        }

        System.out.println("");
        for (int i = 0 ; i < tendinh.length;i++)
            for (int j = tendinh.length-1 ; j > i;j--){
                if(baccuadinh[i]<baccuadinh[j-1])
                    this.swap(i,j - 1);
            }
    }
    public void swap(int a, int b){
        int tmp1 = tendinh[a];
        tendinh[a]=tendinh[b];
        tendinh[b]=tmp1;
        int tmp2 = baccuadinh[a];
        baccuadinh[a]= baccuadinh[b];
        baccuadinh[b]=tmp2;
    }

    @Override
    public String toString() {
        return "mang1chieu{" +
                "baccuadinh=" + Arrays.toString(baccuadinh) +
                ", tendinh=" + Arrays.toString(tendinh) +
                '}';
    }
}
