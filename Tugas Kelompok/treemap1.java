import java.util.Map;
import java.util.TreeMap;

public class treemap1 {
   
    private static final Integer ONE = new Integer(1);
   
    public static void main(String[] args) {
       
        // Set up test data
        String name[] = {
            new String("aca"),
            new String("arip"),
            new String("abil"),
            new String("Pahri"),
            new String("irpan")
        };
       
        // Create TreeMap object
        Map m = new TreeMap<>();
       
        // Initialize frequency table with testing data
        for (int i=0; i<name.length; i++) {
            Integer freq = (Integer) m.get(name[i]);
           
            // Adding an entry to the TreeMap;
            m.put(name[i], (freq==null ? ONE : new Integer(freq.intValue()+1)));
        }
       
        // Display the size of the Map object
        System.out.println(m.size() + " distinct words detected:");
       
        // Display Map object
        System.out.println("Display of the TreeMap object = " + m);
       
    }
   
}