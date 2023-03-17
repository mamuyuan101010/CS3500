package assigment4.model.filter;

/**
 * construct an enums of filter, containing every type of filter
 */
public enum Filter {
  Normal, RedComponent, GreenComponent, BlueComponent, BrightenValue, BrightenIntensity,
  BrightenLuma, DarkenValue, DarkenIntensity, DarkenLuma;
  public String toString() {
    switch(this) {
      case Normal:
        return "normal";
      case RedComponent:
        return "red-component";
      case GreenComponent:
        return "green-component";
      case BlueComponent:
        return "blue-component";
      case BrightenValue:
        return "brighten-value";
      case BrightenIntensity:
        return "brighten-intensity";
      case BrightenLuma:
        return "brighten-luma";
      case DarkenValue:
        return "darken-value";
      case DarkenIntensity:
        return "darken-intensity";
      case DarkenLuma:
        return "darken-luma";
      default:
        return "as";
    }
  }
}
