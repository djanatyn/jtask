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
    Boolean saved = true;
    while (!quit) {
      saved = false;
      System.out.print("> ");
      String in = input.nextLine();
      if (in.equals("quit")) {
	if (saved) quit = true;
	else {
	  Boolean done = false;
	  quit = true;
	  while (!done) {
	    System.out.println("Save before quitting? [Y/N/(C)ancel]");
	    System.out.print("> ");
	    in = input.nextLine();
	    done = true;
	    if (in.toLowerCase().equals("y")) System.out.println("Saving...");
	    else if (in.toLowerCase().equals("n")) System.out.println("Quitting...");
	    else if (in.toLowerCase().equals("c")) {
	      System.out.println("Quit canceled.");
	      quit = false;
	    } else {
	      System.out.println("Error - please enter Y, N, or C.");
	      done = false;
	    }
	  }
	}
      }
    }
  }
}