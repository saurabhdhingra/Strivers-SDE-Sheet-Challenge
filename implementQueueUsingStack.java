import java.util.Stack;

class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        System.out.println("The element being pushed is "+ x);
        input.push(x);    
    }
    
    public int pop() {
        if(output.empty()){
            while(input.empty() == false){
                output.push(input.peek());
                input.pop();
            }
        }

        int x = output.peek();
        output.pop();
        return x;
    }
    
    public int peek() {
        if(output.empty()){
            while(input.empty() == false){
                output.push(input.peek());
                input.pop();
            }
        }
         return output.peek();
    }
    
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

class MyQueue2 {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    public MyQueue2() {
        
    }
    
    public void push(int x) {
        while(input.empty()==false){
            output.push(input.peek());
            input.pop();
        }

        System.out.println("The element pushed is "+x);
        input.push(x);

        while(output.empty()==false){
            input.push(output.peek());
            output.pop();
        }
    }
    
    public int pop() {
        if(input.empty()){
            System.out.println("Stack is empty");
        }

        int val = input.peek();
        input.pop();
        return val;
    }
    
    public int peek() {
        if(input.empty()){
            System.out.println("Stack is empty");
        }

        return input.peek();
    }
    
    public boolean empty() {
        return input.empty();
    }
}
