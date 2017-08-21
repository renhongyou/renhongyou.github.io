package org.lanqiao.study.datastructure;

/**
 * ArrayList
 * 充分考虑元素的紧密排列和扩容问题
 * @author 任宏友
 *
 */

public class ArrayList extends IList {
	//使用对象数组作为数据的实际持有者
	private Object[] data;
	private int size = 0;
	private final int EXTRA;
	
	public ArrayList() {
		data = new Object[20];
		EXTRA = 20;
	}
	
	public ArrayList(int length) {
		data = new Object[length];
		EXTRA = length;
	}

	@Override
	public int indexOf(Object obj) {
		for(int i = 0; i < data.length; i++) {
			if((null == data[i] && null == obj) || (obj.equals(data[i]))) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Object get(int index) {
		return data[index];
	}

	@Override
	public void add(Object obj, int index) {
		//如果元素个数等于数组现在长度，说明必须扩容
		if(size == data.length) {
			Object[] dataExtend = new Object[size + EXTRA];
			for(int i = 0; i < data.length; i++) {
				dataExtend[i] = data[i];
			}
			data = dataExtend;
		}
		//如果索引超出当前大小
		if(index >= size) {
			add(obj);
			size++;
			return;
		}
		for(int j = size; j > index; j--) {
			data[j] = data[j - 1];
		}
		data[index] = obj;
		size++;
	}

	@Override
	public Object delete(int index) {
		if(index >= size) {
			return null;
		}
		Object temp = data[index];
		for(int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return temp;
	}

	@Override
	public Object search(Object obj) {
		for(int i = 0; i < data.length; i++) {
			if((null == data[i] && null == obj) || obj.equals(data[i])) {
				return data[i];
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return 0 == size;
	}

	@Override
	public boolean contains(Object obj) {
		return null != search(obj);
	}

	@Override
	public void add(Object obj) {
		//如果元素个数等于数组现在长度，说明必须扩容
		if(size == data.length) {
			Object[] dataExtend = new Object[size + EXTRA];
			for(int i = 0; i < data.length; i++) {
				dataExtend[i] = data[i];
			}
			data = dataExtend;
		}
		data[size] = obj;
		size++;
	}

	@Override
	public void remove(Object obj) {
		for(int i = 0; i < data.length; i++) {
			if((null == data[i] && null == obj) || (obj.equals(data[i]))) {
				data[i] = null;
				//后继元素前移
				for(int j = i; j < size - 1; j++) {
					data[j] = data[j + 1];
				}
				size--;
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size; i++) {
			sb.append(data[i]).append(",");
		}
		sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
		return sb.toString();
	}
}
