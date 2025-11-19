import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    private static int bestSolution(int[] arr) {
        int n = arr.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = -1;
        
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int popped = stack.pop();
                int current = arr[popped]*(stack.isEmpty() ? i : (i-stack.peek()-1));
                max = Math.max(current,max);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int popped = stack.pop();
            int current = arr[popped]*(stack.isEmpty() ? n : (n-stack.peek()-1));
            max = Math.max(current,max);
        }
        
        return max;  
    }
    
    public int maximalRectangle(char[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int max = 0;
        ArrayDeque<Integer>[] stacks = (ArrayDeque<Integer>[]) Array.newInstance(ArrayDeque.class, M);
        
        for(int i=0;i<M;i++) {
            stacks[i] = new ArrayDeque<Integer>();
            int count = 0;
            for(int j=0;j<N;j++) {
                if(matrix[j][i] == '0' && count > 0) {
                    stacks[i].push(count);
                    count = 0;
                } else if(matrix[j][i] == '1'){
                    count++;
                }
            }
            
            if(count > 0)
                stacks[i].push(count);
        }
        
        
        for(int i=N-1;i>=0;i--) {
            int[] arr = new int[M];
            for(int j=0;j<M;j++) { 
                if(matrix[i][j] != '0') {
                    int popped = stacks[j].pop();
                    arr[j] = popped;
                    if(i > 0 && matrix[i-1][j] == '1')
                        stacks[j].push(popped-1);
                }
            }
            max = Math.max(max,bestSolution(arr));
        }

        
        return max;
    }
}