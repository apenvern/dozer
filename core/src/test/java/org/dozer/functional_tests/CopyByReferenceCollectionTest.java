package org.dozer.functional_tests;

import org.dozer.vo.SimpleEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Hee Tatt Ooi
 */
public class CopyByReferenceCollectionTest extends AbstractFunctionalTest {

  @Override
  public void setUp() throws Exception {
    super.setUp();
    mapper = getMapper("copyByReferenceCollectionTest.xml");
  }

  @Test
  public void testCollectionToSet() {
    // Property within Set
    Set<SimpleEnum> tempSet = new HashSet<SimpleEnum>();
    tempSet.add(SimpleEnum.TWO);
    tempSet.add(SimpleEnum.ONE);
    ObjectWithCollection1 obj1 = new ObjectWithCollection1();
    obj1.setTestSetToSet(tempSet);
    ObjectWithCollection2 obj2 = new ObjectWithCollection2();

    mapper.map(obj1, obj2);

    assertTrue(obj2.getTestSetToSet().contains(SimpleEnum.ONE));
    assertTrue(obj2.getTestSetToSet().contains(SimpleEnum.TWO));
  }

  @Test
  public void testArrayToArray() {
    SimpleEnum[] srcEnumArray = new SimpleEnum[1];
    srcEnumArray[0] = SimpleEnum.TWO;

    ObjectWithCollection1 obj1 = new ObjectWithCollection1();
    obj1.setTestArrayToArray(srcEnumArray);

    ObjectWithCollection2 obj2 = new ObjectWithCollection2();
    mapper.map(obj1, obj2);

    assertEquals(SimpleEnum.TWO, obj2.getTestArrayToArray()[0]);
  }

  @Test
  public void testArrayToList() {
    SimpleEnum[] srcEnumArray = new SimpleEnum[1];
    srcEnumArray[0] = SimpleEnum.TWO;

    ObjectWithCollection1 obj1 = new ObjectWithCollection1();
    obj1.setTestArrayToList(srcEnumArray);

    ObjectWithCollection2 obj2 = new ObjectWithCollection2();
    mapper.map(obj1, obj2);
    assertEquals(SimpleEnum.TWO, obj2.getTestArrayToList().get(0));
  }

  @Test
  public void testListToList() {
    ObjectWithCollection1 obj1 = new ObjectWithCollection1();
    List listToArrayTest = new ArrayList<SimpleEnum>();
    listToArrayTest.add(SimpleEnum.ONE);
    obj1.setTestListToArray(listToArrayTest);

    ObjectWithCollection2 obj2 = new ObjectWithCollection2();
    mapper.map(obj1, obj2);
    assertEquals(SimpleEnum.ONE, obj2.getTestListToArray()[0]);
  }

  public class ObjectWithCollection1 {

    private Set<SimpleEnum> testSetToSet;

    private SimpleEnum[] testArrayToArray;

    private SimpleEnum[] testArrayToList;

    private List testListToArray = new ArrayList<SimpleEnum>();

    public Set<SimpleEnum> getTestSetToSet() {
      return testSetToSet;
    }

    public void setTestSetToSet(Set<SimpleEnum> testSetToSet) {
      this.testSetToSet = testSetToSet;
    }

    public SimpleEnum[] getTestArrayToArray() {
      return testArrayToArray;
    }

    public void setTestArrayToArray(SimpleEnum[] testArrayToArray) {
      this.testArrayToArray = testArrayToArray;
    }

    public SimpleEnum[] getTestArrayToList() {
      return testArrayToList;
    }

    public void setTestArrayToList(SimpleEnum[] testArrayToList) {
      this.testArrayToList = testArrayToList;
    }

    public List getTestListToArray() {
      return testListToArray;
    }

    public void setTestListToArray(List testListToArray) {
      this.testListToArray = testListToArray;
    }

  }

  public class ObjectWithCollection2 {

    private Set<SimpleEnum> testSetToSet;

    private SimpleEnum[] testArrayToArray;

    private List testArrayToList = new ArrayList<SimpleEnum>();

    private SimpleEnum[] testListToArray;

    public Set<SimpleEnum> getTestSetToSet() {
      return testSetToSet;
    }

    public void setTestSetToSet(Set<SimpleEnum> testSetToSet) {
      this.testSetToSet = testSetToSet;
    }

    public SimpleEnum[] getTestArrayToArray() {
      return testArrayToArray;
    }

    public void setTestArrayToArray(SimpleEnum[] testArrayToArray) {
      this.testArrayToArray = testArrayToArray;
    }

    public List getTestArrayToList() {
      return testArrayToList;
    }

    public void setTestArrayToList(List testArrayToList) {
      this.testArrayToList = testArrayToList;
    }

    public SimpleEnum[] getTestListToArray() {
      return testListToArray;
    }

    public void setTestListToArray(SimpleEnum[] testListToArray) {
      this.testListToArray = testListToArray;
    }
  }

}
