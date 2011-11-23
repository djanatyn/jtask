public class Task
{
  private String task;
  private int date;
  private String description;
  
  public Task(String myTask, int myDate, String myDesc)
  {
    task = myTask;
    description = myDesc;
    date = myDate;
  }
  
  public String toString()
  {
    return (task + "\n" + date + "\n" + description + "\n");
  }
}