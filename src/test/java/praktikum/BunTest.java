package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameReturnBunName() {
        Bun bun = new Bun("Булочка", 5.50F);
        Assert.assertEquals("Булочка", bun.getName());
    }

    @Test
    public void getPriceReturnBuntPrice() {
        Bun bun = new Bun("Булочка", 5.50F);
        Assert.assertEquals(5.50F, bun.getPrice(), 0.0000001F);
    }
}
