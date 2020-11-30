package com.mybatis.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.IOException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

@SuppressWarnings("restriction")
public class DesUtils {

  private static final String DES = "DES";
  private static final String ENCODE = "GBK";
  private static String defaultKey = "roombox0";

  /**
   * 测试.
   */
  public static void main(String[] args) throws Exception {

    String username = "omo1197210994oBL";
    defaultKey = "roombox0";

    username = encrypt(username);

    System.out.println("解密：" + decrypt(username));

    System.out.println(username);
  }


  /**
   * 使用 默认key 加密.
   * 
   * @return String
   */
  public static String encrypt(String data) throws Exception {
    byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
    String strs = new BASE64Encoder().encode(bt);
    return strs;
  }

  /**
   * Description 根据键值进行加密.
   * 
   * @return
   */
  public static String encrypt(String data, String key) throws Exception {
    byte[] bt = encrypt(data.getBytes(ENCODE), key.getBytes(ENCODE));
    String strs = new BASE64Encoder().encode(bt);
    return strs;
  }

  /**
   * Description 根据键值进行加密.
   * 
   */
  private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
    // 生成一个可信任的随机数源
    SecureRandom sr = new SecureRandom();

    // 从原始密钥数据创建DESKeySpec对象
    DESKeySpec dks = new DESKeySpec(key);

    // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
    SecretKey securekey = keyFactory.generateSecret(dks);

    // Cipher对象实际完成加密操作
    Cipher cipher = Cipher.getInstance(DES);

    // 用密钥初始化Cipher对象
    cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

    return cipher.doFinal(data);
  }

  /**
   * 使用 默认key. 解密
   * 
   * @return String
   */
  public static String decrypt(String data) throws IOException, Exception {
    if (data == null) {
      return null;
    }
    BASE64Decoder decoder = new BASE64Decoder();
    byte[] buf = decoder.decodeBuffer(data);
    byte[] bt = decrypt(buf, defaultKey.getBytes(ENCODE));
    return new String(bt, ENCODE);
  }



  /**
   * Description 根据键值进行解密.
   * 
   */
  public static String decrypt(String data, String key) throws IOException, Exception {
    if (data == null) {
      return null;
    }
    BASE64Decoder decoder = new BASE64Decoder();
    byte[] buf = decoder.decodeBuffer(data);
    byte[] bt = decrypt(buf, key.getBytes(ENCODE));
    return new String(bt, ENCODE);
  }


  /**
   * Description 根据键值进行解密.
   * 
   */
  private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
    // 生成一个可信任的随机数源
    SecureRandom sr = new SecureRandom();

    // 从原始密钥数据创建DESKeySpec对象
    DESKeySpec dks = new DESKeySpec(key);

    // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
    SecretKey securekey = keyFactory.generateSecret(dks);

    // Cipher对象实际完成解密操作
    Cipher cipher = Cipher.getInstance(DES);

    // 用密钥初始化Cipher对象
    cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

    return cipher.doFinal(data);
  }
  
}
