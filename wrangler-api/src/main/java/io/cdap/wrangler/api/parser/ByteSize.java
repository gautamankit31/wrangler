package io.cdap.wrangler.api.parser;

public class ByteSize implements Token {
  private final long bytes;

  public ByteSize(String input) {
    String lower = input.toLowerCase();
    if (lower.endsWith("kb")) {
      bytes = (long)(Double.parseDouble(lower.replace("kb", "")) * 1024);
    } else if (lower.endsWith("mb")) {
      bytes = (long)(Double.parseDouble(lower.replace("mb", "")) * 1024 * 1024);
    } else if (lower.endsWith("gb")) {
      bytes = (long)(Double.parseDouble(lower.replace("gb", "")) * 1024 * 1024 * 1024);
    } else if (lower.endsWith("tb")) {
      bytes = (long)(Double.parseDouble(lower.replace("tb", "")) * 1024L * 1024 * 1024 * 1024);
    } else {
      throw new IllegalArgumentException("Unsupported byte size unit: " + input);
    }
  }

  public long getBytes() {
    return bytes;
  }

  @Override
  public String toString() {
    return bytes + " bytes";
  }
}
