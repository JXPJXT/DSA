import java.util.Stack;

class SimplifyPath {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> st = new Stack<>();
        for (String comp : components) {
            if (comp.equals("") || comp.equals(".")) {
                continue;
            }
            if (comp.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(comp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, "/" + st.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath solution = new SimplifyPath();
        
        String path1 = "/home/";
        System.out.println("Input: \"" + path1 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path1) + "\"");

        String path2 = "/../";
        System.out.println("\nInput: \"" + path2 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path2) + "\"");

        String path3 = "/home//foo/";
        System.out.println("\nInput: \"" + path3 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path3) + "\"");
    }
}
