package practico2punto1;

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public Tree() {
		this.root = null;
	}

	public void add(T value) {
		if (this.root == null)
			this.root = new TreeNode<T>(value);
		else
			this.add(this.root, value);
	}

	public boolean delete(Integer value) {
		return true;
	}

	private boolean delete(T elem, TreeNode<T> node) {
		if (node == null)
			return false;
		if (node.getValue().compareTo(elem) == 0) {
			if (node.getLeft() == null && node.getRight() == null) { // Caso 1: Nodo hoja
				node = null; // Simplemente borro el nodo
			} else if (node.getLeft() != null && node.getRight() == null) { // Caso 2: Solo tiene hijo izquierdo
				node = node.getLeft();
			} else if (node.getLeft() == null && node.getRight() != null) { // Caso 2: Solo tiene hijo derecho
				node = node.getRight();
			} else { // Caso 3: Tiene ambos hijos
				TreeNode<T> temp = getMax(node.getLeft()); // Encuentro el maximo del subarbol izquierdo (El mayor de
															// los menores, NMDSI)
				node.setValue(temp.getValue()); // Reemplazo el valor del nodo a borrar por el maximo del subarbol
												// izquierdo
				delete(temp.getValue(), node.getLeft()); // Borro el maximo del subarbol izquierdo
			}
			return true;
		} else if (node.getValue().compareTo(elem) > 0)
			return delete(elem, node.getLeft());
		else
			return delete(elem, node.getRight());
	}

	private TreeNode<T> getMax(TreeNode<T> node) {
		if (node.getRight() == null)
			return node;
		return getMax(node.getRight());
	}

	public boolean hasElem(T value) {
		return this.hasElement(this.root, value);

	}

	private boolean hasElement(TreeNode<T> actual, T value) {
		if (actual == null) {
			return false;
		}
		if (actual.getValue().compareTo(value) == 0) {
			return true;
		}
		if (actual.getValue().compareTo(value) > 0) {
			return hasElement(actual.getLeft(), value);
		} else {
			return hasElement(actual.getRight(), value);
		}

	}

	private void add(TreeNode<T> current, T value) {
		if (current.getValue().compareTo(value) > 0) {
			if (current.getLeft() == null) {
				TreeNode<T> temp = new TreeNode<T>(value);
				current.setLeft(temp);
			} else {
				add(current.getLeft(), value);
			}
		} else if (current.getValue().compareTo(value) < 0) {
			if (current.getRight() == null) {
				TreeNode<T> temp = new TreeNode<T>(value);
				current.setRight(temp);
			} else {
				add(current.getRight(), value);
			}
		}
	}

	public TreeNode<T> getRootNode() {
		return this.root;
	}

	public boolean isEmpty() {
		return this.root.getValue() == null;
	}

	public void imprimirPreOrden(TreeNode<T> nodo) {
		if (nodo == null)
			return;
		System.out.print(nodo.getValue() + " ");
		imprimirPreOrden(nodo.getLeft());
		imprimirPreOrden(nodo.getRight());
	}
	public int getHeight(){
		return this.getHeightTree(this.root);
	}
	
	private int getHeightTree(TreeNode<T> actual) {
		if (actual == null) {
			return 0;
		}
		if (actual.getLeft() == null && actual.getRight() == null) {
			return 1; // Si es una hoja, su altura es 1 (ella sola)
		}
	
		// Si tiene al menos un hijo, me fijo cuál rama es más profunda
		int izquierda = getHeightTree(actual.getLeft());
		int derecha = getHeightTree(actual.getRight());
	
		return Math.max(izquierda, derecha) + 1;
	}
	
}
