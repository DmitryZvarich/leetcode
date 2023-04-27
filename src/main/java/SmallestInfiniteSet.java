import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;

class SmallestInfiniteSet {
    private final LinkedList<Integer> list;
    private int first;

    public SmallestInfiniteSet() {
        list = new LinkedList<>();
        first = 1;
    }

    public int popSmallest() {
        int res;
        for (res = first; res < 1001; res++) {
            if (list.contains(res)){
                continue;
            }
            break;
        }

        first = res + 1;
        list.add(res);
        return res;
    }

    public void addBack(int num) {
        list.remove((Integer) num);
        first = Math.min(num, first);
    }
}