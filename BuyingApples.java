   public class BuyingApples
{
  public static void main(String[] args)
  {
    System.out.println("Enter cost per LB:");
    double costPerPound = IO.readDouble();

    System.out.println("Enter number of pounds:");
    double numberOfPounds = IO.readDouble();

    if(costPerPound >= 0 && numberOfPounds >= 0)
      IO.outputDoubleAnswer(costPerPound * numberOfPounds);
    else
      IO.reportBadInput();

  }
}
