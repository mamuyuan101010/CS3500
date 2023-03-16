package assigment4.model.filter;

public class SimpleFilter implements Filter{
  enum Filter {
    Normal, RedComponent, GreenComponent, BlueComponent, BrightenValue, BrightenIntensity,
    BrightenLuma, DarkenValue, DarkenIntensity, DarkenLuma
  }
}
