import java.util.LinkedHashMap;
import java.util.Map;

public class linkedhashmap2 {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> data = new LinkedHashMap<Integer, String>();
         
                data.put(100, "apiw");
                data.put(200, "nabila");
                data.put(500, "dio");
                data.put(800, "dani");
                data.put(300, "fahri");
                data.put(600, "faiz");
                data.put(400, "irfan");
                data.put(700, "revi");
                data.put(900, "diqzi");
         
                for (Map.Entry nama : data.entrySet()) {
                System.out.println("kunci : " + nama.getKey() + "nilai : " + nama.getValue());
                }
            }
        
}
