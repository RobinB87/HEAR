package com.capgemini;

import com.capgemini.data.SubMenuLijst;
import com.capgemini.models.SubMenu;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RobinTest {

    private static SubMenuLijst subMenuLijst;

    @BeforeClass
    public static void setup(){
        subMenuLijst = new SubMenuLijst();
    }

    @Test
    public void testje(){
        assertTrue(subMenuLijst.subMenuList.length == 4);
    }

    @Test
    public void testje2(){
        assertTrue(subMenuLijst.subMenuList[1].getName() == "Hoofdgerechten");
    }

}
