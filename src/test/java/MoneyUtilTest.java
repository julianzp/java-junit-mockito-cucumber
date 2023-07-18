import org.example.MoneyUtil;
import org.junit.Assert;
import org.junit.Test;

public class MoneyUtilTest {


    // El assert tiene dos parámetros. LO QUE ESPERAMOS Y LO QUE TENEMOS
    @Test
    public void MoneyTest(){
        String money = MoneyUtil.format(1000);
        Assert.assertEquals("$1000.00",money);
    }

    @Test
    public void negativeMoneyTest(){
        String money = MoneyUtil.format(-1000);
        Assert.assertEquals("-$1000.00",money);
    }

    @Test
    public void euroMoneyTest(){
        String money = MoneyUtil.format(-1000, "€");
        Assert.assertEquals("-€1000.00",money);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notNullExceptionMoneyTest(){
        MoneyUtil.format(-1000, null);

    }

}
