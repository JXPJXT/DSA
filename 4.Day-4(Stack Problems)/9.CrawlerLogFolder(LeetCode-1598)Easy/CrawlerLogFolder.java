import java.util.Stack;

class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> paths_stack = new Stack<>();

        for (String log : logs) {
            if (log.equals("../")) {
                if (!paths_stack.isEmpty()) {
                    paths_stack.pop();
                }
            } else if (!log.equals("./")) {
                paths_stack.push(log);
            }
        }

        return paths_stack.size();
    }
    
    public static void main(String[] args) {
        CrawlerLogFolder solution = new CrawlerLogFolder();
        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        int result1 = solution.minOperations(logs1);
        System.out.println("Input: {\"d1/\", \"d2/\", \"../\", \"d21/\", \"./\"}");
        System.out.println("Minimum operations: " + result1);

        String[] logs2 = {"d1/", "../", "../", "../"};
        int result2 = solution.minOperations(logs2);
        System.out.println("\nInput: {\"d1/\", \"../\", \"../\", \"../\"}");
        System.out.println("Minimum operations: " + result2);

        String[] logs3 = {"./", "d1/", "../", "d2/", "./", "d3/", "../", "d4/"};
        int result3 = solution.minOperations(logs3);
        System.out.println("\nInput: {\"./\", \"d1/\", \"../\", \"d2/\", \"./\", \"d3/\", \"../\", \"d4/\"}");
        System.out.println("Minimum operations: " + result3);
    }
}
