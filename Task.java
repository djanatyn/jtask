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

}