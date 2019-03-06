import java.util.Arrays;

public class Song
{
  private String name;
  private int year;
  private int numberOfWriters;
  private String[] writers = new String[50];
  private int rating;

  public static void main(String[] args)
  {
    Song a = new Song("a");
    Song b = new Song("a");
    System.out.println(a.getWriterAtIndex(0));

    a.addWriter("bob");
    a.addWriter("jack");
    b.addWriter("jack");
    b.addWriter("bob");

    a.setYear(2005);
    b.setYear(2005);
    System.out.println(a.equals(b));
  }

  public Song(String name){
    this.name = name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setYear(int year){
    this.year = year;
  }

  public int getYear(){
    return this.year;
  }

  public void setRating(int rating){
    this.rating = rating;
  }

  public int getRating(){
    return this.rating;
  }

  public void addWriter(String writerName){
    for(int i = 0; i < this.writers.length; i++){
      if(this.writers[i] == null){
        this.writers[i] = writerName;
        this.numberOfWriters++;
        break;
      }
    }
  }

  public String[] getWriters(){
    return this.writers;
  }

  public int getNumberOfWriters(){
    return this.numberOfWriters;
  }

  public String getWriterAtIndex(int index){
    return this.writers[index];
  }

  public String toString(){
    return name + "," + year + "," + rating;
  }


  public boolean equals(Object other){
    Song song = (Song)other;

    String[] a = new String[50];
    String[] b = new String [50];

    for(int i = 0; i < 50; i++){
      a[i] = this.getWriterAtIndex(i);
      b[i] = song.getWriterAtIndex(i);
    }

    for(int i = 0; i < 50; i++){
      if(a[i] == null)
        a[i] = "";
      if(b[i] == null)
        b[i] = "";
    }

    Arrays.sort(a);
    Arrays.sort(b);

    if(this.getName().equals(song.getName()) && Arrays.equals(a, b) && this.getYear() == song.getYear())
      return true;
    else
      return false;
  }

  public int compareTo(Song other){
    return this.getName().compareTo(other.getName());
  }

}
