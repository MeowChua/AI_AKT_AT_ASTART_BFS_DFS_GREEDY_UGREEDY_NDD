package thamlamtoiuu;
public class chucnang {
    int[] tinhbac(int[][]a){
        int arr[] = new int [a.length];
        for(int i = 0 ; i < a.length; i++){
            int sum = 0;
            for(int j = 0 ; j < a.length; j ++){
                if(a[i][j]==1)
                    sum++;
            }
            arr[i]=sum;
        }
        return arr;
    }
}

