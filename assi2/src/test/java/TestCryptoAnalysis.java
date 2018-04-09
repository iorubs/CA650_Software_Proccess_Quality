import java.io.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class TestCryptoAnalysis {

	@Test
	public void test_read_pairs() {
		CryptoAnalysis crypto = new CryptoAnalysis();
    try {
      crypto.readKnownTextPairs("/app/src/main/java/known.txt");

      String [][] pairs = crypto.getTextPairs();

      assertEquals(pairs[0][199], "aea129c37cc07d12");
      assertEquals(pairs[1][199], "c4d88584debf8c60");

      try {
        crypto.bufferedReader.ready();
        fail("Expected Buffer to be closed");
      }
      catch(IOException e) {}

    }
    catch(IOException e) {
      fail("Did not expect an Exception");
    }
	}

  @Test (expected = IOException.class)
	public void test_read_file_exception() throws IOException {
		CryptoAnalysis crypto = new CryptoAnalysis();
    crypto.readKnownTextPairs("invalid.txt");
	}

  @Test
  public void test_split_pairs() {
    CryptoAnalysis crypto = new CryptoAnalysis();
    try {
      crypto.readKnownTextPairs("/app/src/main/java/known.txt");
      crypto.splitPairs(0);

      int [] split = crypto.getSingleSplit();

      assertEquals(split[0], -1477322454);
      assertEquals(split[1], -2100766466);
      assertEquals(split[2], -1078643750);
      assertEquals(split[3], -945344036);
    }
    catch(IOException e) {
      fail("Did not expect an Exception");
    }
  }


  @Test
  public void test_get_n_bit() {
    CryptoAnalysis crypto = new CryptoAnalysis();

    assertEquals(crypto.getBit(-1477322454, 0), 1);
    assertEquals(crypto.getBit(1, 31), 1);
  }


  @Test
  public void test_missing_imput() {
    CryptoAnalysis crypto = new CryptoAnalysis();

    try {
      crypto.readKnownTextPairs("/app/src/main/java/with_nulls.txt");

      String [][] pairs = crypto.getTextPairs();

      assertEquals(pairs[0][0], "d3feeda5d5f3d9e4");
      assertEquals(pairs[1][0], "b9a0a168b6b4a416");
      assertNull(pairs[0][1]);
      assertNull(pairs[1][1]);
    }
    catch(IOException e) {
      fail("Did not expect an Exception");
    }
  }
}
