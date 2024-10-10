import java.util.*;

public class LargestRectangle {
    private int[] prevSmallElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            while (s.peek() != -1 && arr[s.peek()] >= curr) {
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i); // Push index instead of current value
        }
        return ans;
    }

    private int[] nextSmallElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(-1);
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            while (s.peek() != -1 && arr[s.peek()] >= curr) {
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i); // Push index instead of current value
        }
        return ans;
    }

    private int largest(int[] arr) {
        int n = arr.length;
        int[] prev = prevSmallElement(arr, n);
        int[] next = nextSmallElement(arr, n);
        int area = 0;
        for (int i = 0; i < n; i++) {
            int length = arr[i];
            if (next[i] == -1) {
                next[i] = n;
            }
            int width = next[i] - prev[i] - 1;
            int newArea = length * width;
            area = Math.max(area, newArea);
        }
        return area;
    }

    public static void main(String[] args) {
        LargestRectangle sol = new LargestRectangle();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + sol.largest(heights));
    }
}
