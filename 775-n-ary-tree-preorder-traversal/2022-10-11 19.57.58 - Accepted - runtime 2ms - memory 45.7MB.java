/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void solution(Node node, List<Integer> list) {
        if(node == null) return;
        
        list.add(node.val);
        
        for(Node child : node.children) {
            solution(child, list);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        
        solution(root, result);
        
        return result;
    }
}