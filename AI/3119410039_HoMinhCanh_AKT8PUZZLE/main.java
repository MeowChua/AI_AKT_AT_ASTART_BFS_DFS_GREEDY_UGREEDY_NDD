package AKT_8PUZZLE;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Collections;

public class main {
//    public static void swap(Vector<node> open, Object i, Object i1) {
//        Object tmp = i;
//        i=i1;
//        i1=tmp;
//    }
    public static int[] getIndexZero(int[][] puzzle) {
        for (int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(puzzle[i][j] == 0){
                    int[] rs = {i, j};
                    return rs;
                }
        int[] rs = {-1, -1};
        return rs;
    }

    public static void main(String []args) {
        int[][] puzzle = new int[3][3];
        int[] ar;
        AKT akt = new AKT(puzzle);
        akt.initPuzzle();
        int step = 0;
        long numOfNode = 0;
        boolean check = akt.checkFinish();
        System.out.println(akt.getPosX());
        System.out.println(akt.getPosY());
        //const clock_t begin_time = clock();
        String way = "";
        int checker = akt.countStart() % 2;
        node nd = new node(akt.getPuzzle(), facing.STAY, akt.getPosX(), akt.getPosY(), 0, checker, akt.getCost());

        Vector<node> vt = new Vector<>();
        vt.add(nd);
        System.out.println("Trang thai ban dau : ");
        akt.print();
        System.out.println();
        while (!check && vt.size() != 0) {
            Vector<node> open = new Vector<node>();
            int i = vt.size() - 1;
            if (vt.get(i).checkFinish()) {
                // Cai way bi loi
                way = vt.get(i).getWay();
                check = true;
                for(int iii = 0; iii < 3; iii++) {
                    for(int jj=0; jj < 3; jj++)
                        System.out.print(vt.get(i).getArr()[iii][jj]);

                    System.out.println("");
                }
                break;
            } else {
                if (vt.get(i).canMoveUp()) {
                    node nd1 = new node(vt.get(i));
                    nd1.moveUp();
                    open.add(nd1);
                }
                if (vt.get(i).canMoveDown()) {
                    node nd1 = new node(vt.get(i));
                    nd1.moveDown();
                    open.add(nd1);
                }
                if (vt.get(i).canMoveRight()) {
                    node nd1 = new node(vt.get(i));
                    nd1.moveRight();
                    open.add(nd1);
                }
                if (vt.get(i).canMoveLeft()) {
                    node nd1 = new node(vt.get(i));
                    nd1.moveLeft();
                    open.add(nd1);
                }
            }

            vt.remove(vt.size() - 1);

//            //#define REPS(i , l , r) for(int i = l ; i < r ; i++)
            for (int a = 0; a < open.size(); a++) {
                for (int b = a + 1; b < open.size(); b++) {
                    if (open.get(a).herStic() <= open.get(b).herStic()) {
                        node tmp = open.get(a);
                        open.set(a, open.get(b));
                        open.set(b, tmp);
                    }
                }
//
            }
            for (int a = 0; a < open.size(); a++) {
                if (open.get(a).herStic() == open.get(open.size() - 1).herStic()) {
                    vt.add(open.get(a));
                }
            }

            numOfNode++;
        }
        System.out.println(way);
        System.out.print("-->");
        for (int i = 0; i < way.length(); i++){
            if(way.charAt(i) == 'l'){
                akt.moveLeft();
                akt.print();
                System.out.println("di chuyen sang trai");
            }else if(way.charAt(i) == 'r'){
                akt.moveRight();
                akt.print();
                System.out.println("di chuyen sang phai");
            }else if(way.charAt(i) == 'u'){
                akt.moveUp();
                akt.print();
                System.out.println("di chuyen len tren");
            }else if(way.charAt(i) == 'd'){
                akt.moveDown();
                akt.print();
                System.out.println("di chuyen xuong duoi");
            }

        }
    }
}


