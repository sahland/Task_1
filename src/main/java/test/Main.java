package test;
import com.sahland.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet();
        set.add("Geeks1");
        set.add("Geeks2");
        set.add("Geeks2");
        System.out.println(set);


        MultiSet<String> multiset = new HashMultiSet<>();
        multiset.add("Geeks1");
        multiset.add("Geeks2");
        multiset.add("Geeks2");
        System.out.println(multiset);
    }
}
