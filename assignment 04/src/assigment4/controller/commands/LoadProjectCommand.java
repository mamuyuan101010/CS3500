package assigment4.controller.commands;

import java.util.List;
import java.util.Scanner;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.layer.Layer;

public class LoadProjectCommand extends AbstractCommand{
  public LoadProjectCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(CollagerProject c) throws IllegalStateException {

  }
}
