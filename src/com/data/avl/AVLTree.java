package com.data.avl;

public class AVLTree<K extends Comparable<K>, V> implements AVL {

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        // 代表当前节点的高度
        public int height;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.height = 1;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    // 获取当前node的高度
    public int getHeight(Node node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
    }

    // 获取当前节点的平衡因子
    private int getBalanceFactor(Node node) {
        if(node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // 判断是否是一颗平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {

        if(node == null) {
            return true;
        }
        // 如果当前节点的平衡因子大于1 说明这个节点不平衡了
        if(Math.abs(getBalanceFactor(node)) > 1) {
            return false;
        }
        // 在分别查看当前节点的左右孩子是否都符合平衡
        return isBalanced(node.left) && isBalanced(node.right);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;

        // 无论是添加了一个新的节点还是更新了一个已经存在的节点 都需要更新一下当前节点的高度
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        // 自平衡
        Node retNode = getAutoBalancedNode(node);

        return retNode == null ? node : retNode;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        // 向右旋转的过程
        x.right = y;
        y.left = T3;

        // 更新x和y的高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        // 左旋转的过程
        x.left = y;
        y.right = T2;
        // 更新x和y的高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        Node retNode;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            retNode = node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            retNode = node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode = rightNode;
            }
            // 待删除节点右子树为空的情况
            else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }
            else {
                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = remove(node.right, key);
                successor.left = node.left;

                node.left = node.right = null;

                retNode = successor;
            }

        }

        // 如果删除的是叶子节点直接返回Null不需要做后续的自平衡了
        if(retNode == null){
            return null;
        }

        // 无论是添加了一个新的节点还是更新了一个已经存在的节点 都需要更新一下当前节点的高度
        retNode.height = 1 + Math.max(getHeight(retNode.left),getHeight(retNode.right));

        // 自平衡
        Node resNode = getAutoBalancedNode(retNode);

        return resNode == null ? retNode : resNode;
    }

    // 将当前节点自平衡 返回一个新的平衡后的节点
    private Node getAutoBalancedNode(Node node) {

        // 计算当前节点的平衡因子 如果当前节点的平衡因子大于1 说明当前节点不平衡了
        int balanceFactor = getBalanceFactor(node);

        // 如果此时节点平衡因素大于1 并且左孩子的平衡因子是存在 说明需要右旋转
        // 插入的节点在不平衡节点的左侧的左侧
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // 如果插入的节点在不平衡节点的左侧的右侧
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // 插入的节点在不平衡节点的右侧的右侧
        // 如果此时节点的平衡因子小于-1 并且右孩子的平衡因子小于等于0  说明需要左旋转
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // 如果当前插入的节点在不平衡节点的右侧的左侧
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return null;
    }

}
