package proxy.s;

/**
 * @description: 华为厂家   被代理对象
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-01-16 11:15
 */
public class HUAWEI implements PhoneChain{


  /**
   * 某一款手机 华为厂家出厂价 2600
   * @param amount  购买数量
   * @return
   */
  @Override
  public Float sell(int amount) {
    return 2600f;
  }
}