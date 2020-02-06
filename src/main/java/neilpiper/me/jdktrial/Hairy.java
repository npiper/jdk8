package neilpiper.me.jdktrial;

/** Indicates if our object is Hairy.
 * 
 * @author neilpiper
 *
 */
public interface Hairy {

  
  public Integer getHairLengthInMilimetres(); 
  
  /** Grows some hair.
   * 
   */
  public void growHair();
  
  /** Gives our object a haircut.
   * 
   */
  public void haircut();
  
  default String getColour()
  {
    return "black";
  }
  
}
