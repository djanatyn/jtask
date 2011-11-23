import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class JTask
{
  public static void list(List<Task> list)
  {
    System.out.println("Listed");
  }

  public static void saveList(List<Task> list) throws
    FileNotFoundException
  {
    System.out.println("Saving...");
    PrintWriter file = new PrintWriter("todo.txt");
    Iterator it = list.iterator();

    while (it.hasNext()) file.println(((Task)it.next()).toString());
  }
  
  public static void toggleItem(List<Task> list)
  {
    
  }

  public static List<Task> purgeItems(List<Task> list)
  {
    System.out.println("Purging completed tasks...");
    Iterator it = list.iterator();
    for (int i = 0; it.hasNext(); i++) {
      Task task = (Task)it.next();
      if (task.complete()) list.remove(i);
    }
    return list;
  }

  public static void main(String[] args) throws
    FileNotFoundException
  {
    List<Task> taskList = new ArrayList<Task>();
    FileReader reader = new FileReader("todo.txt");
    Scanner file = new Scanner(reader);
    Scanner input = new Scanner(System.in);

    while (file.hasNextLine()) {
      String task = file.nextLine();
      String description = file.nextLine();
      Boolean done = file.nextBoolean();
      file.nextLine();
      if (file.hasNextLine()) file.nextLine();
      taskList.add(new Task(task, description,done));
    }
    
    System.out.println("todo list (type 'help' for commands)");
    Boolean quit = false;
    Boolean saved = false;
    while (!quit) {
      switch (Prompt.prompt())
	{
	case 0: 
	  if (Prompt.quit(saved)) saveList(taskList);
	  quit = true;
	  break;
	case 1: taskList.add(Prompt.add()); break;
	case 2: taskList.remove(Prompt.remove(taskList)); break;
	case 3: list(taskList); break;
	case 4:
	  saveList(taskList);
	  saved = true;
	  break;
	case 5: taskList = Prompt.toggleItem(taskList); break;
	case 6: taskList = purgeItems(taskList); break;
	}
    }
  }
}