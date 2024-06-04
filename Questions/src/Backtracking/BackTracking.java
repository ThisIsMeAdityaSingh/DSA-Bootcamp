package Backtracking;

public class BackTracking {
    public static void main(String[] args){

    }

    /**
     * Say you are in a recursion where same situation could be executed again and again.
     * This would lead to a stack overflow, as recursion call is never ending.
     *
     * This generally happens when our code is not aware that this path has been visited.
     * So, to stop that we add a check, that our code can use to see if that path was executed or not.
     *
     * Now, it is also important for us to remove that check everytime our code is finished that path.
     * so, we just flip that check, every time our recursion returns something.
     * More like, cleaning up after living in a room so, it can be used by other.
     *
     * This cleaning up after a return in recursion is called. BACK TRACKING.
     */
    static void allPaths(){}
}
