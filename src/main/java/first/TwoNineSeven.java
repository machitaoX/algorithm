package first;

/**
 * @author machitao
 * @date 2022/2/20
 * @description
 */
public class TwoNineSeven {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // String 中序遍历+前序遍历
            String inOrder = inOrder(root);
            String preOrder = preOrder(root);
            return inOrder + preOrder;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int length = data.length();
            String inOrder = data.substring(0, length / 2);
            String preOrder = data.substring(length / 2);
            return recover(inOrder, preOrder);

        }
        // 前序遍历
        private String preOrder(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if (root == null) {
                return sb.toString();
            }
            sb.append(root.val);
            sb.append(preOrder(root.left));
            sb.append(preOrder(root.right));
            return sb.toString();
        }

        // 中序遍历
        private String inOrder(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if (root == null) {
                return sb.toString();
            }
            sb.append(inOrder(root.left));
            sb.append(root.val);
            sb.append(inOrder(root.right));
            return sb.toString();
        }

        // 恢复
        private TreeNode recover(String inOrder, String preOrder) {
            if (preOrder == null || "".equals(preOrder)) {
                return null;
            }
            String firstNum = preOrder.substring(0, 1);
            if ("-".equals(firstNum)) {
                firstNum = preOrder.substring(0, 2);
            }
            int val = Integer.parseInt(firstNum);
            TreeNode root = new TreeNode(val);
            for (int i = 0; i < inOrder.length(); i++) {
                String readyToCheck = inOrder.substring(i, i + 1);
                boolean negative = false;
                if ("-".equals(readyToCheck)) {
                    readyToCheck = inOrder.substring(i, i + 2);
                    negative = true;
                }
                if (val == Integer.parseInt(readyToCheck)) {
                    if (negative) {
                        root.left = recover(inOrder.substring(0, i), preOrder.substring(2, 2 + i));
                        root.right = recover(inOrder.substring(i + 2), preOrder.substring(2 + i));
                    } else {
                        root.left = recover(inOrder.substring(0, i), preOrder.substring(1, 1 + i));
                        root.right = recover(inOrder.substring(i + 1), preOrder.substring(1 + i));
                    }

                    break;
                }
            }
            return root;
        }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
