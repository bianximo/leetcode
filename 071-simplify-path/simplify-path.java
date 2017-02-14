// Given an absolute path for a file (Unix-style), simplify it.
//
// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
//
//
// click to show corner cases.
//
// Corner Cases:
//
//
//
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".


public class Solution {
   public String simplifyPath(String path) {
        Deque<String>stack = new LinkedList<>();
        Set<String>skip = new HashSet<>(Arrays.asList("",".",".."));
        for(String now:path.split("/")){
        	if(now.equals("..")&&!stack.isEmpty())stack.pop();
        	else if(!skip.contains(now))stack.push(now);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        	sb.append("/").append(stack.pollLast());
        }
        return sb.length()>0?sb.toString():"/";
    }
}
