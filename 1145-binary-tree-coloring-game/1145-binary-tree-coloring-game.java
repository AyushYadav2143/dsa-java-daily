/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode findNode(TreeNode root,int x){
        if(root==null)return null;
        if(root.val==x)return root;
        TreeNode left=findNode(root.left,x);
        if(left!=null)return left;
        return findNode(root.right,x);
    }
    private int countNode(TreeNode root){
        if(root==null)return 0;
        return 1+countNode(root.left)+countNode(root.right);
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node=findNode(root,x);
        int leftSize=countNode(node.left);
        int rightSize=countNode(node.right);
        int parentSize=n-leftSize-rightSize-1;
        return leftSize>n/2 || rightSize>n/2 || parentSize>n/2;
    }
}