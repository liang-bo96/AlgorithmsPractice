package com.Algorithm.Tree;

import com.Algorithm.BFS.TreeNode;

/**
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：该题目与 538:?https://leetcode-cn.com/problems/convert-bst-to-greater-tree/? 相同
 *
 * ?
 *
 * 示例 1：
 *
 *
 *
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N538_ConvertToBiggerTree {
    int sum = 0;
    //二叉搜索树逆序遍历 -> 从大到小 ->依次累加根节点数值后更新当前节点数值
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
