package DONG_NUOC;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<BinhNuoc[]> open = new ArrayList<BinhNuoc[]>();
        ArrayList<BinhNuoc[]> close = new ArrayList<BinhNuoc[]>();
        Hashtable<String, ArrayList<String>> path = new Hashtable<String, ArrayList<String>>();

        // Tạo trạng thái mặc định

        int soLuongBinh = 3;

        BinhNuoc[] binhNuoc = new BinhNuoc[soLuongBinh];
        binhNuoc[0] = new BinhNuoc(3);
        binhNuoc[1] = new BinhNuoc(5);
        binhNuoc[2] = new BinhNuoc(8);

        ArrayList<String> label = new ArrayList<String>();

        open.add(binhNuoc);

        BinhNuoc[] newState;

        while (open.size() != 0) {
            // full
            String root = generateName(open.get(0));
            for (int i = 0; i < soLuongBinh; i++) {
                newState = new BinhNuoc[soLuongBinh];
                for(int j = 0; j < soLuongBinh; j++)
                    newState[j] = new BinhNuoc(open.get(0)[j]);
                newState[i].full();
                if (kiemTra(open, newState) == false && kiemTra(close, newState) == false) {
                    open.add(newState);
                    // Tạo 1 key mới. Nếu chưa có key thì tạo, ngược lại thêm phần tử vào value của key đó
                    if(path.get(root) == null) {
                        ArrayList<String> child = new ArrayList<String>();
                        child.add(generateName(newState));
                        path.put(root, child);
                    }
                    else
                        path.get(root).add(generateName(newState));
                }
            }
            // A To B
            for (int i = 0; i < soLuongBinh; i++) {
                for(int j = 0; j < soLuongBinh; j++) {
                    if (i == j) continue;
                    newState = new BinhNuoc[soLuongBinh];
                    for(int z = 0; z < soLuongBinh; z++)
                        newState[z] = new BinhNuoc(open.get(0)[z]);
                    newState[i].aToB(newState[j]);
                    if (kiemTra(open, newState) == false && kiemTra(close, newState) == false) {
                        open.add(newState);
                        // Tạo 1 key mới. Nếu chưa có key thì tạo, ngược lại thêm phần tử vào value của key đó
                        if(path.get(root) == null) {
                            ArrayList<String> child = new ArrayList<String>();
                            child.add(generateName(newState));
                            path.put(root, child);
                        }
                        else
                            path.get(root).add(generateName(newState));
                    }
                }
            }
            // Empty
            for (int i = 0; i < soLuongBinh; i++) {
                newState = new BinhNuoc[soLuongBinh];
                for(int j = 0; j < soLuongBinh; j++)
                    newState[j] = new BinhNuoc(open.get(0)[j]);
                newState[i].empty();
                if (kiemTra(open, newState) == false && kiemTra(close, newState) == false) {
                    open.add(newState);
                    // Tạo 1 key mới. Nếu chưa có key thì tạo, ngược lại thêm phần tử vào value của key đó
                    if(path.get(root) == null) {
                        ArrayList<String> child = new ArrayList<String>();
                        child.add(generateName(newState));
                        path.put(root, child);
                    }
                    else
                        path.get(root).add(generateName(newState));
                }
            }
            close.add(open.remove(0));
        }

        Set<String> keySet = path.keySet();

        System.out.println("========Tìm nhiều đường từ gốc đến đích ========== BFS");
        bfs(path, "0 - 0 - 0", "0 - 0 - 4");
        System.out.println("========Tìm tất cả các đường từ gốc đến nhiều đích ========== BDS");
        BFSTimTatCacKetQua(path, "0 - 0 - 0", "4");
        System.out.println("========Tìm tất cả các đường từ gốc đến nhiều đích ========== DFS");
        DFSTimTatCacKetQua(path, "0 - 0 - 0", "4", "[0 - 0 - 0]");
        System.out.println("========Tìm tất cả các đường từ gốc đến một đích ========== DFS");
        dfs(path, "0 - 0 - 0", "3 - 4 - 8", "[0 - 0 - 0]");

    }

    // Tìm nhiều đường từ gốc đến đích
    public static void bfs(Hashtable<String, ArrayList<String>> graph, String start, String end) {
        ArrayList<ArrayList<String>> queue = new ArrayList<ArrayList<String>>();

        ArrayList<String> startNode = new ArrayList<String>();
        startNode.add(start);

        queue.add(startNode);

        while (queue.size() != 0) {
            ArrayList<String> _path = queue.remove(0);
            String node = _path.get(_path.size() - 1);
            if (node.equals(end))
                System.out.println(_path);
            if (graph.get(node) != null) {
                for (int i = 0; i < graph.get(node).size(); i++) {
                    ArrayList<String> new_path = (ArrayList<String>) _path.clone();
                    new_path.add(graph.get(node).get(i));
                    queue.add(new_path);
                }
            }
        }
    }

    public static void BFSTimTatCacKetQua(Hashtable<String, ArrayList<String>> graph, String start, String end) {
        ArrayList<ArrayList<String>> queue = new ArrayList<ArrayList<String>>();

        ArrayList<String> startNode = new ArrayList<String>();
        startNode.add(start);

        queue.add(startNode);

        while (queue.size() != 0) {
            ArrayList<String> _path = queue.remove(0);
            String node = _path.get(_path.size() - 1);
            if (node.indexOf(end) != -1)
                System.out.println(_path);
            if (graph.get(node) != null) {
                for (int i = 0; i < graph.get(node).size(); i++) {
                    ArrayList<String> new_path = (ArrayList<String>) _path.clone();
                    new_path.add(graph.get(node).get(i));
                    queue.add(new_path);
                }
            }
        }
    }

    // Xuất ra có bao nhiêu cách từ 1 root đến 1 kết quả nhất định DFS
    public static void dfs(Hashtable<String, ArrayList<String>> graph, String start, String end, String path) {
        if(graph.get(start) == null) return;
        for( String p : graph.get(start)) {
            if(p.equals(end))
                System.out.println(path + String.format(" [%s] ", p));
            dfs(graph, p, end, new String(path + String.format(" [%s]", p)));
        }
    }

    // Xuat ra các cách đổ
    public static void DFSTimTatCacKetQua(Hashtable<String, ArrayList<String>> graph, String start, String end, String path) {
        if(graph.get(start) == null) return;
        for( String p : graph.get(start)) {
            if(p.indexOf(end) != -1)
                System.out.println(path + String.format(" [%s] ", p));
            DFSTimTatCacKetQua(graph, p, end, new String(path + String.format(" [%s]", p)));
        }
    }

    public static boolean kiemTra(ArrayList<BinhNuoc[]> list, BinhNuoc[] binhNuoc) {
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < binhNuoc.length; j++)
                if (list.get(i)[j].getMucNuoc() == binhNuoc[j].getMucNuoc())
                    count++;
            if (count == binhNuoc.length)
                return true;
        }

        return false;
    }

    public static String generateName(BinhNuoc[] binhNuoc) {
        String name = String.format("%d", binhNuoc[0].getMucNuoc());
        for (int i = 1; i < binhNuoc.length; i++)
            name += String.format(" - %d", binhNuoc[i].getMucNuoc());

        return name;
    }

}
