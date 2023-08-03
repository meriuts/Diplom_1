package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;


@RunWith(Parameterized.class)
public class BurgerTest {
    float bunPrice;
    float ingredientPrice;
    float ingredient2Price;
    float ingredient3Price;
    float burgerPrice;
    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient = Mockito.mock(Ingredient.class);
    Ingredient ingredient2 = Mockito.mock(Ingredient.class);
    Ingredient ingredient3 = Mockito.mock(Ingredient.class);
    IngredientType ingredientType = Mockito.mock(IngredientType.class);

    public BurgerTest (float bunPrice, float ingredientPrice, float ingredient2Price, float ingredient3Price, float burgerPrice)  {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredient2Price = ingredient2Price;
        this.ingredient3Price = ingredient3Price;
        this.burgerPrice = burgerPrice;
    }
    @Parameterized.Parameters
    public static Object [][] getTestPrice() {
        return new Object [][] {
                {10.00F, 20.00F, 30.00F, 50.00F, 120.00F},
                {170.15F, 300.20F, 90.10F, 100.10F, 830.70F},
                {100F, 300F, 250F, 120F, 870F}
        };
    }
    @Test
    public void setBunsCreateNewBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }
    @Test
    public void addIngredientFillListIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.size() > 0);
    }

    @Test
    public void removeIngredientDeleteIngredientFromList() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void getPriceCountAndReturnPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredient2Price);
        Mockito.when(ingredient3.getPrice()).thenReturn(ingredient3Price);

        Assert.assertTrue(Math.abs(burgerPrice - burger.getPrice()) < 0.0001);
    }

    @Test
    public void getReceiptReturnStringReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredient2.getName()).thenReturn("cutlet");
        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredient3.getName()).thenReturn("sausage");
        Mockito.when(burger.getPrice()).thenReturn(700.00F);

        Assert.assertTrue(burger.getReceipt().contains("black bun"));
        Assert.assertTrue(burger.getReceipt().contains("chili sauce"));
        Assert.assertTrue(burger.getReceipt().contains("cutlet"));
        Assert.assertTrue(burger.getReceipt().contains("sausage"));
        Assert.assertTrue(burger.getReceipt().contains("700,00"));

    }

    @Test
    public void moveIngredientChangeLayerIngredientInBurger() {
        Burger burger = new Burger();
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        Assert.assertTrue(burger.ingredients.size() == 2);
        Assert.assertEquals("chili sauce", burger.ingredients.get(1).getName());
    }

}
