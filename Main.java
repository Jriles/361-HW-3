import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Pair<Integer, Integer> p1 = Pair.createPair(0, 3);
        // Pair<Integer, Integer> p2 = Pair.createPair(1, 2);
        // Pair<Integer, Integer> p3 = Pair.createPair(3, 1);

        // List<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();
        // pairs.add(p1);
        // pairs.add(p2);
        // pairs.add(p3);
        // System.out.print("[");
        // for (Pair p : pairs) {
        // System.out.print(p.toString());
        // System.out.print(",");
        // }
        // System.out.print("]\n");
        // Map<Integer, Integer> location = new HashMap<>();
        // for (Pair p : pairs) {
        // int priority = (int) p.getPriority();
        // int elem = (int) p.getElem();
        // location.put(priority, elem);
        // }

        // System.out.println(location.get(0));
        PriorityQueue test = new PriorityQueue();
        test.push(0, 3);
        test.printHeap();
    }
}
