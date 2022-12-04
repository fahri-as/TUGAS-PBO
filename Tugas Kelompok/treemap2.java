import java.util.TreeMap; 
 
public class treemap2 { 
 
 public static void main(String[] args) { 
 
 //create TreeMap object 
 TreeMap treeMap = new TreeMap(); 
 
 //add key value pairs to TreeMap 
 treeMap.put("1","One"); 
 treeMap.put("3","Three"); 
 treeMap.put("2","Two"); 
 treeMap.put("5","Five"); 
 treeMap.put("4","Four"); 
 
 System.out.println("Lowest key Stored in Java TreeMap is : " 
 + treeMap.firstKey()); 
 
 System.out.println("Highest key Stored in Java TreeMap is : " 
 + 
treeMap.lastKey()); 
 
 } 
} 