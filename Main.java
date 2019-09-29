import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, Integer> p1 = Pair.createPair(0, 3);
        Pair<Integer, Integer> p2 = Pair.createPair(1, 2);
        Pair<Integer, Integer> p3 = Pair.createPair(3, 1);
        PriorityQueue pairs = new PriorityQueue();
        pairs.push(0, 3);
        pairs.push(2, 1);
        pairs.printHeap();
        System.out.println("Map");
        pairs.printMap();
        // System.out.println("Before: ");
        // for (int j = 0; j < priorityQueue.heap.size(); j++) {
        // System.out.println("index: " + j + ", element: " +
        // priorityQueue.heap.get(j).getElem() + ", priority: "
        // + priorityQueue.heap.get(j).getPriority());
        // }
        // System.out.println(priorityQueue.isEmpty());
        // System.out.println("After: ");
        // for (int i = 0; i < priorityQueue.heap.size(); i++) {
        // System.out.println("index: " + i + ", element: " +
        // priorityQueue.heap.get(i).getElem() + ", priority: "
        // + priorityQueue.heap.get(i).getPriority());
        // }
    }
}
