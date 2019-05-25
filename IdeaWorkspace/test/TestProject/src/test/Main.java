package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        boolean b = false;
        for (; !b; ) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            b = find(treeNodes, treeNode, 2, 1);
            System.out.println(number);
            System.out.println(b);
            for (TreeNode node : treeNodes) {
                System.out.print(node.getNum());
            }
            System.out.println();
            number = 0;
            System.out.println("----------");
        }
    }

    static int number = 0;

    private static boolean find(List<TreeNode> nodeNum, TreeNode node, long n, long k) {
        TreeNode node1 = null;
        if (k != nodeNum.size()) {
            //jiajian
            jiajian(node1, node);
            nodeNum.add(node1);
            boolean b = find(nodeNum, node1, n, k);
            if (b) {
                return b;
            }
        } else {
            if (n == number) {
                return true;
            }
        }
        return false;
    }

    static void jiajian(TreeNode node1, TreeNode node) {
        //做计算
        long l1 = Math.round(Math.random());
        if (l1 == 0) {
            long l2 = Math.round(Math.random());
            node1 = node.getLetfNode();
            int num = node1.getNum();
            if (l2 == 0) {
                number += num;
            } else {
                number -= num;
            }
        } else {
            long l2 = Math.round(Math.random());
            node1 = node.getRightNode();
            int num = node1.getNum();
            if (l2 == 0) {
                number += num;
            } else {
                number -= num;
            }
        }
    }
}


class TreeNode {

    private int num;
    private TreeNode letfNode;
    private TreeNode rightNode;

    public int getNum() {
        return num;
    }

    public TreeNode(int num) {
        if (num > 10000) {
            return;
        }
        this.num = num;
        letfNode = new TreeNode(2 * num);
        rightNode = new TreeNode(2 * num + 1);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "num=" + num +
                ", letfNode=" + letfNode +
                ", rightNode=" + rightNode +
                '}';
    }

    public TreeNode() {
    }

    public void setNum(int num) {
        this.num = num;
    }

    public TreeNode getLetfNode() {
        return letfNode;
    }

    public void setLetfNode(TreeNode letfNode) {
        this.letfNode = letfNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
