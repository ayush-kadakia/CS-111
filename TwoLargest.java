public class TwoLargest
{
  public static void main(String[] args)
  {
    System.out.println("Enter terminating value:");
    double term = IO.readDouble();

    int counter = 1;
    boolean lol = true;
    double max = Integer.MIN_VALUE;
    double max2= Integer.MIN_VALUE;

    System.out.println("Enter values:");

    while(lol){
      double num = IO.readDouble();

      if(num == term && counter <= 2){
        IO.reportBadInput();
        continue;
      }
      else if(num == term && counter > 2)
        lol = false;

      else if(num>max){
           max2=max;
           max=num;
         }

      else if(num>max2)
           max2=num;
       counter++;
    }

    IO.outputDoubleAnswer(max);
    IO.outputDoubleAnswer(max2);
  }
}
