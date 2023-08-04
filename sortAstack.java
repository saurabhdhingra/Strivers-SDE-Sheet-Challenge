import java.util.*;
import java.io.*;

public class sortAstack {

}

public class Solution {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> t = new Stack<>();
        while (!stack.isEmpty()) {
            int item = stack.pop();
            while (!t.isEmpty() && t.peek() < item)
                stack.push(t.pop());
            t.push(item);
        }
        while (!t.isEmpty())
            stack.push(t.pop());
    }

}