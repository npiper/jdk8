package neilpiper.me.jdktrial;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Test;

public class StringExercises {
  private List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

  @Test
  public void stringLengthSort_InnerClass() { // Java 5, 6, 7
    Collections.sort(strings, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    });
    System.out.println(strings);
  }

  @Test
  public void stringLengthSort_lambda() {
    // Use lambda for the Comparator (reverse sort)

    strings.sort((s1, s2) -> s1.length() - s2.length());
    System.out.println(strings);

    // Use the "sorted" method on Stream
    List<String> sorted = strings.stream().sorted().collect(Collectors.toList());

    // Alphabetical
    strings.stream().sorted().forEach(System.out::println);


    // Length
    strings.stream().sorted(StringExercises::compareStrings).forEach(System.out::println);


  }

  private static int compareStrings(String s1, String s2) {
    return s1.length() - s2.length();
  }

  @Test // Use a lambda that calls 'compareStrings' directly
  public void stringLengthSort_methodCall() {

    strings.stream().sorted((s1, s2) -> compareStrings(s1, s2)).forEach(System.out::println);
  }

  @Test // Use a method ref to 'compareStrings'
  public void stringLengthSort_methodRef() {
    
    strings.stream().sorted(StringExercises::compareStrings).forEach(System.out::println);
    
  }

  @Test // Use Comparator.comparingInt
  public void stringLengthSort_comparingInt() {
    
    // Utilises Comparator - comparingInt function that returns a 'key' for comparison
    strings.stream().sorted(Comparator.comparingInt(String::length)).forEach( System.out::println);
  }

  @Test
  public void demoCollectors() {
    
    List<String> stringers = Arrays.asList("this",null, "is", "a", null,null,"list", "of", "strings",null, "nulls");

     
    // Get only strings of even length
    // Add them to a LinkedList
    LinkedList<String> evens = stringers.stream().filter(s -> s != null && s.length() % 2 == 0).collect(Collectors.toCollection(LinkedList::new));

    
    // 2 filters, Use Objects::nonNull utility predicate
    evens = stringers.stream()
        .filter(Objects::nonNull)
        .filter(s -> s.length() % 2 == 0)
        .collect(Collectors.toCollection(LinkedList::new));
    
    System.out.println(evens);
    
    // Add the strings to a map of string to length
    // Function to produce Keys && Function to produce values (from same type)
    Map<String,Integer> smap = strings.stream().collect(Collectors.toMap(s -> s, s -> s.length()));
    System.out.println(smap);
    
    

    // Filter out nulls, then print even-length strings

    // Combine the two predicates and use the result to print non-null, even-length strings
    Predicate<String> nn = Objects::nonNull;
    Predicate<String> even = s -> s.length() % 2 == 0;
    evens = stringers.stream().filter(nn.and(even)).collect(Collectors.toCollection(LinkedList::new));
    System.out.println(evens); 
    
    Consumer<String> errorPrinter = System.err::println;
    Consumer<String> outPrinter = System.out::println;
    Consumer<String> both = outPrinter.andThen(errorPrinter);
    
    strings.stream().forEach(both);
  }

}
