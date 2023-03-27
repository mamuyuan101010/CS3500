package assignment4.controller.commands;

import java.io.IOException;
import java.util.Scanner;

import assignment4.adapters.output.ProjectViewAdapter;
import assignment4.adapters.output.ViewAdapter;
import assignment4.model.project.ProjectModel;

/**
 * save-project-command class save the project as a project file
 */
public class SaveProjectCommand extends AbstractCommand{

  /**
   * constructor of save-project-command
   * @param sc is a scanner that scan the input
   */
  public SaveProjectCommand(Scanner sc) {
    super(sc);
  }

  /**
   * execute the command to the given project, saving the file as a project text file
   * @param projectModel a models for the command to work on.
   * @throws IllegalStateException
   */
  @Override
  public void apply(ProjectModel projectModel) throws IllegalStateException {
    String fileName = this.getString();
    ViewAdapter viewAdapter = new ProjectViewAdapter(projectModel);
    try {
      viewAdapter.write(fileName);
    } catch (IOException e) {

    }
  }
}
