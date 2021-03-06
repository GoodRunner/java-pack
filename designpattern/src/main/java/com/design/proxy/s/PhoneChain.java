package proxy.s;

/**
 * 手机供应链
 */
public interface PhoneChain {

  /**
   * 卖手机
   * @param amount  购买数量
   * @return 单价
   */
  public Float sell(int amount);

}
