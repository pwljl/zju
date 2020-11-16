package P12;
import java.util.*;
//线性表java实现,泛型化之后的
public class SequenceList<T> {
    //默认长度
    private int DEFAULT_SIZE = 2;
    //定义一个数组用于保存线性表
    private Object[] elementData;
    //用于保存数组长度
    private int capacity;
    //保存顺序表中当前元素的个数
    private int size = 0;
    /*
    构造一个默认长度的空线性表
     */
    public SequenceList(){
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }
    /*
    用一个初始化元素来创建线性表
    @param element 初始化元素
     */
    public SequenceList(T element){
        this();
        elementData[0] = element;
        size++;
    }
    /*
    用一个元素和指定长度来创建线性表
    @param elemnt 元素
    @param initSize 指定长度
     */
    public SequenceList(T element, int initsize){
        capacity = 1;
        if(capacity<initsize){
            capacity = initsize + 2;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }
    /*
    向顺序表中插入元素
    @param element 待插入的元素
    @param index待插入的位置
     */
    public void insert(T element, int index){
        if (index<0||index>size){
           throw new IndexOutOfBoundsException("数组越界异常");
        }
        ensureCapacity(size+1);
        System.arraycopy(elementData, index, elementData, index+1, size-index);
        elementData[index] = element;
        size++;
    }
    /*
    表长
    @return
     */
    public int length(){
        return size;
    }
    /*
    向表中添加元素
    @param element
     */
    public void add(T element){
        insert(element, size);
    }
    /*
    得到线性表存储的对象
    @param index 获得的位置
    @return 得到的结果
     */
    public T get(int index){
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException("数组越界异常");
        return (T)elementData[index];
    }
    /*
    判断线性表是否为空
    @return
     */
    public boolean isEmpty(){
        return size==0;
    }
    /*
    清空线性表
     */
    public void clear(){
        Arrays.fill(elementData, null);
        size = 0;
    }
    /*
    删除指定位置的元素
     */
    public void delete(int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        else{
            //把数组前移一位
            System.arraycopy(elementData, index + 1, elementData, index, size-index-1);
            //清空最后一个元素
            elementData[size] = null;
            size--;
        }
    }
    /*
    确保数组所需长度小于数组原有长度
    @param mcapacity 数组所需长度
     */
    private void ensureCapacity(int mCapacity){
        if (mCapacity>capacity){
            capacity = mCapacity + 2;
            System.out.println("capacity:" + capacity);
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }
}
