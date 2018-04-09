import java.io.*;

public class CryptoAnalysis {
  BufferedReader bufferedReader;
  private int L0, R0, L4, R4;
  private int num_pairs = 200;
  private String plaintext[] = new String[num_pairs];
  private String cyphertext[] = new String[num_pairs];

  int getBit(int num, int n) { return (num >> (31-n)) & 1; }

  void splitPairs(int wordIndex) {
      L0 = (int) Long.parseLong(plaintext[wordIndex].substring(0,8), 16);
      R0 = (int) Long.parseLong(plaintext[wordIndex].substring(8), 16);
      L4 = (int) Long.parseLong(cyphertext[wordIndex].substring(0,8), 16);
      R4 = (int) Long.parseLong(cyphertext[wordIndex].substring(8), 16);
  }

  void readKnownTextPairs(String fileName) throws IOException {
      bufferedReader = new BufferedReader(new FileReader(fileName));
      int count = 0;
      boolean isPlainText = true;
      String line = bufferedReader.readLine();

      while(line != null && count < plaintext.length) {
          if(line.length() != 0) {
              if(isPlainText) {
                  plaintext[count] = line.substring(12);
              }
              else {
                  cyphertext[count] = line.substring(12);
                  count++;
              }
              isPlainText = !isPlainText;
          }
          line = bufferedReader.readLine();
      }
      bufferedReader.close();
  }

  int [] getSingleSplit() {
    int [] split = {L0, R0, L4, R4};
    return split;
  }

  String [][] getTextPairs() {
    String [][] pairs = {plaintext, cyphertext};
    return pairs;
  }
}
