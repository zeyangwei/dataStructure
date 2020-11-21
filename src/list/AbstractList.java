package list;

/**
 * @author 魏泽阳
 * @date 2020/11/21 17:13
 */
public abstract class AbstractList<E> implements List<E> {
     public int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

}
