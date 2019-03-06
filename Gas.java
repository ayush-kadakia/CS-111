    public class Gas
{
	public static void main(String[] args)
  {
      System.out.println("Enter cost of gallon of gas:");
      double a = IO.readDouble();

      System.out.println("Enter number of gallons:");
      double b = IO.readDouble();

      System.out.println("Is customer paying with a credit card?");
      boolean c = IO.readBoolean();

      if(a >= 0 && b >= 0)
        if(c)
          IO.outputDoubleAnswer(a * b * 1.1);
        else
          IO.outputDoubleAnswer(a * b);
      else
        IO.reportBadInput();
  }
}
