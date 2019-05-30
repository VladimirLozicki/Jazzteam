package model;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NutritionFactsTest {

    @Test
    public void c(){
        NutritionFacts cocaCola =
                new NutritionFacts.Builder(240, 8).build();
        System.out.println(cocaCola.getServingSize());
    }

}