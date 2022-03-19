/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author WIN 10
 */
public class greedy{


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
    int n=a.length,p=0,q=0,sm=0;
    int []m = new int [a.length];
    /*
    int n=5,p=0,q=0,sm=0;
    int [][]  a = {{0, 1, 1, 1, 0},
        {1, 0 ,0 ,1 ,0},
        {1, 0,0 ,0, 0},
         {1, 1, 0, 0, 1},
            {0 ,0 ,0 ,1 ,0}};
    int []m = new int [5];
    */
    void xuly(){ //Xu ly de cho ra ket qua vao mang m[]
        int kt;
        for(int i=0;i<n;i++)
            if(m[i]==0) {
                sm++; //Dem so mau
                m[i]=sm;
                for(int j=i+1;j<n;j++) //Kiem tra xem nhung dinh nao co the gan bang mau sm nua khong
                    if((a[i][j]==0)&&(m[j]==0)){
                        kt=1;
                        for(int k=i+1;k<j;k++)
                            if((a[k][j]==1)&&(m[i]==m[k])){
                                kt=0;
                                break;
                            }
                        if(kt==1) m[j]=sm;
                    }
            }
    }
    void xuatkq(){ //In ket qua ra man hinh
        for(int i=1;i<=sm;i++){
            System.out.print( "Mau " + i + ": ");
            for(int j=0;j<n;j++) if(m[j]==i) System.out.print( j + " ");
            System.out.println();
        }
    }

}
