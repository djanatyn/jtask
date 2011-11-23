import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Prompt
{
  public static int prompt()
  {
    System.out.print("> ");
    Scanner input = new Scanner(System.in);

    String in = input.nextLine();
    if (in.equals("quit"))   return 0;
    if (in.equals("add"))    return 1;
    if (in.equals("remove")) return 2;
    if (in.equals("list"))   return 3;
    if (in.equals("save"))   return 4;
    if (in.equals("toggle"))  return 5;
    if (in.equals("purge"))  return 6;
    else return 7;
  }
  
  public static List<Task> toggleItem(List<Task> list)
  {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("Which entry?");
      System.out.print("> ");
    
      int choice = input.nextInt();

      if ((choice < list.size()) && (choice > 0)) {
	System.out.println("Removed '" + (list.get(choice)).title() + "'.");
	list.remove(choice);
	return list;
      } else System.out.println("Error - enter a value between 1 and " + list.size() + ".");
    }
  }

  public static Boolean quit(Boolean saved)
  {
    Boolean done = false;
    if (saved) done = true;
    System.out.println("File not saved. Save before quitting? [Y/N]");
    while (!done) {
      System.out.print("> ");
      Scanner in = new Scanner(System.in);
      String choice = in.nextLine();
      if (choice.toLowerCase().equals("y")) return true;
      if (choice.toLowerCase().equals("n")) done = true;
      else System.out.println("Error - please enter Y or N.");
    }
    return false;
  }

  public static Task add()
  {
    System.out.println("added task");
    return new Task("sweep stairs","get rid of the dust",false);
  }

  public static int remove(List<Task> list)
  {
    System.out.println("removed stuff");
    return 0;
  }

  public static void list(List<Task> list)
  {
    System.out.println("listed stuff");
  }
}