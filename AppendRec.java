public class AppendRec
{
  public static void main(String[] args)
  {
      int n = IO.readInt();
      String original = IO.readString();
      System.out.println(appendNTimes(original, n));
  }
  public static String appendNTimes(String original,int n){
    if(n == 0)
    return original;
    else
    return original + appendNTimes(original, n -1);
  }
}
