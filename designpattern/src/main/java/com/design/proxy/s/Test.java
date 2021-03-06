package proxy.s;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-01-16 11:21
 */
public class Test {

  public static void main(String[] args) {
    TaoBao taoBao = new TaoBao();

    Float sell = taoBao.sell(2);

    System.out.println("在淘宝上买 "+ 2 + " 个，单价是 " + sell);

  }

}