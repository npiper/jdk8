package neilpiper.me.jdktrial;

import java.util.List;
import java.util.function.Predicate;


public interface Searchable<T,Y> {
  
  
  /** Search by the criteria of a Predicate, the predicate is applied as a search criteria
   * where a 'true' result of the predicate adds entries to the result set <T>.
   * 
   * @param sc Search criteria
   * @return List of <T> types representing the search result.
   */
  public List<T> searchByCriteria(Predicate<Y> sc);

}
