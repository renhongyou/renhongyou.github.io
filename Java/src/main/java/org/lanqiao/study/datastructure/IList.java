package org.lanqiao.study.datastructure;

/**
 * 顺序表
 * @author 任宏友
 *
 */
public abstract class IList extends ICollection {
	/**
	 * 求指定元素的下标，没有这个元素则返回-1
	 * @param obj
	 * @return
	 */
	abstract int indexOf(Object obj);
	
	/**
	 * 获取指定下标处的元素
	 * @param index
	 * @return
	 */
	abstract Object get(int index);
	
	/**
	 * 在指定下标处插入元素
	 * @param obj
	 * @param index
	 */
	abstract void add(Object obj, int index);
	
	/**
	 * 删除指定下标处的元素，并返回该元素
	 * @param index
	 * @return
	 */
	abstract Object delete(int index);
}
