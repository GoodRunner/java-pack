package proxy.s;

/**
 * @description: 代理类
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-01-16 11:19
 */
public class TaoBao implements PhoneChain {

  private HUAWEI hw = new HUAWEI();

  @Override
  public Float sell(int amount) {

    Float sell = hw.sell(amount);

    // 功能增强  售价300 利润
    sell = sell + 300;

    return sell;
  }
}