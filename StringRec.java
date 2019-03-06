public class StringRec
{
  public static void main(String[] args)
  {
    String original = IO.readString();
    System.out.println(decompress(original));
  }

  public static String decompress(String compressedText){
    if (compressedText.length() == 0)
        return "";
        else if (Character.isLetter(compressedText.charAt(0)))
        return Character.toString(compressedText.charAt(0)) + decompress(compressedText.substring(1));
    else if (Character.isDigit(compressedText.charAt(0)))
        return String.format("%0" + compressedText.charAt(0) + "d", 0).replace('0', compressedText.charAt(1)) + decompress(compressedText.substring(2));
    else
        return compressedText;
}
    }
