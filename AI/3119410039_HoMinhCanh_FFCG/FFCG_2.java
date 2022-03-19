package FFCG_2;
import java.io.*;
import java.util.*;

public class FFCG_2 {

    public static Hashtable<String, ArrayList<String>> seen;

    // Our main method
    public static void main(String[] Args){
        // If I was to read things in I would use the following...
        // Scanner sc = new Scanner(System.in);
        // BufferedReader br = new BufferedReader(System.in);

        // Stores the list of seen states of items and farmer
        seen = new Hashtable<String, ArrayList<String>>();

        // We try to solve the problem where no one is across the river
        canWeSolve(false, false, false, false);
//        String state = String.format("%s %s %s %s", true, true, true, true);
//        seen.put(state, new ArrayList<String>());
//        seen.get(state).add(state);
//        Set<String> setOfCountries = seen.keySet();
//
//        for (String i : setOfCountries) {
//            System.out.print(i);
//            System.out.println(seen.get(i));
//        }

        dfs(seen, "false false false false", "true true true true", "[false false false false]");
        bfs(seen, "false false false false", "true true true true");


    }

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

    public static void dfs(Hashtable<String, ArrayList<String>> graph, String start, String end, String path) {
        if(graph.get(start) == null) return;
        for( String p : graph.get(start)) {
            if(p.equals(end))
                System.out.println(path + String.format(" [%s] ", p));
            dfs(graph, p, end, new String(path + String.format(" [%s]", p)));
        }
    }

    // The recursive method for
    public static boolean canWeSolve(boolean farmer, boolean chick, boolean fox, boolean hay){

        // Check if we have seen this state otherwise add the state to the set of seen states.
        if (seen.get(String.format("%s %s %s %s", farmer, chick, fox, hay)) != null)
        {
            return false;
        }
        else
        {
            String state = String.format("%s %s %s %s", farmer, chick, fox, hay);
            seen.put(state, new ArrayList<String>());
        }

        // ND khong o day
        // Ga o voi Cao
        if ((farmer != chick) && (chick == fox)){

            return false;
        }

        // Neu 0 co nguoi ND va 0 co ga
        // Neu co ga va 0 co nguoi ND
        // Neu ga == co?
        if ((farmer ^ chick) && (chick == hay))
        {

            return false;
        }

        // 4 doi tuong cung 1 bo
        if (farmer && chick && fox && hay)
        {
            print(farmer, chick, fox, hay);

            return true;
        }

        // Neu ND dang o bo` dich'
        if (farmer)
        {

            // Neu Ga dang o cung` dich voi ND
            if (chick == farmer)
            {

                // Kiem tra truong hop. Neu mang ga` ve^` goc^'
                if (canWeSolve(false, false, fox, hay))
                {
                    String state_o = String.format("%s %s %s %s", farmer, chick, fox, hay);
                    String state_n = String.format("%s %s %s %s", false, false, fox, hay);
                    seen.get(state_o).add(state_n);

                    // Print the current state of the items with respect to the river
                    print(farmer, chick, fox, hay);

                    // Return that a solution was found
                    return true;
                }
            }

            // Neu Cao dang o cung` dich voi ND
            if (fox == farmer)
            {
                // Kiem tra mang Cao voi Bac Nong Dan qua Song dc ko
                if (canWeSolve(false, chick, false, hay))
                {
                    String state_o = String.format("%s %s %s %s", farmer, chick, fox, hay);
                    String state_n = String.format("%s %s %s %s", false, chick, false, hay);
                    seen.get(state_o).add(state_n);

                    // Print the current state of the items
                    print(farmer, chick, fox, hay);

                    // Return that a solution was found
                    return true;
                }
            }

            // Neu Thoc dang o cung` dich voi ND
            if (hay == farmer)
            {

                // Kiem tra mang Thoc voi Bac Nong Dan qua Song dc ko
                if (canWeSolve(false, chick, fox, false))
                {
                    String state_o = String.format("%s %s %s %s", farmer, chick, fox, hay);
                    String state_n = String.format("%s %s %s %s", false, chick, fox, false);
                    seen.get(state_o).add(state_n);

                    // Print out the state if the solution was found
                    print(farmer, chick, fox, hay);

                    // Return that a solution was found
                    return true;
                }
            }

            // Bac NOng Dan di 1 minh ve
            if (canWeSolve(false, chick, fox, hay))
            {
                String state_o = String.format("%s %s %s %s", farmer, chick, fox, hay);
                String state_n = String.format("%s %s %s %s", false, chick, fox, hay);
                seen.get(state_o).add(state_n);

                // Print out the state if the solution was found
                print(farmer, chick, fox, hay);

                // Return that a solution was found
                return true;
            }
        }
        else
        {
            // Neu Nong dan dang o bo nguon
            if (farmer == chick)
            {

                // Dua Nong Dan va Ga qua DIch
                if (canWeSolve(true, true, fox, hay))
                {
                    String state_o = String.format("%s %s %s %s", farmer, chick, fox, hay);
                    String state_n = String.format("%s %s %s %s", true, true, fox, hay);
                    seen.get(state_o).add(state_n);

                    // Print the state of the items
                    print(farmer, chick, fox, hay);

                    // Return that a soluiton was found
                    return true;
                }
            }

            // Neu Nong Dan va Cao o cung bo`
            if (farmer == fox)
            {

                // Dua Nong Dan va Cao qua Dich
                if (canWeSolve(true, chick, true, hay))
                {
                    String state_o = String.format("%s %s %s %s", farmer, chick, fox, hay);
                    String state_n = String.format("%s %s %s %s", true, chick, true, hay);
                    seen.get(state_o).add(state_n);

                    // Print the state of the items
                    print(farmer, chick, fox, hay);

                    // Return that a solution was found
                    return true;
                }
            }

            // Neu Nong Dan va Thoc cung 1 bo
            if (farmer == hay)
            {

                // Dua Nong Dan va Thoc qua bo
                if (canWeSolve(true, chick, fox, true))
                {
                    String state_o = String.format("%s %s %s %s", farmer, chick, fox, hay);
                    String state_n = String.format("%s %s %s %s", true, chick, fox, true);
                    seen.get(state_o).add(state_n);

                    // Print the state of the items
                    print(farmer, chick, fox, hay);

                    // Return that a solution was found
                    return true;
                }
            }

            // Nong dan qua dich 1 minh
            if (canWeSolve(true, chick, fox, hay))
            {
                String state_o = String.format("%s %s %s %s", farmer, chick, fox, hay);
                String state_n = String.format("%s %s %s %s", true, chick, fox, hay);
                seen.get(state_o).add(state_n);

                // Print the state of the items
                print(farmer, chick, fox, hay);

                // Return that a solution was found
                return true;
            }
        }

        // No possible movement resulted in a solution so we return false!
        return false;
    }

    public static void print(boolean farmer, boolean chick, boolean fox, boolean hay)
    {

        // Store what is on the far side of the river
        String Left = "";

        // Store what is on the farm side of the river
        String Right = "";

        // Check if the farmer has made the journey across
        if (farmer){
            Right = Right + "F";
            Left = Left + " ";
        }else{
            Right = Right + " ";
            Left = Left + "F";
        }

        // Add the chicken to the appropriate side of the river
        if (chick){
            Right = Right + "c";
            Left = Left + " ";
        }else{
            Right = Right + " ";
            Left = Left + "c";
        }

        // Add the fox to the appropriate side of the river
        if (fox){
            Right = Right + "f";
            Left = Left + " ";
        }else{
            Right = Right + " ";
            Left = Left + "f";
        }

        // Add the hay to the appropriate side of the river
        if (hay){
            Right = Right + "h";
            Left = Left + " ";
        }else{
            Right = Right + " ";
            Left = Left + "h";
        }

        // Print the state of the river and such
        System.out.println("farm " + Left + " | river | " + Right);
    }

}
