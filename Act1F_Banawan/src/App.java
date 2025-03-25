class BST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] values = {10, 5, 15, 3, 8, 20};
        for (int val : values) {
            tree.insert(val);
        }

        System.out.println("In-Order Traversal:");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Pre-Order Traversal:");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Post-Order Traversal:");
        tree.postOrder(tree.root);
        System.out.println();
    }
}
