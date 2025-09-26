class Solution{
public int[] maxSlidingWindow(int[] a, int k) {
    int[] r = new int[a.length - k + 1];
    Deque<Integer> d = new LinkedList<>();
    for (int i = 0; i < k - 1; i++) {
        if (d.isEmpty()) {
            d.addLast(i);
        } else {
            while (!d.isEmpty() && a[d.peekLast()] < a[i])
                d.removeLast();
            d.addLast(i);
        }
    }
    int x = 0;
    for (int i = k - 1; i < a.length; i++) {
        while (!d.isEmpty() && a[d.peekLast()] < a[i])
            d.removeLast();
        d.addLast(i);
        if (d.peekFirst() <= i - k) {
            d.removeFirst();
        }
        r[x++] = a[d.peekFirst()];
    }
    return r;
}
}
/*
TC = O(n)
SC = O(k) (excluding output array, which is always required).
*/
