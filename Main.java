import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        PriorityQueue pairs = new PriorityQueue();
        pairs.push(0, 3);
        pairs.push(2, 1);
        pairs.push(3, 4);
        pairs.push(9, 1);

        System.out.println(pairs.heap.size());
        pairs.pop();
        System.out.println(pairs.heap.size());
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
