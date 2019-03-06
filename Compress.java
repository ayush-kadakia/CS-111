public class Compress
{
  public static void main(String[] args)
  {
    String original = IO.readString();
    System.out.println(compress(original));
  }

  public static String compress(String original){
      String result = "";
      int n = 1;
      for(int i = 0; i < original.length()-1; i++){
        char letter = original.charAt(i);



        if(letter == original.charAt(i+1))
            n++;

        else if(n>1){
        result += Integer.toString(n) + letter;
        n = 1;
        }
        else result+=letter;
        }

        if(original.length() == 0)
          result = "";
        else if(original.length() >1 && original.charAt(original.length()-1) == original.charAt(original.length()-2))
          result += Integer.toString(n) + original.charAt(original.length()-1);
          else
          result += original.charAt(original.length()-1);

      return result;
  }
}
