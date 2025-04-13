package io.cdap.wrangler.api.parser;

public class TimeDuration implements Token {
  private final long milliseconds;

  public TimeDuration(String input) {
    String lower = input.toLowerCase();
    if (lower.endsWith("ms")) {
      milliseconds = (long) Double.parseDouble(lower.replace("ms", ""));
    } else if (lower.endsWith("s") || lower.endsWith("sec") || lower.endsWith("seconds")) {
      milliseconds = (long) (Double.parseDouble(lower.replaceAll("s(ec)?(onds)?", "")) * 1000);
    } else if (lower.endsWith("m") || lower.endsWith("min") || lower.endsWith("minutes")) {
      milliseconds = (long) (Double.parseDouble(lower.replaceAll("m(in)?(utes)?", "")) * 60000);
    } else {
      throw new IllegalArgumentException("Unsupported time duration unit: " + input);
    }
  }

  public long getMilliseconds() {
    return milliseconds;
  }

  @Override
  public String toString() {
    return milliseconds + " ms";
  }
}
