package org.lanqiao.study.datastructure;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 二叉搜索树
 * @author 任宏友
 *
 */
public class BinarySearchTree {
	private class Node {
		public Object obj;
		public Node left;
		public Node right;
		public Node parent;
		public boolean isLeftChild;
		
		public Node(Object obj, Node left, Node right, Node parent) {
			super();
			this.obj = obj;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		public String toString() {
			return "Node [obj = " + obj +"]";
		}
	}
	/**
	 * 根节点
	 */
	private Node root;
	/**
	 * 元素个数
	 */
	private int size;
	private Comparator<Object> comparator;
	
	public BinarySearchTree(Comparator<Object> comparator) {
		this.comparator = comparator;
	}
	
	/**
	 * 新增节点
	 * @param obj
	 */
	public void insert(Object obj) {
		if(!(obj instanceof Comparable)) {
			throw new ClassCastException();
		}
		Node pnt = null;
		Node current = root;
		while(null != current) {
			pnt = current;
			if(compare(obj, current.obj) < 0) {
				current = current.left;
			} else if(compare(obj, current.obj) > 0) {
				current = current.right;
			} else {
				current.obj = obj;
				return;
			}
		}
		current = new Node(obj, null, null, null);
		current.parent = pnt;
		if(null == pnt) {
			root = current;
		} else if(compare(obj, pnt.obj) < 0) {
			pnt.left = current;
			current.isLeftChild = true;
		} else {
			pnt.right = current;
			current.isLeftChild = false;
		}
		size++;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private int compare(Object obj1, Object obj2) {
		if(null == comparator) {
			return ((Comparable) obj1).compareTo((Comparable) obj2);
		} else {
			return comparator.compare(obj1, obj2);
		}
	}
	
	/**
	 * 中序遍历
	 * 处理中序遍历的每个元素
	 * @param con
	 */
	public void inorder(Consumer<Object> con) {
		if(null != root) {
			inorder(root, con);
		}
	}
	
	private void inorder(Node pnt, Consumer<Object> con) {
		if(null != pnt) {
			inorder(pnt.left, con);
			con.accept(pnt.obj);
			inorder(pnt.right, con);
		}
	}
	
	/**
	 * 查找元素
	 * @param obj
	 * @return
	 */
	public Object lookup(Object obj) {
		Node lookupNode = lookupNode(obj);
		return (null == lookupNode) ? null : lookupNode.obj;
	}
	
	private Node lookupNode(Object obj) {
		Node pnt = root;
		while(null != pnt && 0 != compare(obj, pnt.obj)) {
			if(compare(obj, pnt.obj) < 0) {
				pnt = pnt.left;
			} else {
				pnt = pnt.right;
			}
		}
		return pnt;
	}
	
	/**
	 * 获取最小元素
	 * @return
	 */
	public Object min() {
		return minNode(root).obj;
	}
	
	private Node minNode(Node pnt) {
		while(null != pnt.left) {
			pnt = pnt.left;
		}
		return pnt;
	}
	
	/**
	 * 获取最大元素
	 * @return
	 */
	public Object max() {
		return maxNode(root).obj;
	}
	
	private Node maxNode(Node pnt) {
		while(null != pnt.right) {
			pnt = pnt.right;
		}
		return pnt;
	}
	
	public void remove(Object obj) {
		removeNode(lookupNode(obj));
		size--;
	}
	
	private void removeNode(Node pnt) {
		if(null != pnt) {
			if(null == pnt.left && null == pnt.right) {
				//没有子节点
				if(pnt.isLeftChild) {
					pnt.parent.left = null;
				} else {
					if(null != pnt.parent) {
						pnt.parent.right = null;
					} else {
						//根节点
						root = null;
					}
				}
				pnt = null;
			} else if(null == pnt.left) {
				//有子节点但左子节点为空
				if(pnt.isLeftChild) {
					pnt.parent.left = pnt.right;
					pnt.right.isLeftChild = true;
					pnt.right.parent = pnt.parent;
				} else {
					if(null != pnt.parent) {
						pnt.parent.right = pnt.right;
						pnt.right.parent = pnt.parent;
					} else {
						//根节点
						root = pnt.right;
					}
				}
				pnt = null;
			} else if(null == pnt.right) {
				//有子节点但右子节点为空
				if(pnt.isLeftChild) {
					pnt.parent.left = pnt.left;
					pnt.left.parent = pnt.parent;
				} else {
					if(null != pnt.parent) {
						pnt.parent.right = pnt.left;
						pnt.left.isLeftChild = false;
						pnt.left.parent = pnt.parent;
					} else {
						//根节点
						root = pnt.left;
					}
				}
				pnt = null;
			} else {
				//左右子节点都不为空
				Node minOfRight = minNode(pnt.right);
				pnt.obj = minOfRight.obj; //更换pnt的内容
				removeNode(minOfRight); //删掉右子树中最小的元素
			}
		}
	}
	
	/**
	 * obj的后继——比obj大的第一个元素
	 * 1、是其右子树的最小值；
	 * 2、没有右子树，则向上追溯，直到每个祖先节点是左子节点，返回这个祖先节点的父节点，它就是obj的后继。
	 * @param obj
	 * @return
	 */
	public Object successor(Object obj) {
		Node objNode = lookupNode(obj);
		if(null == objNode) {
			return null;
		}
		if(null != objNode.right) {
			return minNode(objNode.right).obj;
		}
		Node pntNode = objNode.parent;
		while(null != pntNode && objNode == pntNode.right) {
			objNode = pntNode;
			pntNode = pntNode.parent;
		}
		return (null == pntNode) ? null : pntNode.obj;
	}
	
	/**
	 * obj的前驱
	 * @param obj
	 * @return
	 */
	public Object predecessor(Object obj) {
		Node objNode = lookupNode(obj);
		if(null == objNode) {
			return null;
		}
		if(null != objNode.left) {
			return maxNode(objNode.left).obj;
		}
		Node pntNode = objNode.parent;
		while(null != pntNode && objNode.isLeftChild) {
			objNode = pntNode;
			pntNode = pntNode.parent;
		}
		return (null == pntNode) ? null : pntNode.obj;
	}
	
	/**
	 * 获取树的节点数
	 * @return
	 */
	public int getSize() {
		return size;
	}
}
