import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class CandyFactoryTest {

    CandyFactory candy = new CandyFactory();

    @Test
    public void testCaramelCandy() {
        Candy y = candy.getTypeCandy(TypeCandy.CARAMEL);
        String actual = y.eat();
        String expected = "Caramel";
        assertEquals(actual, expected);
    }

    @Test
    public void testChocolateCandy() {
        Candy y = candy.getTypeCandy(TypeCandy.CHOCOLATE);
        String actual = y.eat();
        String expected = "Chocolate";
        assertEquals(actual, expected);
    }


    @Test
    public void testMintCandy() {
        Candy y = candy.getTypeCandy(TypeCandy.MINT);
        String actual = y.eat();
        String expected = "Mint";
        assertEquals(actual, expected);
    }
}