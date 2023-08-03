package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    @Mock
    IngredientType ingredientType;

    @Test
    public void getPriceReturnIngredientPrice() {
        Ingredient ingredient = new Ingredient(ingredientType,"Аджика", 10.10F);
        Assert.assertEquals(10.10F, ingredient.getPrice(), 0.0000001F);
    }
    @Test
    public void getNameReturnIngredientName() {
        Ingredient ingredient = new Ingredient(ingredientType,"Аджика", 10.10F);
        Assert.assertEquals("Аджика", ingredient.getName());
    }


}
