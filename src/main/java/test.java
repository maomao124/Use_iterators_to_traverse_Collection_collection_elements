import java.util.HashSet;
import java.util.Iterator;

/**
 * Project name(项目名称)：使用迭代器遍历Collection集合元素
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/20
 * Time(创建时间)： 16:35
 * Version(版本): 1.0
 * Description(描述)： Iterator（迭代器）是一个接口，它的作用就是遍历容器的所有元素，也是 Java 集合框架的成员，
 * 但它与 Collection 和 Map 系列的集合不一样，Collection 和 Map 系列集合主要用于盛装其他对象，
 * 而 Iterator 则主要用于遍历（即迭代访问）Collection 集合中的元素。
 * Iterator 接口隐藏了各种 Collection 实现类的底层细节，向应用程序提供了遍历 Collection 集合元素的统一编程接口。
 * Iterator 接口里定义了如下 4 个方法。
 * boolean hasNext()：如果被迭代的集合元素还没有被遍历完，则返回 true。
 * Object next()：返回集合里的下一个元素。
 * void remove()：删除集合里上一次 next 方法返回的元素。
 * void forEachRemaining(Consumer action)：这是 Java 8 为 Iterator 新增的默认方法，该方法可使用 Lambda 表达式来遍历集合元素。
 * Iterator 必须依附于 Collection 对象，若有一个 Iterator 对象，则必然有一个与之关联的 Collection 对象。
 * Iterator 提供了两个方法来迭代访问 Collection 集合里的元素，并可通过 remove() 方法来删除集合中上一次 next() 方法返回的集合元素。
 * 当使用 Iterator 迭代访问 Collection 集合元素时，Collection 集合里的元素不能被改变，
 * 只有通过 Iterator 的 remove() 方法删除上一次 next() 方法返回的集合元素才可以，
 * 否则将会引发“java.util.ConcurrentModificationException”异常。
 */

public class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        HashSet<String> p = new HashSet<>();
        p.add("第一个字符串");
        p.add("第二个字符串");
        p.add("第三个字符串");
        p.add("第四个字符串");
        p.add("第五个字符串");
        p.add("第六个字符串");
        p.add("第七个字符串");
        p.add("第八个字符串");
        p.add("第九个字符串");
        p.add("第十个字符串");
        System.out.println(p.size());
        Iterator<String> it = p.iterator();
        while (it.hasNext())
        {
            String s = it.next();
            System.out.println(s);
            if (s.equals("第五个字符串"))
            {
                it.remove();
            }
        }
        System.out.println();
        p.forEach(System.out::println);
        System.out.println(p.size());
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
