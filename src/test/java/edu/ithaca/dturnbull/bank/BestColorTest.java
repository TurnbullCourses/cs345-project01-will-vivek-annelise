package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BestColorTest {
    
    @Test
    public void BestColorTest(){
        assertEquals("green", BestColor.getBestColor());
    }
}
