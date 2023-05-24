/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

/**
 *
 * @author maverick
 */
public class Nodo {
    //Un array de enteros que almacena las claves(valores) asociados con este nodo
    private int[] clave;
    //Un array de nodos que alamacena los hijos del nodo actual
    private Nodo[] child;
    //Un puntero al nodo padre del nodo actual
    private Nodo padre;
    //Un puntero al siguiente nodo en el mismo nivel de la jerarquia del arbol 
    private Nodo next;
    //Un entero que indica el numero de claves actuales almacendas en este nodo
    private int numKeys;
    //Un booleano que indica si este nodo es una hoja en el arbol B+
    private boolean isLeaf;

    public static final int n = 3;

    public Nodo(boolean isLeaf) {
        clave = new int[2 * n];
        child = new Nodo[2 * n + 1];
        numKeys = 0;
        padre = null;
        next = null;
        this.isLeaf = isLeaf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numKeys; i++) {
            sb.append(clave[i]);

            if (i != numKeys - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        if (!isLeaf) {
            sb.append("{");
            for (int i = 0; i <= numKeys; i++) {
                sb.append(child[i]);
   
                if (i != numKeys) {
                    break;
                }
            }
            sb.append("}");
        }

        if (next != null) {
            sb.append(" -> ");
           sb.append(next.toString());
        }

        return sb.toString();
    }

    public int getKey(int index) {
        return clave[index];
    }

    public void setKey(int index, int value) {
        clave[index] = value;
    }

    public Nodo getChild(int index) {
        return child[index];
    }

    public void setChild(int index, Nodo child) {
        this.child[index] = child;
    }

    public Nodo getParent() {
        return padre;
    }

    public void setParent(Nodo parent) {
        this.padre = parent;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public int getNumKeys() {
        return numKeys;
    }

    public void setNumKeys(int numKeys) {
        this.numKeys = numKeys;
    }

    public boolean isLeaf() {
        return isLeaf;
    }
}
