package triangle;

//import org.testng.Assert;
//import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;
//import org.testng.annotations.Test;
//import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Romko on 08.06.2017.
 */
public class RightTriangleTest {

    @Test
    public void testGetSide1() throws Exception {
        double side1 = 3;
        double side2 = 4;
        double side3 = 5;
        RightTriangle triangle = RightTriangle.newInstance().withSide1(3).withSide2(4).withHypotenuse(5).build();
        double expected = side1;

        Assert.assertEquals(triangle.getSide1(), side1, 0.0001);
    }

   /* @Test
    public void testGetSide2() throws Exception {

    }

    @Test
    public void testGetHypotenuse() throws Exception {

    }

    @Test
    public void testGetArea() throws Exception {

    }

    @Test
    public void testGetPerimeter() throws Exception {

    }

    @Test
    public void testNewInstance() throws Exception {

    }*/

}