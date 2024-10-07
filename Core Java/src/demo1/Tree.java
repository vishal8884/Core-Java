package demo1;
class Node {
    Node left;
    Node right;
    Node root;
    int val;

    public Node(Node left,Node right,int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}


public class Tree {

    public static void main(String[] args) {
        Node node15 = new Node(null,null,15);
        Node node7 = new Node(null,null,7);
        Node node20 = new Node(node15,node7,20);

        Node node9 = new Node(null,null,9);
        Node root = new Node(node9,node20,-10);

        Tree tree = new Tree();
        int max = Integer.MIN_VALUE;
        int maxSum = tree.findMaxSum(root,max);
        System.out.println("maxSum :: "+maxSum);
    }
    /*
                   -10
               /         \
           9              20
                         /       \
                     15          7
 */
    public int findMaxSum(Node root,int max){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        int leftSum = findMaxSum(root.left,max);
        int rightSum = findMaxSum(root.right,max);

        if(leftSum + root.val + rightSum > max){
            max = leftSum + root.val+ rightSum;
        }
        if(rightSum > max){
            max = rightSum + root.val;
        }
        System.out.println("current root :: "+root.val+"    current max :: "+max+"   leftSum :: "+leftSum+"   rightSum :: "+rightSum);

        return max;
    }
}
