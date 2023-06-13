import java.util.function.Consumer;

public class TreeNodeConsumer implements Consumer<TreeNode> {
    @Override
    public void accept(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.println("Node is null");
            return;
        }
        System.out.println("Node has value " + treeNode.value);
        System.out.println("Left child is " + (treeNode.left != null ? treeNode.left.value : "null"));
        System.out.println("Right child is " + (treeNode.right != null ? treeNode.right.value : "null"));
    }
}
