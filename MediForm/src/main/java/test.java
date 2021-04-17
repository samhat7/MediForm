import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Patient pat = new Patient();
        List<Object> both = new ArrayList<Object>();
        both.add("String");
        both.add(12.2f);
        both.add(pat.getName());

        System.out.print(both.get(2));
    }
}
