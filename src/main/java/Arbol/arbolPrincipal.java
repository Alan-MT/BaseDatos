/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

/**
 *
 * @author maverick
 */
public class arbolPrincipal {

    private Nodo root;
    //Definir el tamanio maximo de un nodo
    private static final int n = 10;

    public arbolPrincipal() {
        //se le llama a nodo diciendole que es una hoja
        root = new Nodo(true);
    }

    public void insertar(int value) {
        Nodo HojaNodo = encontraHoja(value);
        try {
            hojaInsertar(HojaNodo, value);
        } catch (DuplicateValueException e) {
            System.out.println("ERROR: "+e.getMessage());
        }

    }
    //encuentra el nodo hoja donde el valor debería ser insertado
    public Nodo encontraHoja(int value) {
        Nodo actual = root;
        while (!actual.isLeaf()) {
            int i = 0;
            while (i < actual.getNumKeys() && value > actual.getKey(i)) {
                i++;
            }
            actual = actual.getChild(i);
        }
        return actual;
    }
    // insertar el valor en el nodo hoja
    public void hojaInsertar(Nodo NodoHoja, int valor) throws DuplicateValueException {
        int index = 0;
        while (index < NodoHoja.getNumKeys() && valor > NodoHoja.getKey(index)) {
            index++;
        }
        if (index < NodoHoja.getNumKeys() && valor == NodoHoja.getKey(index)) {
            throw new DuplicateValueException("El valor "+ valor+" ya existe en el arbol");
        }
        for (int i = NodoHoja.getNumKeys(); i > index; i--) {
            NodoHoja.setKey(i, NodoHoja.getKey(i - 1));
        }
        NodoHoja.setKey(index, valor);
        NodoHoja.setNumKeys(NodoHoja.getNumKeys() + 1);
        //Si el nodo hoja está lleno después de la inserción
        if (NodoHoja.getNumKeys() == 2 * Nodo.n) {
            splitHoja(NodoHoja);
        }
    }

    public void splitHoja(Nodo nuevaHOja) {
        Nodo newLeafNode = new Nodo(true);
        //Se determina el índice del medio en el nodo hoja original.
        int middleIndex = nuevaHOja.getNumKeys() / 2;
        int newLeafIndex = 0;
        for (int i = middleIndex; i < nuevaHOja.getNumKeys(); i++) {
            //Los elementos a partir del índice medio se copian en el nuevo nodo hoja.
            newLeafNode.setKey(newLeafIndex++, nuevaHOja.getKey(i));
        }
        newLeafNode.setNumKeys(newLeafIndex);
        //El número de claves en el nuevo nodo hoja se establece en la cantidad de claves a partir del índice medio.
        nuevaHOja.setNumKeys(middleIndex);
        //Se establece el puntero al siguiente nodo hoja del nuevo nodo hoja al siguiente nodo hoja del nodo original.
        newLeafNode.setNext(nuevaHOja.getNext());
        //El puntero al siguiente nodo hoja del nodo original se actualiza para apuntar al nuevo nodo hoja.
        nuevaHOja.setNext(newLeafNode);

/*         Si el nodo hoja dividido es la raíz del árbol, se crea
            una nueva raíz y se establecen los punteros de los nodos 
            hoja divididos como hijos de la nueva raíz.*/
        if (nuevaHOja == root) {
            Nodo newRoot = new Nodo(false);
            newRoot.setKey(0, newLeafNode.getKey(0));
            newRoot.setChild(0, nuevaHOja);
            newRoot.setChild(1, newLeafNode);
            newRoot.setNumKeys(1);
            nuevaHOja.setParent(newRoot);
            newLeafNode.setParent(newRoot);
            root = newRoot;
        } else {
            /*Si el nodo hoja dividido no es la raíz del árbol, 
            se busca el padre del nodo hoja original y se inserta 
            la clave del primer elemento del nuevo nodo hoja en el padre. 
            Si el padre del nodo hoja original está lleno después de la inserción, 
            el nodo padre también se divide en dos nodos internos. */
            Nodo parent = nuevaHOja.getParent();
            int index = 0;
            while (parent.getChild(index) != nuevaHOja) {
                index++;
            }
            for (int i = parent.getNumKeys(); i > index; i--) {
                parent.setChild(i + 1, parent.getChild(i));
                parent.setKey(i, parent.getKey(i - 1));
            }
            parent.setKey(index, newLeafNode.getKey(0));
            parent.setChild(index + 1, newLeafNode);
            parent.setNumKeys(parent.getNumKeys() + 1);
            newLeafNode.setParent(parent);
            if (parent.getNumKeys() == 2 * Nodo.n) {
                splitInternoNodo(parent);
            }
        }
    }

    public int findHIjo(Nodo parent, Nodo child) {
        for (int i = 0; i <= parent.getNumKeys(); i++) {
            if (parent.getChild(i) == child) {
                return i;
            }
        }
        return -1;
    }

    public boolean look(int value){
        Nodo leafNode = encontraHoja(value);
        for (int i = 0; i < leafNode.getNumKeys(); i++) {
                if (leafNode.getKey(i) == value) {
                    return true;
                }
        }
        return false;
    }
    public void splitInternoNodo(Nodo internalNode) {
        // Create a new internal node.
        Nodo newInternalNode = new Nodo(false);
        // Copy the second half of the keys and pointers from the original internal node to the new internal node.
        int middleIndex = internalNode.getNumKeys() / 2;
        int newInternalIndex = 0;
        for (int i = middleIndex + 1; i < internalNode.getNumKeys(); i++) {
        newInternalNode.setKey(newInternalIndex, internalNode.getKey(i));
        newInternalNode.setChild(newInternalIndex, internalNode.getChild(i));
        internalNode.setChild(i, null);
        newInternalIndex++;
        }
        newInternalNode.setChild(newInternalIndex, internalNode.getChild(internalNode.getNumKeys()));
        internalNode.setChild(internalNode.getNumKeys(), null);
        newInternalNode.setNumKeys(newInternalIndex);
        internalNode.setNumKeys(middleIndex);

        /* Si el nodo interno dividido es la raíz del árbol, 
se crea una nueva raíz y los punteros del nodo interno 
nuevo nodo interno se establecen como hijos de la nueva raíz. */
if (internalNode == root) {
    Nodo newRoot = new Nodo(false);
    newRoot.setKey(0, internalNode.getKey(middleIndex));
    newRoot.setChild(0, internalNode);
    newRoot.setChild(1, newInternalNode);
    newRoot.setNumKeys(1);
    internalNode.setParent(newRoot);
    newInternalNode.setParent(newRoot);
    root = newRoot;
} else {
/* Si el nodo interno dividido no es la raíz del árbol, 
    la clave del elemento medio del nodo interno original 
    se inserta en el nodo padre del nodo interno original. 
    Si el nodo padre del nodo interno original está lleno 
    después de la inserción, el nodo padre también se divide en dos nodos internos. */
    Nodo parent = internalNode.getParent();
    int index = 0;
    while (parent.getChild(index) != internalNode) {
        index++;
    }
    for (int i = parent.getNumKeys(); i > index; i--) {
        parent.setChild(i + 1, parent.getChild(i));
        parent.setKey(i, parent.getKey(i - 1));
    }
    parent.setKey(index, internalNode.getKey(middleIndex));
    parent.setChild(index + 1, newInternalNode);
    parent.setNumKeys(parent.getNumKeys() + 1);
    newInternalNode.setParent(parent);
    if (parent.getNumKeys() == 2 * Nodo.n) {
        splitInternoNodo(parent);
    }
}
}
    @Override
    public String toString() {
        return root.toString();
    }
    public void delete(int value) {
        Nodo leafNode = encontraHoja(value);
    
        // Buscar la posición del valor en el nodo hoja
        int index = 0;
        while (index < leafNode.getNumKeys() && value > leafNode.getKey(index)) {
            index++;
        }
    
        // Verificar si el valor no está presente en el árbol
        if (index == leafNode.getNumKeys() || value != leafNode.getKey(index)) {
            System.out.println("El valor " + value + " no existe en el árbol.");
            return;
        }
    
        // Eliminar el valor del nodo hoja
        for (int i = index; i < leafNode.getNumKeys() - 1; i++) {
            leafNode.setKey(i, leafNode.getKey(i + 1));
        }
        leafNode.setNumKeys(leafNode.getNumKeys() - 1);
    
        // Verificar si el nodo hoja está por debajo del factor de ocupación mínimo
        if (leafNode.getNumKeys() < Nodo.n) {
            Nodo parent = leafNode.getParent();
            int leafIndex = findHIjo(parent, leafNode);
    
            // Intentar pedir prestado una clave de los hermanos
            if (leafIndex > 0 && parent.getChild(leafIndex - 1).getNumKeys() > Nodo.n) {
                Nodo leftSibling = parent.getChild(leafIndex - 1);
                PrestarHermanoIz(leafNode, leftSibling, parent, leafIndex);
            } else if (leafIndex < parent.getNumKeys() && parent.getChild(leafIndex + 1).getNumKeys() > Nodo.n) {
                Nodo rightSibling = parent.getChild(leafIndex + 1);
                borrowFromRightSibling(leafNode, rightSibling, parent, leafIndex);
            } else {
                // Fusionar con un hermano si no se puede pedir prestado una clave
                if (leafIndex > 0) {
                    Nodo leftSibling = parent.getChild(leafIndex - 1);
                    mergeWithLeftSibling(leafNode, leftSibling, parent, leafIndex - 1);
                    leafNode = leftSibling; // Actualizar el nodo hoja actual
                } else {
                    Nodo rightSibling = parent.getChild(leafIndex + 1);
                    mergeWithRightSibling(leafNode, rightSibling, parent, leafIndex);
                }
            }
        }
    }
    

  /*  public void deleteFromLeaf(Nodo leafNode, int value) throws ValueNotFoundException {
        int index = 0;
        while (index < leafNode.getNumKeys() && value > leafNode.getKey(index)) {
            index++;
        }
        if (index >= leafNode.getNumKeys() || value != leafNode.getKey(index)) {
            throw new ValueNotFoundException("El valor " + value + " no se encuentra en el árbol");
        }
        for (int i = index; i < leafNode.getNumKeys() - 1; i++) {
            leafNode.setKey(i, leafNode.getKey(i + 1));
        }
        leafNode.setNumKeys(leafNode.getNumKeys() - 1);
        // Si el nodo hoja no es la raíz y tiene menos de n claves después de la eliminación, se realiza el proceso de préstamo o fusión.
        if (leafNode != root && leafNode.getNumKeys() < n) {
            borrowOrMergeLeafNode(leafNode);
        }
    }*/

   /* public void borrowOrMergeLeafNode(Nodo leafNode) {
        Nodo parent = leafNode.getParent();
        int leafIndex = 0;
        while (parent.getChild(leafIndex) != leafNode) {
            leafIndex++;
        }
        if (leafIndex > 0 && parent.getChild(leafIndex - 1).getNumKeys() > n) {
            // Prestar una clave del hermano izquierdo
            Nodo leftSibling = parent.getChild(leafIndex - 1);
            borrowFromLeftSibling(leafNode, leftSibling, parent, leafIndex);
        } else if (leafIndex < parent.getNumKeys() && parent.getChild(leafIndex + 1).getNumKeys() > n) {
            // Prestar una clave del hermano derecho
            Nodo rightSibling = parent.getChild(leafIndex + 1);
            borrowFromRightSibling(leafNode, rightSibling, parent, leafIndex);
        } else if (leafIndex > 0) {
            // Fusionar con el hermano izquierdo
            Nodo leftSibling = parent.getChild(leafIndex - 1);
            mergeWithLeftSibling(leafNode, leftSibling, parent, leafIndex - 1);
        } else {
            // Fusionar con el hermano derecho
            Nodo rightSibling = parent.getChild(leafIndex + 1);
            mergeWithRightSibling(leafNode, rightSibling, parent, leafIndex);
        }
    }*/

    public void PrestarHermanoIz(Nodo leafNode, Nodo leftSibling, Nodo parent, int leafIndex) {
        // Prestar la clave más grande del hermano izquierdo
        int borrowedKey = leftSibling.getKey(leftSibling.getNumKeys() - 1);
        leftSibling.setNumKeys(leftSibling.getNumKeys() - 1);
    
        // Insertar la clave prestada en el nodo hoja actual
        for (int i = leafNode.getNumKeys(); i > 0; i--) {
            leafNode.setKey(i, leafNode.getKey(i - 1));
        }
        leafNode.setKey(0, borrowedKey);
        leafNode.setNumKeys(leafNode.getNumKeys() + 1);
    
        // Actualizar la clave en el padre
        parent.setKey(leafIndex - 1, leafNode.getKey(0));
    }
    
    public void borrowFromRightSibling(Nodo leafNode, Nodo rightSibling, Nodo parent, int leafIndex) {
        // Prestar la clave más pequeña del hermano derecho
        int borrowedKey = rightSibling.getKey(0);
    
        // Mover las claves en el hermano derecho hacia la izquierda
        for (int i = 0; i < rightSibling.getNumKeys() - 1; i++) {
            rightSibling.setKey(i, rightSibling.getKey(i + 1));
        }
        rightSibling.setNumKeys(rightSibling.getNumKeys() - 1);
    
        // Insertar la clave prestada en el nodo hoja actual
        leafNode.setKey(leafNode.getNumKeys(), borrowedKey);
        leafNode.setNumKeys(leafNode.getNumKeys() + 1);
    
        // Actualizar la clave en el padre
        parent.setKey(leafIndex, rightSibling.getKey(0));
    }
    
    public void mergeWithLeftSibling(Nodo leafNode, Nodo leftSibling, Nodo parent, int leftIndex) {
        // Mover todas las claves del nodo hoja actual al hermano izquierdo
        for (int i = 0; i < leafNode.getNumKeys(); i++) {
            leftSibling.setKey(leftSibling.getNumKeys() + i, leafNode.getKey(i));
        }
        leftSibling.setNumKeys(leftSibling.getNumKeys() + leafNode.getNumKeys());
    
        // Actualizar los punteros de siguiente nodo hoja
        leftSibling.setNext(leafNode.getNext());
    
        // Eliminar el nodo hoja actual
        parent.setChild(leftIndex + 1, null);
        parent.setKey(leftIndex, parent.getKey(leftIndex + 1));
        parent.setNumKeys(parent.getNumKeys() - 1);
    }
    
    public void mergeWithRightSibling(Nodo leafNode, Nodo rightSibling, Nodo parent, int leafIndex) {
        // Mover todas las claves del hermano derecho al nodo hoja actual
        for (int i = 0; i < rightSibling.getNumKeys(); i++) {
            leafNode.setKey(leafNode.getNumKeys() + i, rightSibling.getKey(i));
        }
        leafNode.setNumKeys(leafNode.getNumKeys() + rightSibling.getNumKeys());
    
        // Actualizar los punteros de siguiente nodo hoja
        leafNode.setNext(rightSibling.getNext());
    
        // Eliminar el hermano derecho
        parent.setChild(leafIndex + 1, null);
        parent.setKey(leafIndex, parent.getKey(leafIndex + 1));
        parent.setNumKeys(parent.getNumKeys() - 1);
    }
    


}

   