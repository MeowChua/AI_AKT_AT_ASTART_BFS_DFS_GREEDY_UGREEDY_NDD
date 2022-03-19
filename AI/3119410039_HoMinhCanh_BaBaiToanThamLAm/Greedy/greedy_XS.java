package Greedy;

public class greedy_XS {
    public static void xuly(int [][]arr){
        int dinh[] = new int [arr.length];
        int dem = 0;

        int kt;
        for (int i = 0 ; i < dinh.length;i++){
            if(dinh[i]==0) {
                dem++; //Dem so mau
                dinh[i]=dem;
                for(int j=i+1;j< dinh.length;j++) //Kiem tra xem nhung dinh nao co the gan bang mau dem nua khong
                    if((arr[i][j]==0)&&(dinh[j]==0)){
                        kt=1;
                        for(int k=i+1;k<j;k++)
                            if((arr[k][j]==1)&&(dinh[i]==dinh[k])){
                                kt=0;
                                break;
                            }
                        if(kt==1) dinh[j]=dem;
                    }
            }
        }
        for(int i = 0 ; i < dinh.length; i++)
            System.out.print(dinh[i]+"\t");
    }
    public static void main(String []args){
        int [][]arr ={{0, 1, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0}};
        greedy_XS.xuly(arr);
    }
}
