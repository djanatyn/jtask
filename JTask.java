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
    Iterator it = list.iterator();
    int i = 0;

    while (it.hasNext()) {
      System.out.print(i + ". ");
      ((Task)it.next()).describe();
      i++;
    }
  }

  public static void help()
  {
    System.out.println("available commands:");
    System.out.println("add    - adds a todo item");
    System.out.println("remove - remove a todo item");
    System.out.println("list   - list all items");
    System.out.println("save   - save changes to file");
    System.out.println("toggle - change status of item");
    System.out.println("purge  - remove all completed tasks");
  }

  public static void saveList(List<Task> list) throws
    FileNotFoundException
  {
    System.out.println("Saving...");
    PrintWriter file = new PrintWriter("todo.txt");
    Iterator it = list.iterator();

    while (it.hasNext()) file.println(((Task)it.next()).toString());

    file.close();
  }
  
  public static List<Task> purgeItems(List<Task> list)
  {
    System.out.println("Purging completed tasks...");

    Iterator it = list.iterator();
    for (int i = 0; i <= list.size(); i++) {
      Task task = list.get(i);
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

    file.close();
    
    System.out.println("todo list (type 'help' for commands)");
    Boolean quit = false;
    Boolean saved = true;
    while (!quit) {
      switch (Prompt.prompt(saved))
	{
	case 0: 
	  if (Prompt.quit(saved)) saveList(taskList);
	  quit = true;
	  break;
	case 1: taskList.add(Prompt.add()); saved = false; break;
	case 2: taskList.remove(Prompt.remove(taskList)); saved = false; break;
	case 3: list(taskList); break;
	case 4:
	  saveList(taskList);
	  saved = true;
	  break;
	case 5: taskList = Prompt.toggle(taskList); saved = false; break;
	case 6: taskList = purgeItems(taskList); break;
	case 7: help();
	case 8: System.out.println("Error - please enter a proper command");
	}
    }
  }
}