/*
*
* This class implements a library of songs
*
* @author CS111 - Rutgers University
*
*/
public class SongApp {

  private Song[] items;      // keep Songs in an unsorted array
  private int numberOfItems; // number of Songs in the array

  /*
  * Default constructor creates array with capacity for 5 Songs
  */
  SongApp () {
      // ADD YOUR CODE HERE
      items = new Song[5];
      numberOfItems = 0;
  }

  /*
  * One argument constructor creates array with user defines capacity
  *
  * @param capacity defines the capacity of the Song library
  */
  SongApp (int capacity) {
      // ADD YOUR CODE HERE
      items = new Song[capacity];
      numberOfItems = 0;
  }

  /*
  * Add a Song into the library (unsorted array)
  *
  * If the library is full (there is not enough space to add another Song)
  *   - create a new array with double the size of the current array.
  *   - copy all current Songs into new array
  *   - add new Song
  *
  * @param m The Song to be added to the libary
  */
  public void addSong (Song m) {
      // ADD YOUR CODE HERE
      if(this.numberOfItems < items.length){
        items[numberOfItems] = m;
        numberOfItems++;
      }
      else{
        Song [] items2 = new Song[items.length * 2];
        for(int i = 0; i < items.length; i++){
          items2[i] = items[i];
        }
        items2[numberOfItems] = m;
        numberOfItems++;
        items = items2;
      }
  }

  /*
  * Removes a Song from the library. Returns true if Song is removed, false
  * otherwise.
  * The array should not become sparse after a remove, that is, all Songs
  * should be in consecutive indexes in the array.
  *
  * @param m The Song to be removed
  *
  */
  public boolean removeSong (Song m) {
      // ADD YOUR CODE HERE
      boolean ret = false;
      int i;
      for(i = 0; i < numberOfItems; i++){
        if(items[i].equals(m)){
          items[i] = null;
          ret = true;
          numberOfItems--;
          break;
          }
        }

        for(int j = i; j< numberOfItems; j++){
          if(items[j+1] != null){
            items[j] = items[j+1];
            items[j+1] = null;
          }
        }
        return ret;

      }



  /*
  * Returns the library of songs
  *
  * @return The array of Songs
  */
  public Song[] getSongs () {
      // ADD YOUR CODE HERE
      return this.items;
  }

  /*
  * Returns the current number of Songs in the library
  *
  * @return The number of items in the array
  */
  public int getNumberOfItems () {
      // ADD YOUR CODE HERE
      return this.numberOfItems;
  }

  /*
  * Update the rating of Song @m to @rating
  *
  * @param @m The Song to have its ratings updated
  * @param @rating The new rating of @m
  * @return tue if update is successfull, false otherwise
  *
  */
  public boolean updateRating (Song m, int rating) {
      // ADD YOUR CODE HERE
      for(int i = 0; i< numberOfItems; i++){
        if(items[i].equals(m)){
          items[i].setRating(rating);
          return true;
        }
      }
      return false;

  }

  /*
  * Prints all Songs
  */
  public void print () {
      // ADD YOUR CODE HERE
      for(int i = 0; i< this.numberOfItems; i++)
        System.out.println(items[i]);
  }

  /*
  * Return all the Songs by @songwriter. The array size should be the
  * number of Songs by @songwriter.
  *
  * @param songwriter The songwriter's name
  * @param An array of all the Songs by @songwriter
  *
  */
  public Song[] getSongsBySongwriter (String songwriter) {
      // ADD YOUR CODE HERE
      int counter = 0;
      for(int i = 0; i < numberOfItems; i++){
        for(int j = 0; j < items[i].getNumberOfWriters(); j++)
          if(items[i].getWriterAtIndex(j).equals(songwriter))
            counter++;
      }

      Song res[] = new Song[counter];

      int num = 0;
      for(int k = 0; k< numberOfItems; k++){
        for(int l = 0; l < items[k].getNumberOfWriters(); l++)
        if(items[k].getWriterAtIndex(l).equals(songwriter)){
          res[num] = items[k];
          num++;
        }
      }

      return res;
  }

  /*
  * Return all the Songs released in @year. The array size should be the
  * number of Songs made in @year.
  *
  * @param year The year the Songs were made
  * @return An array of all the Songs made in @year
  *
  */
  public Song[] getSongsByYear (int year) {
      // ADD YOUR CODE HERE
      int count = 0;
      for(int i = 0; i < numberOfItems; i++){
        if(items[i].getYear() == year)
          count++;
      }

      Song[] res = new Song[count];
      int num = 0;
      for(int i=0; i< numberOfItems; i++){
        if(items[i].getYear() == year){
          res[num] = items[i];
          num++;
        }
      }
      return res;
  }

  /*
  * Return all the Songs with ratings greater then @rating
  *
  * @param rating
  * @return An array of all Songs with rating greater than @rating
  *
  */
  public Song[] getSongsWithRatingsGreaterThan (int rating) {
      // ADD YOUR CODE HERE
      int count = 0;
      for(int i = 0; i < numberOfItems; i++){
        if(items[i].getRating() > rating)
          count++;
      }

      Song[] res = new Song[count];
      int num = 0;
      for(int i=0; i< numberOfItems; i++){
        if(items[i].getRating() > rating){
          res[num] = items[i];
          num++;
        }
      }
      return res;
  }

  /*
  * Search for Song name @name using binary search algorithm.
  * Assumes items is sorted
  */
  public Song searchSongByName (String name) {
      // ADD YOUR CODE HERE
      int l = 0;
      int r = numberOfItems - 1;

      while(l <= r){
        int m = l + (r-l)/2;

        if(items[m].getName().equals(name))
          return items[m];

        if(items[m].getName().compareTo(name) < 0)
          l = m + 1;

        else
          r = m - 1;
      }
      return null;

  }

 /*
  * Sorts Songs by year using insertion sort
  */
  public void sortByYear () {
      // ADD YOUR CODE HERE
      int n = items.length;
      for(int i = 1; i < n; i++)
      {
        Song key = items[i];
        int j = i-1;

        while(j>=0 && items[j].getYear() > key.getYear())
        {
          items[j+1] = items[j];
          j = j-1;
        }
        items[j+1] = key;
      }
  }

 /*
  * Sorts array of Songs by name using selection sort
  */
  public void sortByName () {
      // ADD YOUR CODE HERE
      int n = items.length;
      for(int i = 0; i< n-1; i++){
        int m = i;
        for(int j = i+1; j<n; j++)
          if(items[j].compareTo(items[m]) < 0)
            m = j;

        Song temp = items[m];
        items[m] = items[i];
        items[i] = temp;

      }


  }

 /*
  * Search for Song name using recursive linear search
  * @param name The name of the song to search
  * @param Songs The array containing all songs
  * @param l The left index
  * @param r The right index
  * @return The song with name @name or null if song is not found
  */
  public static Song searchSongByName (String name, Song[] Songs, int l, int r) {
      // ADD YOUR CODE HERE
      if (r<1)
        return null;
      if(Songs[l].getName().equals(name))
        return Songs[l];
      if(Songs[r].getName().equals(name))
          return Songs[r];
      return searchSongByName(name, Songs, l+1, r-1);
  }
}
