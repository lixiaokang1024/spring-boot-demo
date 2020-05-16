package com.example.demo.aa;

/**
 * @author cloud
 * @date 2018/03/13
 */
public class PnoGenerateUtil {
  private static final String INITIALIZE_STRING_BUFFER = "";
  private static final String NUM = "0123456789ABCDEFGHJKMNPQRSTUVWXYZ";

  /**
   * 生成运单号
   */
  public static String generatePno(Long increment, String cityCode, String sortingNo) {
    StringBuilder builder = new StringBuilder(INITIALIZE_STRING_BUFFER);
    long suffix = increment % 10;
    String num33 = getNum33(increment / 10);
    StringBuilder pno = builder.append(cityCode).append(num33).append(suffix).append(sortingNo);
    return pno.toString();
  }

  /**
   * 生成包裹序号编码
   *
   * @param increment 计数器
   */
  public static String getNum33(Long increment) {
    StringBuilder builder = new StringBuilder("");
    while (increment >= NUM.length()) {
      Long index = increment % NUM.length();
      increment = increment / NUM.length();
      builder.insert(0, NUM.charAt(index.intValue()));
    }
    builder.insert(0, NUM.charAt(increment.intValue()));
    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(generatePno(10L, "TH", "000"));
  }
}
