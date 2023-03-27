package assignment4.model.project;

import java.util.Map;

import assignment4.model.image.ImageModel;

/**
 * the project model interface.
 */
public interface ProjectModel {

  /**
   * put the imageModel to the project structure map.
   * @param name
   * @param component
   */
  public void put(String name, ImageModel component);

  /**
   * return the height of the image model.
   */
  public int getHeight();

  /**
   * return the width of the image model.
   * @return
   */
  public int getWidth();

  /**
   * return the max value of the image model.
   * @return
   */
  public int getMaxValue();

  /**
   * return a map of the current model structure.
   * @return
   */
  Map<String, ImageModel> getProjectStructure();

  /**
   * return the name of the project.
   * @return
   */
  String getProjectName();

  /**
   * set the height of this Project.
   * @param height is the given height.
   */
  void setHeight(int height);

  /**
   * set the width of this project.
   * @param width is the given width.
   */
  void setWidth(int width);

  /**
   * set the max value of this project.
   * @param maxValue is the given max value.
   */
  void setMaxValue(int maxValue);

  /**
   * set the project's name using the given string of name.
   */
  void setProjectName(String projectName);

  /**
   * set the project structure using the given map.
   * @param projectStructure
   */
  void setProjectStructure(Map<String, ImageModel> projectStructure);
}
