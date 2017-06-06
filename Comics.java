
public class Comics
{
   String title, writer, artist,publisher;
   int issue, posInArray;

   public int getPosInArray()
   {
      return posInArray;
   }

   public void setPosInArray(int posInArray)
   {
      this.posInArray = posInArray;
   }
public Comics()
{
   
}
   public Comics(String title, int issue, String writer, String artist,String publisher,int posInArray)
   {
      this.title = title;
      this.issue = issue;
      this.writer = writer;
      this.artist = artist;
      this.publisher=publisher;
      this.posInArray= posInArray;
   }

   public String getWriter()
   {
      return writer;
   }

   public void setWriter(String writer)
   {
      this.writer = writer;
   }

   public String getArtist()
   {
      return artist;
   }

   public void setArtist(String artist)
   {
      this.artist = artist;
   }

   public int getIssue()
   {
      return issue;
   }

   public void setIssue(int issue)
   {
      this.issue = issue;
   }
   public String getPublisher()
   {
      return publisher;
   }
   public void setPublisher(String publisher)
   {
      this.publisher = publisher;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }
   public void printdetails()
   {
      
      System.out.printf("%-50s %-20d %-50s %-50s %-15s\n",getTitle(),getIssue(),getWriter(),getArtist(),getPublisher());
      
      //System.out.printf("%12s%-10s\n","Pos in Array : ",getPosInArray());
   }


}
