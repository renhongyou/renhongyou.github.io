package org.lanqiao.study.datastructure;

/**
 * 定义动态集合的基本操作
 * @author 任宏友
 *
 */
public abstract class ICollection {
	/**
	 * 根据关键字搜索出对应对象
	 * @param obj
	 * @return
	 */
	abstract Object search(Object obj);
	
	/**
	 * 元素个数
	 * @return
	 */
	abstract int size();
	
	/**
	 * 判断集合是否为空
	 */
	abstract boolean isEmpty();
	
	/**
	 * 判断集合是否包含某个关键字元素
	 * @param obj
	 * @return
	 */
	abstract boolean contains(Object obj);
	
	/**
	 * 在集合中新增一个元素
	 * @param obj
	 */
	abstract void add(Object obj);
	
	/**
	 * 按关键字移除元素
	 * @param obj
	 */
	abstract void remove(Object obj);
}
