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
  
  public String toString()
  {
    return (task + "\n" + description + "\n" + done + "\n");
  }
  
  public Boolean complete()
  {
    if (done) return true;
    return false;
  }

  public String title()
  {
    return task;
  }

  public void toggle()
  {
    if (done) done = false;
    else done = true;
  }

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