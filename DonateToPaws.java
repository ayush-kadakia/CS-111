public class DonateToPaws
{
  public static void main(String[] args)
  {
    System.out.println("Enter donation amount:");
    double input = IO.readDouble();
    IO.outputDoubleAnswer(donationFee(input));
  }

  public static double donationFee (double donationAmount)
  {
    double fee = 0;
    if(donationAmount <= 0)
      fee = 0;
    else if(donationAmount <= 150)
      fee = 3;
    else if(donationAmount < 1500){
      double a = .04*donationAmount;
      double b = 8;
      if(a>b)
        fee = a;
      else
        fee = b;
    }
    else if(donationAmount < 15000){
      double a = .01*donationAmount;
      double b = 20;
      if(a>b)
        fee = a;
      else
        fee = b;
    }
    else{
      double temp = donationAmount - 15000;
      double temp2 = temp - 4000;

      if(temp2>=0)
        fee= 230+.03*temp2;
      else
        fee= 150+.02*temp;
    }
      return(fee);

  }
}
