package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double number) {
		for (Integer n : array) {
			super.insert(n);
		}
		return recursiveFloor(super.getRoot(), number);
	}

	@Override
	public Integer ceil(Integer[] array, double number) {
		for (Integer num : array) {
			super.insert(num);
		}
		return recursiveCeil(super.getRoot(), number);
	}

	private Integer recursiveFloor(BTNode<Integer> node, Double number) {
		if (isNull(node)) return null;
		if (numberIsEqualNode(node, number)) return node.getData();
		if (isLeaf(node) && elementIsLessThanNode(number, node)) return null;
		if (isLeaf(node)) return node.getData();
		if (elementIsLessThanNode(number, node)) return recursiveFloor(node.getLeft(), number);
		return max(node, recursiveFloor(node.getRight(), number));
	}

	private Integer recursiveCeil(BTNode<Integer> node, Double numero) {
		if (isNull(node)) return null;
		if (numberIsEqualNode(node, numero)) return node.getData();
		if (isLeaf(node) && elementIsGreaterThanNode(numero, node)) return null;
		if (isLeaf(node)) return node.getData();
		if (elementIsGreaterThanNode(numero, node)) return recursiveCeil(node.getRight(), numero);
		return (min(node, recursiveCeil(node.getLeft(), numero)));
	}

	private boolean elementIsGreaterThanNode(Double numero, BTNode<Integer> node) {
		return numero.compareTo(Double.valueOf(node.getData())) > 0;
	}

	private boolean numberIsEqualNode(BTNode<Integer> node, Double numero) {
		return numero.compareTo(Double.valueOf(node.getData())) == 0;
	}

	private boolean isNull(Object o) {
		return o == null;
	}

	private boolean isLeaf(BTNode<Integer> node) {
		return isNull(node.getLeft()) && isNull(node.getRight());
	}


	private Integer max(BTNode<Integer> node1, Integer number) {
		if (isNull(node1)) return number;
		if (isNull(number)) return node1.getData();
		if (node1.getData().compareTo(number) > 0) return node1.getData();
		return number;
	}

	private Integer min(BTNode<Integer> node1, Integer number) {
		if (isNull(node1)) return number;
		if (isNull(number)) return node1.getData();
		if (node1.getData().compareTo(number) < 0) return node1.getData();
		return number;
	}

	private boolean elementIsLessThanNode(Double number, BTNode<Integer> node) {
		return number.compareTo(Double.valueOf(node.getData())) < 0;
	}
}
