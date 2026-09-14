import java.util.*;

public class TopKFrequentElements {


    // Step 1: Count the frequency of each element
    public Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num,0)+1);
        }

        return countMap;
    }

    // Step 2: Use PriorityQueue (heap) to find the k most frequent element
    public PriorityQueue<Integer> getHeap(Map<Integer, Integer> countMap, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));
        for (int key: countMap.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap;
    }

    // Step 3: Building the output list from the heap.
    public List<Integer> result(PriorityQueue<Integer> heap) {
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

        Map<Integer, Integer> countMap = topKFrequentElements.getCountMap(nums);
        PriorityQueue<Integer> heap = topKFrequentElements.getHeap(countMap, k);
        System.out.println(topKFrequentElements.result(heap));
    }
}
