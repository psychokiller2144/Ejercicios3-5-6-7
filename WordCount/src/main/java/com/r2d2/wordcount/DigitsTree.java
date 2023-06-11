package com.r2d2.wordcount;

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class DigitsTree {

    private Node root;
    private static int start = 0; //variable static para apuntar al índice inicial de la cadena

    public DigitsTree() {
    }

    public DigitsTree(String arbol) {
        this.root = constructTree(arbol);
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private Node constructTree(String s) {

        // Verificamos si es una cadena null o vacia
        // y returnamos null;
        if (s.length() == 0 || s == null) {
            return null;
        }

        if (start >= s.length()) {
            return null;
        }

        //variable boolean para verifica numeros negativos
        boolean neg = false;

        //condicion para verificar numeros negativos
        if (s.charAt(start) == '-') {
            neg = true;
            start++;
        }

        //Este bucle básicamente construye el número a partir de los dígitos continuos.
        int num = 0;
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            int digit = Character.getNumericValue(s.charAt(start));
            num = num * 10 + digit;
            start++;
        }

        if (neg) {
            num = -num;
        }

        //creamos el nodo raiz (root) de nuestro arbol, con data = num en un principio
        Node node = new Node(num);

        if (start >= s.length()) {
            return node;
        }

        //Verificamos si hay parentesis abiertos y agregamos los datos al subárbol izquierdo recursivamente
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.left = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }

        //Verificamos si hay parentesis abiertos y agregamos los datos al subárbol derecho recursivamente
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.right = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }
        return node;
    }

    public void printTree(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public void printTree() {
        printTree(this.root);
    }

    public int getHeight(Node root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = 0;
        if (root.left != null) {
            left = getHeight(root.left);
        }

        int right = 0;
        if (root.right != null) {
            right = getHeight(root.right);
        }

        return (Math.max(left, right) + 1);
    }

    public int getHeight() {
        return getHeight(this.root);
    }

    public void calculateLevelSum(Node node, int level, int sum[]) {
        if (node == null) {
            return;
        }

        //Agregamos los datos del nodo actual a la suma del nivel del nodo actual
        sum[level] += node.data;

        //Llamados recursivos para los subarboles izquierdo y derecho
        calculateLevelSum(node.left, level + 1, sum);
        calculateLevelSum(node.right, level + 1, sum);
    }

    /**
     *
     * Esta es la funcion que requiere el ejercicio 3, todo lo demas es lo
     * necesario para construir el arbol y a partir de este, usar el metodo
     * sumaHastaNivel()
     */
    public int sumaHastaNivel(int nivel) {

        //contamos los niveles en el arbol
        int levels = getHeight() + 1;

        //para guardar la suma de cada nivel
        int sum[] = new int[levels];
        calculateLevelSum(root, 0, sum);

        //sumamos los valores de cada nivel, hasta el nivel dado
        int sumaNivel = 0;
        for (int i = 0; i < nivel; i++) {
            sumaNivel += sum[i];
        }

        return sumaNivel;
    }

    public static void main(String[] args) {

        //4(2(3)(1))(6(5)) -> otro ejemplo de arbol
        //1(2(3)(4))(5(6)(7(8)(9(0)(1)))) -> ejemplo en el word
        DigitsTree tree = new DigitsTree("1(2(3)(4))(5(6)(7(8)(9(0)(1))))");

        //tree.printTree();
        System.out.println("Suma = " + tree.sumaHastaNivel(4));

    }
}
