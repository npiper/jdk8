package neilpiper.me.jdktrial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

  
  static Map<String,Integer> hm = new HashMap<String,Integer>();

  
  public static void main(String [] args)
  {
    
        
    List<Integer> intList = new ArrayList<Integer>();
    
    new Thread(() -> System.out.println("Started a lambda")).start();
    
    Runnable r = () -> System.out.println(
        "lambda expression implementing the run method");
    
    new Thread(r).start();
    
   

    
  }
}
    
