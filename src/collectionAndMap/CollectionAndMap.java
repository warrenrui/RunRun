package collectionAndMap;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 总结 　　如果涉及到堆栈，队列等操作，应该考虑用List。对于需要快速插入，删除元素，应该使用LinkedList，如果需要快速随机访问元素，
 * 应该使用ArrayList。
 * 　　如果程序在单线程环境中，或者访问仅仅在一个线程中进行，考虑非同步的类，其效率较高，如果多个线程可能同时操作一个类，应该使用同步的类。
 * 　　要特别注意对哈希表的操作，作为key的对象要正确复写equals和hashCode方法。
 * 　　尽量返回接口而非实际的类型，如返回List而非ArrayList
 * ，这样如果以后需要将ArrayList换成LinkedList时，客户端代码不用改变。这就是针对抽象编程。
 *
 * @author Administrator
 */
@SuppressWarnings({"unused", "rawtypes", "unchecked"})
public class CollectionAndMap {
    public static void main(String[] args) {
        // Map map1 = new HashMap();
        // // key不能重复，否则会覆盖更新
        // map1.put(null, null);
        // map1.put(2, 1);
        // map1.put(1, 1);
        // map1.put(1, 2);
        // Set entrySet = map1.entrySet();
        // Iterator iterator = entrySet.iterator();
        // while (iterator.hasNext()) {
        // Entry next = (Entry) iterator.next();
        // System.out.println(next.getKey() + "--" + next.getValue());
        // }
        //
        // System.out.println(map1.get(null));
        // System.out.println(map1.get(1));

        // ------------------------------------------
        // List c = Collections.EMPTY_LIST;
        // Arrays.asList(new Object());
        // ConcurrentHashMap map = new ConcurrentHashMap();
        // list();
        // set();
        map();
    }

    /**
     * Collection接口 　　Collection是最基本的集合接口，一个Collection代表一组Object，即Collection的元素
     * （Elements）。一些Collection允许相同的元素而另一些不行。一些能排序而另一些不行。Java
     * SDK不提供直接继承自Collection的类，Java SDK提供的类都是继承自Collection的“子接口”如List和Set。
     * 　　所有实现Collection接口的类都必须提供两个标准的构造函数：无参数的构造函数用于创建一个空的Collection，
     * 有一个Collection参数的构造函数用于创建一个新的Collection
     * ，这个新的Collection与传入的Collection有相同的元素。 后一个构造函数允许用户复制一个Collection。
     */
    public static void collection() {
        list();
        set();
    }

    /**
     * List接口 　　List是有序的Collection，使用此接口能够精确的控制每个元素插入的位置。用户能够使用索引（元素在List中的位置
     * ，类似于数组下标）来访问List中的元素，这类似于Java的数组。 和下面要提到的Set不同，List允许有相同的元素。
     * 　　除了具有Collection接口必备的iterator
     * ()方法外，List还提供一个listIterator()方法，返回一个ListIterator接口
     * ，和标准的Iterator接口相比，ListIterator多了一些add()之类的方法，允许添加，删除，设定元素，还能向前或向后遍历。
     * 　　实现List接口的常用类有LinkedList，ArrayList，Vector和Stack。
     */
    public static void list() {
        /**
         * LinkedList类
         * 　　LinkedList实现了List接口，允许null元素。此外LinkedList提供额外的get，remove
         * ，insert方法在LinkedList的首部或尾部
         * 。这些操作使LinkedList可被用作堆栈（stack），队列（queue）或双向队列（deque）。
         * 　　注意LinkedList没有同步方法
         * 。如果多个线程同时访问一个List，则必须自己实现访问同步。一种解决方法是在创建List时构造一个同步的List：List list =
         * Collections.synchronizedList(new LinkedList(...));
         */
        Collection<String> collection1 = new LinkedList<String>();
        // collection1.add(null);
        collection1.add("");
        collection1.add("1");
        // collection1.add(null);
        for (String str : collection1) {
            System.out.println("linkedList--" + str);
        }
        System.out.println("max--" + Collections.max(collection1));
        /**
         * ArrayList类 　　ArrayList实现了可变大小的数组。它允许所有元素，包括null。ArrayList没有同步。
         * size，isEmpty
         * ，get，set方法运行时间为常数。但是add方法开销为分摊的常数，添加n个元素需要O(n)的时间。其他的方法运行时间为线性。
         * 　　每个ArrayList实例都有一个容量
         * （Capacity），即用于存储元素的数组的大小。这个容量可随着不断添加新元素而自动增加，但是增长算法并没有定义
         * 。当需要插入大量元素时，在插入前可以调用ensureCapacity方法来增加ArrayList的容量以提高插入效率。
         * 　　和LinkedList一样，ArrayList也是非同步的（unsynchronized）。
         */
        Collection<String> collection2 = new ArrayList<String>();
        collection2.add(null);
        collection2.add(null);
        collection2.add("sdf");
        collection2.add("sdf");
        collection2.add("sdf");

        /**
         * Vector类 　　Vector非常类似ArrayList，但是Vector是同步的。由Vector创建的Iterator，
         * 虽然和ArrayList创建的Iterator是同一接口
         * ，但是，因为Vector是同步的，当一个Iterator被创建而且正在被使用，另一个线程改变了Vector的状态
         * （例如，添加或删除了一些元素
         * ），这时调用Iterator的方法时将抛出ConcurrentModificationException，因此必须捕获该异常。
         */
        Collection<String> collection3 = new Vector<String>();
        /**
         * Stack 类 　　Stack继承自Vector，实现一个后进先出的堆栈。Stack提供5个额外的方法使得Vector得以被当作堆栈使用。
         * 基本的push和pop方法
         * ，还有peek方法得到栈顶的元素，empty方法测试堆栈是否为空，search方法检测一个元素在堆栈中的位置。Stack刚创建后是空栈。
         */
        Collection<String> collection4 = new Stack<String>();
    }

    /**
     * SET接口 　　Set是一种不包含重复的元素的Collection，即任意的两个元素e1和e2都有e1.equals(e2)=false
     * ，Set最多有一个null元素。 　　很明显，Set的构造函数有一个约束条件，传入的Collection参数不能包含重复的元素。
     * 　　请注意：必须小心操作可变对象（Mutable
     * Object）。如果一个Set中的可变元素改变了自身状态导致Object.equals(Object)=true将导致一些问题。
     */
    public static void set() {
        Collection collection5 = new HashSet();
        collection5.add("1");
        collection5.add("1");
        collection5.add(new Object());
        collection5.add(1);
        collection5.add(2);
        collection5.add(null);
        collection5.add(null);
        System.out.println(collection5.size());// 5
        Collection<String> collection6 = new LinkedHashSet<String>();
        Collection collection7 = new TreeSet();
        collection7.add("1");
        collection7.add("3");
        collection7.add("7");
        collection7.add("3");
        Iterator iterator = collection7.iterator();
        while (iterator.hasNext()) {
            Object object = (Object) iterator.next();
            System.out.println("treeset--" + object);
        }
    }

    /**
     * Map接口 　　请注意，Map没有继承Collection接口，Map提供key到value的映射。一个Map中不能包含相同的key，
     * 每个key只能映射一个value
     * 。Map接口提供3种集合的视图，Map的内容可以被当作一组key集合，一组value集合，或者一组key-value映射。
     */
    public static void map() {
        /**
         * HashMap类 　　HashMap和Hashtable类似，不同之处在于HashMap是非同步的，并且允许null，即null
         * value和null key。，但是将HashMap视为Collection时（values()方法可返回Collection），
         * 其迭代子操作时间开销和HashMap的容量成比例
         * 。因此，如果迭代操作的性能相当重要的话，不要将HashMap的初始化容量设得过高，或者load factor过低。
         */
        Map map1 = new HashMap();
        // key不能重复，否则会覆盖更新
        map1.put(null, null);
        map1.put(0, 1);
        map1.put(0, 2);
        map1.put(0, 3);
        map1.put(0, 4);
        map1.put(0, 5);
        map1.put(0, 6);
        map1.put(0, 7);
        map1.put(0, 8);
        map1.put(1, 1);
        map1.put(2, 1);
        map1.put(3, 1);
        map1.put(4, 1);
        map1.put(5, 1);
        map1.put(6, 1);
        map1.put(7, 1);
        map1.put(8, 1);
        map1.put(9, 1);
        map1.put(10, 1);
        map1.put(11, 1);
        map1.put(12, 1);
        map1.put(13, 1);
        map1.put(14, 1);
        map1.put(15, 1);
        map1.put(16, 1);
        Set entrySet = map1.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry next = (Entry) iterator.next();
            System.out.println(next.getKey() + "--" + next.getValue());
        }

        System.out.println(map1.get(null));
        System.out.println(map1.get(1));
        Map map2 = new LinkedHashMap();
        Map concurrentHashMap = new ConcurrentHashMap();
        ThreadLocal<Integer> temp = new ThreadLocal<Integer>();
        /**
         * WeakHashMap类 　　WeakHashMap是一种改进的HashMap，它对key实行“弱引用”，如果一个key不再被外部所引用，
         * 那么该key可以被GC回收。
         */
        Map map3 = new WeakHashMap();
        /**
         * Hashtable类 　　Hashtable继承Map接口，实现一个key-value映射的哈希表。任何非空（non-null）
         * 的对象都可作为key或者value。 　　添加数据使用put(key,
         * value)，取出数据使用get(key)，这两个基本操作的时间开销为常数。 Hashtable通过initial
         * capacity和load factor两个参数调整性能。通常缺省的load factor
         * 0.75较好地实现了时间和空间的均衡。增大load factor可以节省空间但相应的查找时间将增大，这会影响像get和put这样的操作。
         * 使用Hashtable的简单示例如下，将1，2，3放到Hashtable中，他们的key分别是”one”，”two”，”three”：
         * 　　　　Hashtable numbers = new Hashtable(); 　　　　numbers.put(“one”, new
         * Integer(1)); 　　　　numbers.put(“two”, new Integer(2));
         * 　　　　numbers.put(“three”, new Integer(3)); 　　要取出一个数，比如2，用相应的key：
         * 　　　　Integer n = (Integer)numbers.get(“two”);
         * 　　　　System.out.println(“two = ” + n);
         * 　　由于作为key的对象将通过计算其散列函数来确定与之对应的value的位置
         * ，因此任何作为key的对象都必须实现hashCode和equals方法
         * 。hashCode和equals方法继承自根类Object，如果你用自定义的类当作key的话
         * ，要相当小心，按照散列函数的定义，如果两个对象相同
         * ，即obj1.equals(obj2)=true，则它们的hashCode必须相同，但如果两个对象不同
         * ，则它们的hashCode不一定不同，
         * 如果两个不同对象的hashCode相同，这种现象称为冲突，冲突会导致操作哈希表的时间开销增大，所以尽量定义好的hashCode
         * ()方法，能加快哈希表的操作。
         * 　　如果相同的对象有不同的hashCode，对哈希表的操作会出现意想不到的结果（期待的get方法返回null
         * ），要避免这种问题，只需要牢记一条：要同时复写equals方法和hashCode方法，而不要只写其中一个。
         * 　　Hashtable是同步的。
         */

        System.out.println("---------hashtable-------------");
        Map map4 = new Hashtable();
        // map4.put(null, 1);
        // map4.put(null, null);
        map4.put(1, 1);
        map4.put(1, 1);

        Map map5 = new TreeMap();
        System.out.println("over!");

        System.out.println("--------hashcode---------");
        HashMap map11 = new HashMap();
        // map11.put("test", "testValue");
        // map11.put("test1", "testValue1");
        // map11.put("test2", "testValue2");

        HashMap map22 = new HashMap();
        // map22.put("test", "testValue");
        // map22.put("test1", "testValue1");
        // map22.put("test2", "testValue22");
        // map22=map11;

        System.out.println(map11.hashCode());
        System.out.println(map22.hashCode());

        System.out.println(HashMap.class.hashCode());
    }
}
