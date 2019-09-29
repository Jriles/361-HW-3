import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

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
        Pair<Integer, Integer> p1 = Pair.createPair(0, 3);
        Pair<Integer, Integer> p2 = Pair.createPair(1, 2);
        Pair<Integer, Integer> p3 = Pair.createPair(3, 1);

        List<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();
        pairs.add(p1);
        pairs.add(p2);
        pairs.add(p3);
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.heap = pairs;
        System.out.println("Before: ");
        for(int j = 0; j < priorityQueue.heap.size();j++){
            System.out.println("index: " + j + ", element: " + priorityQueue.heap.get(j).getElem() + ", priority: " + priorityQueue.heap.get(j).getPriority());
        }
        System.out.println(priorityQueue.isEmpty());
        System.out.println("After: ");
        for(int i = 0; i < priorityQueue.heap.size();i++){
            System.out.println("index: " + i + ", element: " + priorityQueue.heap.get(i).getElem() + ", priority: " + priorityQueue.heap.get(i).getPriority());
        }
    }
}
