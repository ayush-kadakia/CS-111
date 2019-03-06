public class Zoo
{
  public static void main(String[] args)
  {
    System.out.println("Enter number of Zoos:");
    int numberOfZoos = IO.readInt();
    int numGiraffesSum = 0;
    int numLionsSum = 0;
    int numSnakesSum = 0;
    for (int counter = 1; counter <= numberOfZoos; counter++)
      {
        System.out.println("Enter number of giraffes for zoo " + counter);
        int numOfGiraffes = IO.readInt();
        numGiraffesSum += numOfGiraffes;

        System.out.println("Enter number of lions for zoo " + counter);
        int numOfLions = IO.readInt();
        numLionsSum += numOfLions;

        System.out.println("Enter number of snakes for zoo " + counter);
        int numOfSnakes = IO.readInt();
        numSnakesSum += numOfSnakes;
      }

      IO.outputIntAnswer(numGiraffesSum);
      IO.outputIntAnswer(numLionsSum);
      IO.outputIntAnswer(numSnakesSum);


  }
}
