package assignment4.model.project;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import assignment4.model.image.ImageModel;

/**
 * simple project model that implements the projectModel.
 */
public class SimpleProjectModel implements ProjectModel {

  private int height;

  private int width;

  private int maxValue;

  private String projectName;

  private Map<String, ImageModel> projectStructure;


  /**
   * constructor of simple project model.
   * this constructor intake nothing.
   */
  public SimpleProjectModel() {
    this.height = 0;
    this.width = 0;
    this.maxValue = 0;
    this.projectName = null;
    this.projectStructure = new LinkedHashMap<>();

  }

  /**
   * constructor of simple project model that
   * intake height, width and max value.
   * @param height
   * @param width
   * @param maxValue
   */
  public SimpleProjectModel(int height, int width, int maxValue) {
    this.height = height;
    this.width = width;
    this.maxValue = maxValue;
    this.projectName = "";
    this.projectStructure = new LinkedHashMap<>();
  }

  /**
   * constructor of simple project model that
   * intake height, width, max value, and the project name.
   * @param height
   * @param width
   * @param maxValue
   * @param projectName
   */
  public SimpleProjectModel(int height, int width, int maxValue, String projectName) {
    this.height = height;
    this.width = width;
    this.maxValue = maxValue;
    this.projectName = projectName;
    this.projectStructure = new LinkedHashMap<>();
  }

  /**
   * put given string and image model to the map of project structure.
   * @param name
   * @param component
   */
  @Override
  public void put(String name, ImageModel component) {
    this.projectStructure.put(name, component);
  }

  /**
   * return the height of the project.
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * return the width of the project.
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * return the max value of the project.
   */
  @Override
  public int getMaxValue() {
    return this.maxValue;
  }

  /** return the get project structure map of the project.
   */
  @Override
  public Map<String, ImageModel> getProjectStructure() {
    return this.projectStructure;
  }

  @Override
  public String getProjectName() {
    String output = this.projectName;
    return output;
  }


  /** set the height of the project using the given height.
   * @param height is the given height.
   */
  @Override
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * set the width of the project using the given width.
   * @param width is the given width.
   */
  @Override
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * set the max value of the project using the given max value.
   * @param maxValue is the given max value.
   */
  @Override
  public void setMaxValue(int maxValue) {
    this.maxValue = maxValue;
  }

  /**
   * set the name of the project using the given project name.
   * @param projectName
   */
  @Override
  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  /**
   * set the structure of the project using the given map.
   * @param projectStructure
   */
  @Override
  public void setProjectStructure(Map<String, ImageModel> projectStructure) {
    this.projectStructure = projectStructure;
  }
}
