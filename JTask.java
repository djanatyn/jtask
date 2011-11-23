import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class JTask
{
  public static void main(String[] args) throws
    FileNotFoundException
  {
    List<Task> taskList = new ArrayList<Task>();
    FileReader reader = new FileReader("todo.txt");
    Scanner file = new Scanner(reader);
    Scanner input = new Scanner(System.in);

    while (file.hasNextLine()) {
      String task = file.nextLine();
      int date = file.nextInt();
      String description = file.nextLine();
      file.nextLine();
      if (file.hasNextLine()) file.nextLine();
      taskList.add(new Task(task, date, description));
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
	case 3: Prompt.list(taskList); break;
	case 4: saveList(taskList); break;
	case 5: toggleItem(taskList); break;
	case 6: purgeItems(taskList); break;
	}
    }
  }
}