import java.util.Scanner;

public class Prompt
{
  public static int prompt()
  {
    System.out.print("> ");
    Scanner in = new Scanner(System.in);

    if (in.equals("quit"))   return 0;
    if (in.equals("add"))    return 1;
    if (in.equals("remove")) return 2;
    if (in.equals("list"))   return 3;
    if (in.equals("save"))   return 4;
    if (in.equals("togle"))  return 5;
    if (in.equals("purge"))  return 6;
  }
  public static int quit(Boolean saved)
  {
    if (saved) return false;
    else {
      System.out.println("File not saved. Save before quitting? [Y/N]");
      Scanner in = new Scanner(System.in);
      String choice = in.nextLine();
      if (choice.toLowerCase.equals("y")) return true;
      if (choice.toLowerCase.equals("n")) return false;
      System.out.println("Error - please enter Y or N.");
      quitGame(saved);
    }
  }
}
    