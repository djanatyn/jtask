public class Task
{
  private String task;
  private String description;
  private Boolean done;
  
  public Task(String myTask, String myDesc, Boolean myDone)
  {
    task = myTask;
    description = myDesc;
    done = myDone;
  }

  /**
   * returns a string to write to a file for loading the object later
   * @return the string to write
   **/
  public String toString()
  {
    return (task + "\n" + description + "\n" + done + "\n");
  }
  
  /**
   * checks to see if the task is complete
   * @return whether or not the task is done
   **/
  public Boolean complete()
  {
    if (done) return true;
    return false;
  }

  /**
   * returns the title of the task
   * @return the task title/name
   **/
  public String title()
  {
    return task;
  }

  /**
   * toggles state of task between done and todo
   **/
  public void toggle()
  {
    if (done) done = false;
    else done = true;
  }

  /**
   * prints out the task
   **/
  public void describe()
  {
    String taskString;
    if (done) {
      System.out.println(task + " [X]");
      if (!description.equals("")) System.out.println("  - " + description);
    } else {
      System.out.println(task + " [ ]");
      if (!description.equals("")) System.out.println("  - " + description);
    }
  }
}