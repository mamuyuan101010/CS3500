package assigment4.controller.commands;

import java.util.List;
import java.util.Scanner;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.filter.Filter;
import assigment4.model.layer.Layer;

public class SetFilterCommand extends AbstractCommand{
  /**
   * Constructs an Abstract command.
   *
   * @param sc
   */
  public SetFilterCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(CollagerProject c) throws IllegalStateException {
    String FilterName = this.getString();
    int layerSize = c.getLayers().size();
    switch(FilterName) {
      case "normal":
        c.getLayers().get(layerSize - 1).setFilter(Filter.Normal);
      case "red-component":
        c.getLayers().get(layerSize - 1).setFilter(Filter.RedComponent);
      case "green-component":
        c.getLayers().get(layerSize - 1).setFilter(Filter.GreenComponent);
      case "blue-component":
        c.getLayers().get(layerSize - 1).setFilter(Filter.BlueComponent);
      case "brighten-value":
        c.getLayers().get(layerSize - 1).setFilter(Filter.BrightenValue);
      case "brighten-intensity":
        c.getLayers().get(layerSize - 1).setFilter(Filter.BrightenIntensity);
      case "brighten-luma":
        c.getLayers().get(layerSize - 1).setFilter(Filter.BrightenLuma);
      case "darken-value":
        c.getLayers().get(layerSize - 1).setFilter(Filter.DarkenValue);
      case "darken-intensity":
        c.getLayers().get(layerSize - 1).setFilter(Filter.DarkenIntensity);
      case "darken-luma":
        c.getLayers().get(layerSize - 1).setFilter(Filter.DarkenLuma);
    }
  }
}
