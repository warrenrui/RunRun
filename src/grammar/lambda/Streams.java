package grammar.lambda;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * http://www.hao124.net/article/86
 * https://www.cnblogs.com/franson-2016/p/5593080.html
 * <p>
 * Stream是对集合的包装,通常和lambda一起使用。 使用lambdas可以支持许多操作,如 map, filter, limit, sorted, count, min, max, sum, collect 等等。
 * 同样,Stream使用懒运算,他们并不会真正地读取所有数据,遇到像getFirst() 这样的方法就会结束链式语法。
 * 在接下来的例子中,我们将探索lambdas和streams 能做什么。
 * 我们创建了一个Person类并使用这个类来添加一些数据到list中,将用于进一步流操作。
 */
public class Streams {

    public static void main(String[] args) {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };

        System.out.println("All programmer's names:");
        Consumer<Person> nameConsumer = p -> System.out.println(p.getFirstName() + "-" + p.getLastName());
        javaProgrammers.forEach(nameConsumer);
        phpProgrammers.forEach(nameConsumer);

        System.out.println("All programmer raise five percent:");
        javaProgrammers.forEach(javaProgrammer -> javaProgrammer.setSalary(javaProgrammer.getSalary() * 1.05));
        phpProgrammers.forEach(phpProgrammer -> phpProgrammer.setSalary(phpProgrammer.getSalary() * 1.05));

        // 另一个有用的方法是过滤器filter() ,显示月薪超过1400美元的PHP程序员:
        phpProgrammers.stream().filter(phpProgrammer -> phpProgrammer.getSalary() > 1400).forEach(phpProgrammer -> System.out.println(phpProgrammer.getFirstName() + "-" + phpProgrammer.getLastName()));

        // 定义filter
        Predicate<Person> ageFilter = p -> p.getAge() > 25;
        Predicate<Person> salaryFilter = p -> p.getSalary() > 1400;
        Predicate<Person> genderFilter = p -> "female".equalsIgnoreCase(p.getGender());
        System.out.println("下面是年龄大于24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter).forEach(nameConsumer);

        // 重用filters
        System.out.println("年龄大于24岁的女性 Java programmers:");
        javaProgrammers.stream().filter(ageFilter).filter(genderFilter).forEach(nameConsumer);

        // 使用limit方法,可以限制结果集的个数:
        System.out.println("最前面的3个 Java programmers:");
        javaProgrammers.stream().limit(3).forEach(nameConsumer);

        System.out.println("最前面的3个女性 Java programmers:");
        javaProgrammers.stream().filter(genderFilter).limit(3).forEach(nameConsumer);

        // 排序
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        final List<Person> sortedJavaProgrammers = javaProgrammers.stream().sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName())).limit(5).collect(Collectors.toList());
        sortedJavaProgrammers.forEach(nameConsumer);

        System.out.println("根据 salary 排序 Java programmers:");
        javaProgrammers.stream().sorted(Comparator.comparingDouble(Person::getSalary)).forEach(nameConsumer);

        System.out.println("工资最低的 Java programmer:");
        final Person person = javaProgrammers.stream().min(Comparator.comparingDouble(Person::getSalary)).get();
        System.out.println(JSON.toJSON(person));

        System.out.println("将 PHP programmers 的 first name 拼接成字符串:");
        final String phpDevelopers = phpProgrammers.stream().map(Person::getFirstName).collect(Collectors.joining(";"));
        System.out.println(JSON.toJSON(phpDevelopers));

        System.out.println("将 Java programmers 的 first name 存放到 Set:");
        final Set<String> phpDeveloperSet = phpProgrammers.stream().map(Person::getFirstName).collect(Collectors.toSet());
        System.out.println(JSON.toJSON(phpDeveloperSet));

        System.out.println("将 Java programmers 的 first name 存放到 TreeSet:");
        final TreeSet<String> phpDeveloperTreeSet = phpProgrammers.stream().map(Person::getFirstName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(JSON.toJSON(phpDeveloperTreeSet));

        //Streams 还可以是并行的(parallel)
        System.out.println("计算付给 Java programmers 的所有money:");
        System.out.println(javaProgrammers.parallelStream().mapToDouble(Person::getSalary).sum());


        //可以使用summaryStatistics方法获得stream 中元素的各种汇总数据。
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("max :" + intSummaryStatistics.getMax());
        System.out.println("min :" + intSummaryStatistics.getMin());
        System.out.println("sum :" + intSummaryStatistics.getSum());
        System.out.println("average :" + intSummaryStatistics.getAverage());
    }
}
