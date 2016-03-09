package party.lib;

import org.junit.Before;
import org.junit.Test;

import javax.swing.text.LabelView;

import static org.junit.Assert.*;

public class LabelTest {

    private Label label;

    @Before
    public void setUp() throws Exception {
        label = new Label("SomeThing");
    }

    @Test
    public void testAdd() throws Exception {
        Label shortLabel = new Label("AnotherThing");
        label.add(shortLabel);
        Label expected = new Label("SomeThingAnotherThing");
        assertEquals(expected,label);
    }

    @Test
    public void testAddNewLine() throws Exception {
        label.addNewLine();
        assertEquals(label,new Label("SomeThing\n"));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("SomeThing",label.toString());
    }
}