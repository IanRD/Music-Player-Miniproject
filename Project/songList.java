/**
 * List of song titles and selection
 * 
 * @Ian Dawson
 * @v.1.0
 *
 */
public class songList
{
    //Declaration of the song list
    private String[] strSongName = new String[10];
    
    

    
    
  public void selectionSort(String[] strSongName) {
      //Song list
      String strUserInput = "";
      ArrayList al = new ArrayList();
         al.add("Everlong");
         al.add("Enough");
         al.add("Go");
         al.add("Learn to Fly");
         al.add("Test");
         al.add("Test");
         al.add("Test");
         al.add("Test");
         al.add("Test");
         al.add("Test");
      int i, j, minIndex, tmp;
      
      //Lists songs

        Iterator itr = al.iterator();
        if (al != null)
         {
            while (itr.hasNext())
            {
            System.out.println(itr.next());        
         }
        }
        //Gets user input
        Scanner blah = new Scanner(strUserInput);
        
        //Checks user input
        if (strUserInput == "y" || strUserInput == "Y")
             System.out.println("Your song will begin");   
        else if (strUserInput == "n" || strUserInput == "N")
             System.out.println("Get out");   
        else 
            System.out.println("Error");   
        }
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class bla
     */
    public songList()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
