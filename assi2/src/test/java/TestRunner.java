import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestCryptoAnalysis.class);
      for (Failure failure : result.getFailures()) {
         System.out.println("Fail: " + failure.toString());
      }

      System.out.println();
      System.out.println("Number of tests run: " + result.getRunCount());
      System.out.println("Number of tests that failed: " + result.getFailureCount());
      System.out.println("Overall result: " + result.wasSuccessful());
   }
}
