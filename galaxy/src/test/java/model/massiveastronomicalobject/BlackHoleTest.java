package model.massiveastronomicalobject;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BlackHoleTest {

    @Test
    public void s(){
        BlackHole blackHole = new BlackHole(1.0, 2.0);
        System.out.println(blackHole.getLuminocity() + " " + blackHole.getRadius() );
    }

}