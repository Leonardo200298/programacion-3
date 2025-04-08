package practico2punto1;

public class Tree {

	private TreeNode root;

	public Tree() {
		this.root = null;
	}

	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root, value);
	}
	public boolean hasElem(Integer value){
		return this.hasElement(this.root, value);

	}
	private boolean hasElement(TreeNode actual, Integer value){
		if (actual == null) {
			return false;
		}
		if (actual.getValue().equals(value)) {
			return true;
		}
		if (actual.getValue() < value) {
			return hasElement(actual.getLeft(), value);
		}else{
			return hasElement(actual.getRight(), value);
		}


	}
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(), value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(), value);
			}
		}
	}

	public Integer getRoot() {
		if (this.isEmpty()) {

			return -1;
		}
		return this.root.getValue();
	}

	public TreeNode getRootNode() {
		return this.root;
	}
	

	public boolean isEmpty() {
		return this.root.getValue() == null;
	}

	public void imprimirPreOrden(TreeNode nodo) {
		if (nodo == null)
			return;
		System.out.print(nodo.getValue() + " ");
		imprimirPreOrden(nodo.getLeft());
		imprimirPreOrden(nodo.getRight());
	}
}
