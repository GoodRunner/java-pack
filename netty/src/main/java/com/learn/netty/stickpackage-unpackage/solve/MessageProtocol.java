package solve;

/**
 * @description: 自定义的发送协议
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-26 00:01
 */
public class MessageProtocol {

  private Integer len;

  private byte[] content;

  public byte[] getContent() {
    return content;
  }

  public Integer getLen() {
    return len;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

  public void setLen(Integer len) {
    this.len = len;
  }
}