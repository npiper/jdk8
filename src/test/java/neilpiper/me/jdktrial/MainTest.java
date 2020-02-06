package neilpiper.me.jdktrial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.junit.Test;
import org.mockito.Mockito;

public class MainTest {


  public static LongStream primeFactors(long x) {
    return LongStream.rangeClosed(2, x).filter(n -> x % n == 0)
        .filter(n -> LongStream.rangeClosed(2, n / 2).noneMatch(i -> n % i == 0));
  }

  @Test
  public void testFindPrimes1to1000() {

    List<Integer> primes = new ArrayList<Integer>();

    // Consumers - use up elements of the string, e.g. Printing
    // Predicates - test the stream elements, typically filters out elements of the list
    // Suppliers - create an object, but only when we need it - adds to the stream / terminal
    // operation
    // Function - Transform elements e.g. T->R, used for Mapping map() methods
    // java.util.Comparator - used for Streams with an Order (e.g. Integer) - max, min
    // Collector --> Convert Stream results to List (Terminal)
    
    // Don't do anything stateful in Parallel


    LongStream ls = primeFactors(24);


    ls.forEach(p -> System.out.println(p));
    // OptionalLong ll = ls.findFirst();
    // ll.getAsLong();

    // Now just have
    // IntStream.range(2,1000).boxed().filter( i -> i % 2 != 0 )

    // Integer range 1 to 1000

    // Record a prime array

    // Checks
    // Divide by 2 - if not divisible, skip else..
    // Divide by primes (list) - starting at 3

    // Prime? --> Add to prime list

    // At end System.out.println



  }

  @Test
  public void testCollectIntoListUsingFilters() {
    List<Integer> divisibleByTwoThreeList = IntStream.range(1, 100).boxed().filter(i -> i % 2 == 0)
        .filter(j -> j % 3 == 0).collect(Collectors.toList());

    assertTrue(!divisibleByTwoThreeList.isEmpty());

  }

  @Test
  public void testConvertUsingMap() {

  }

  @Test
  public void testStreamCollect() {
    List<String> timeZoneIDs = Arrays.asList(java.util.TimeZone.getAvailableIDs());

    List<TimeZone> timeZones = timeZoneIDs.stream().filter(c -> c.startsWith("Australia"))
        .map(tid -> TimeZone.getTimeZone(tid))
        .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

    assertEquals(23, timeZones.size() );

  }

  @Test
  public void filterCountryCodesToLocales() {

    String[] iso8601 = {"FR", "UK", "AU", "CA", "GR", "US", "SE", "CH"};
    List<String> ccs = Arrays.asList(iso8601);

    // List of 100+ Locale combinations
    List<Locale> localeList = Arrays.asList(Locale.getAvailableLocales());

    // Filter out ones from our Country code list
    List<Locale> locales = localeList.stream().filter(ll -> ccs.contains(ll.getCountry()))
        .collect(Collectors.toList());

    // Should be 12
    assertTrue(locales.size() == 12);

    locales.stream().forEach(cc -> System.out.println(cc));
  }

  


  @Test
  public void testStreamingCharsToStringBuffer_forEach() {

    String[] stringArr = {"a", "b", "c"};

    List<String> lOfS = Arrays.asList(stringArr);

    StringBuffer sb = new StringBuffer();

    lOfS.stream().forEach(s -> sb.append(s));

    assertEquals(sb.toString(), "abc");

  }

  @Test
  public void testLambdaWithOneArg() {

    File f = Mockito.mock(File.class);

    File[] fileList = {new File("a.txt"), new File("aa.txt"), new File("aaa.txt")};

    Mockito.when(f.listFiles(Mockito.isA(FileFilter.class))).thenReturn(fileList);


    File[] result = f.listFiles(file -> file.getName().startsWith("a"));

    assertTrue(result.length == 3);

  }


  @Test
  public void testRunnableLambda() {
    Runnable r = Mockito.mock(Runnable.class);


    doNothing().when(r).run();
    new Thread(() -> r.run()).start();

    verify(r, times(1)).run();


  }


}
