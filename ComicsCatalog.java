import java.util.*;

public class ComicsCatalog
{
   private static final Comics[] comicsissues = new Comics[1000];
   private static int arrayCount = 0;
   private final static Scanner sc = new Scanner(System.in);

   public static void main(String[] args)
   {

      char select;
      do
      {
         System.out.println();
         printMenu();
         select = sc.nextLine().toUpperCase().charAt(0);

         // Show if story is an arc and what number in arc it is
         // add a connection to another issue that is connected to this story
         // show issue show where story continues

         switch (select)
         {

         case 'A':
            addComic();
            break;
         case 'B':
            titleSearch();
            break;
         case 'C':
            writerSearch();
            break;
         case 'D':
            artistSearch();
            break;
         case 'E':
            changeDetails();
            break;
         case 'F':
            printComicsList();
            break;
         case 'X':
            System.out.println("Exiting System");
            break;
         default:
            System.out.println("Not a valid menu option");
            System.out.println();
         }

      } while (select != ('X'));

   }

   // Displays column titles for details
   private static void menuHeader()
   {
      System.out.printf("%-50s%-20s%-50s%-50s%-15s\n", "Tile", "Issue",
            "Writer", "Artist", "Publisher");

   }

   private static void printMenu()
   {
      System.out.println("A: Add Another Comic");
      System.out.println("B: Search For Title");
      System.out.println("C: Search For Writer");
      System.out.println("D: Search For Artist");
      System.out.println("E: Change Comic Info");
      System.out.println("F: Print Comic List");
      System.out.println("x: Exit");
   }

   // adds comic details then builds object of either other marvel or Dc
   public static void addComic()
   {
      System.out.println("Add Comics Title");
      String title = sc.nextLine();
      boolean valid = false;
      // make sure int is inputed
      int issue = 0;
      do
      {
         try
         {
            System.out.println("Add Comics Issue Number");
            issue = Integer.parseInt(sc.nextLine());
            valid = true;
         } catch (Exception e)
         {
            System.out.println(" Invalid input");
            System.out.println();
         }
      } while (!valid);
      System.out.println("Add Comics Writer");
      String writer = sc.nextLine();
      System.out.println("Add Comics Artist");
      String artist = sc.nextLine();
      System.out.println("Enter Publisher");
      String publisher = null;
      String Ref = null;
      do
      {
         Ref = selectPublisher(publisher);
      } while (Ref == null);
      // track where it is store in array
      int count = arrayCount;
      // create object based on what company publishes it
      if (Ref.equals("Marvel"))
      {
         comicsissues[arrayCount++] = new Marvel(title, issue, writer, artist,
               publisher, count);
         Comics arrayRef = comicsissues[count];
         menuHeader();
         arrayRef.printdetails();
      }
      else if (Ref.equals("Dc"))
      {
         comicsissues[arrayCount++] = new Dc(title, issue, writer, artist,
               publisher, count);
         Comics arrayRef = comicsissues[count];
         menuHeader();
         arrayRef.printdetails();
      }
      else if (Ref.equals("Other"))
      {
         System.out.println("Who is the publisher of this Tile");
         publisher = sc.nextLine();
         comicsissues[arrayCount++] = new MiscellaneousComicPublishers(title,
               issue, writer, artist, publisher, count);
         Comics arrayRef = comicsissues[count];
         menuHeader();
         arrayRef.printdetails();
      }

   }

   private static void changeDetails()
   {
      int posInArray;
      System.out.println(
            "Select menu number For comic you wish to change the details for");
      for (int i = 0; i < arrayCount; i++)
         comicsissues[i].printdetails();
      posInArray = Integer.parseInt(sc.nextLine());
      {
         menuHeader();
         comicsissues[posInArray].printdetails();
         // select The comic from its array//f

      }

   }

   // search array based on title
   private static void artistSearch()
   {
      System.out.println("What is artist you are looking for ?");
      String artistsName = sc.nextLine();
      for (int i = 0; i < arrayCount; i++)
      {
         if (comicsissues[i].getArtist().contains(artistsName))
         {
            comicsissues[i].printdetails();
         }
         else
         {
            System.out.println("No Writer Found");
         }
      }

   }

   // search array based on titles writer
   private static void writerSearch()
   {
      System.out.println("What Writer are looking for ?");
      String writersName = sc.nextLine();
      for (int i = 0; i < arrayCount; i++)
      {
         if (comicsissues[i].getWriter().contains(writersName))
         {
            comicsissues[i].printdetails();
         }
         else
         {
            System.out.println("No Writer Found");
         }
      }
   }

   // search array based on title name
   private static void titleSearch()
   {
      System.out
            .println("What is the title of the comic you are looking for ?");
      String comicTitle = sc.nextLine();
      menuHeader();
      for (int i = 0; i < arrayCount; i++)
      {
         if (comicsissues[i].getTitle().contains(comicTitle))
         {
            comicsissues[i].printdetails();
         }
         else
         {
            System.out.println("No Title Found");
         }
      }
   }

   private static String selectPublisher(String company)
   {
      System.out.println("Select The Company That Publishes This Comic");
      System.out.println("Marvel (1)");
      System.out.println("Dc       (2)");
      System.out.println("Other   (3)");

      int selection;
      boolean valid = false;
      do
      {
         try
         {
            selection = Integer.parseInt(sc.nextLine());
            if (selection == 1)
            {
               valid = true;
               return company = "Marvel";

            }
            else if (selection == 2)
            {
               valid = true;
               return company = "Dc";
            }
            else if (selection == 3)

            {
               valid = true;
               return company = "Other";
            }
            else
            {
               System.out.println("Invalid input Try Again");
               System.out.println();
            }
         } catch (Exception e)
         {
            System.out.println("Invalid input Try Again");
            System.out.println();
         }
      } while (valid == false);
      return null;
   }

   private static void printComicsList()
   {
      System.out.println("Select Company you wish to List ");
      String publisher = null;
      String Ref;
      do
      {
         Ref = selectPublisher(publisher);
      } while (Ref == null);
      if (Ref.equals("Marvel"))
      {
         printMarvelList();
      }
      else if (Ref.equals("Dc"))
      {
         printDcList();
      }
      else if (Ref.equals("Other"))
      {
         printOtherList();
      }
   }

   private static void printMarvelList()
   {
      for (int i = 0; i < arrayCount; i++)
      {
         Comics comicRef = comicsissues[i];
         if (comicRef instanceof Marvel)
         {
            comicsissues[i].printdetails();
         }
      }
   }

   private static void printDcList()
   {
      for (int i = 0; i < arrayCount; i++)
      {
         Comics comicRef = comicsissues[i];
         if (comicRef instanceof Dc)
         {
            comicsissues[i].printdetails();
         }
      }
   }

   private static void printOtherList()
   {
      for (int i = 0; i < arrayCount; i++)
      {
         Comics comicRef = comicsissues[i];
         if (comicRef instanceof Comics)
         {
            comicsissues[i].printdetails();
         }
      }
   }
}
