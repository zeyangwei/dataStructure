package dynamicArray;

/**
 * @author 魏泽阳
 * @date 2020/11/11 16:20
 * 动态数组
 */
public class DynamicArray<T> {
    //元素的数量
    private int size;
    //所有的元素
    private T[] elements;

    //初始容量
    private static final int DEFAULT_CAPACITY = 10;
    //错误信息
    private static final int ELEMENT_NOT_FOUND = -1;
    //无参构造方法
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 小于10的一律按10算
     * @param capacity
     */
    public DynamicArray(int capacity) {
       capacity = Math.max(capacity, DEFAULT_CAPACITY);
       elements = (T[])new Object[capacity];
    }

    /**
     * 判断长度
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 查看元素索引
     * @param element
     * @return
     */
    public int indexOf(T element){
       if (element==null){
           for (int i = 0; i < size; i++) {
               if (elements[i]==null) return i;
           }
       }else {
           for (int i = 0; i < size; i++) {
               if (element.equals(elements[i])){
                   return i;
               }
           }
       }
       return ELEMENT_NOT_FOUND;
    }

    /**
     *判断是否包含这个元素
     * @param element
     * @return
     */
    public boolean cotain(T element){
        return ELEMENT_NOT_FOUND!=indexOf(element);
    }

    /**
     * 扩容的逻辑是这样的，输入一个容量，如果大于数组的容量，就扩为原来的1.5倍
     *然后这边采用了位运算
     * @param capacity
     */
    public void expansion(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity>=capacity) return;
        int newCapacity = oldCapacity+(oldCapacity>>1);
        //扩容之后作为新的数组，把元素拷到新的数组中
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 在任意位置插入元素
     * @param index
     * @param element
     */
    public void add(int index,T element){
        //检查下标是否越界
        check(index);
        //扩容
        expansion(size++);
        for (int i = size-1; i > index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
    }

    /**
     * 在末尾加入元素
     * @param element
     */
    public void add(T element){
        add(size,element);
    }

    /**
     * 获取对应位置的元素
     * @param index
     * @return
     */
    public T get(int index){
        check(index);
        return elements[index];
    }

    public T remove(int index){
        check(index);
        T old = elements[index];
        for (int i = index; i < size-1; i++) {
            elements[i] =elements[i+1];
        }
        elements[size--] = null;
        return old;
    }

    /**
     * 判断是否越界
     * @param index
     * @return
     */
    public void check(int index){
        if (index<0||index>=size){
            outofBounds(index);
        }
    }

    /**
     * 越界抛异常
     * @param index
     */
    public void outofBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+"Size"+size);
    }
}
