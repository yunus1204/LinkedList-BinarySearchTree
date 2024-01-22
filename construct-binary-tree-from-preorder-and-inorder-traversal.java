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
    HashMap<Integer,Integer> map=new HashMap<>();
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int s=0;
        int l=preorder.length-1;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=formTree(preorder,s,l);
        return root;
    }
    public TreeNode formTree(int preorder[],int s,int l)
    {
        if(s>l)
        {
            return null;
        }
        TreeNode root=new TreeNode(preorder[index]);
        int m=map.get(preorder[index]);
        index++;
        root.left=formTree(preorder,s,m-1);
        root.right=formTree(preorder,m+1,l);
        return root;
    }
}
