import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "a;b;";
        String[] arrayString = s.split(";", 3);
        System.out.println(arrayString[0].length() > 0 ? arrayString[0] : null);
        System.out.println(arrayString[1].length() > 0 ? arrayString[1] : null);
        System.out.println(arrayString[2].length() > 0 ? arrayString[2] : null);

//        System.out.println(Arrays.asList(arrayString));
        System.out.println(arrayString.length);
//        System.out.println(Long.parseLong(null));
    }
}
