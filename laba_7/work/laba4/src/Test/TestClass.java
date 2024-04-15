package Test;

import acter.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.reporters.AbstractXmlReporter;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    private Card card;
    private User user;
    private final long CountOfStudents = 3;

    @BeforeTest
    public void Init(){
        user = new User("hello", "qwerty");
        card = new Card("1234", 50);

        user.setCreateCard(card);
    }

    @AfterTest
    public void Clear(){
        card = null;
        user = null;
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("Тест метода");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("Тест метода окончен");
    }

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("Запуск тестов");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("Тесты окончены");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("Тест класса");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("Тест класса окончен");
    }

    @Test
    public void TestCountCard(){
        Assert.assertEquals(CountOfStudents, user.getCountOfMyCard());
    }

    @Test
    public void TestSort1(){
        user = new User("hello", "qwerty");
        card = new Card("4321", 43);

        user.setCreateCard(card);
        user.setCards("1243", 17);
        user.setCards("3421", 92);
        user.setCards("1234", 9);

        Assert.assertEquals(CountOfStudents,user.getCountOfMyCard());
    }

    @Test (timeOut = 1000)
    public void TestSort2(){
        user = new User("hell", "qwerty");
        card = new Card("4321", 43);

        user.setCreateCard(card);
        user.setCards("1243", 17);
        user.setCards("3421", 92);
        user.setCards("1234", 9);

        Assert.assertEquals(CountOfStudents,user.getCountOfMyCard());
    }

    @Ignore
    public void TestSort3(){
        User us = new User("hello", "qwerty");
        card = new Card("4321", 43);

        us.setCreateCard(card);
        us.setCards("1243", 17);
        us.setCards("3421", 92);
        us.setCards("1234", 9);

        Assert.assertEquals(CountOfStudents,user.getCountOfMyCard());
    }

    @DataProvider(name = "testData")
    public Object[][] createData(){
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        List<Card> list1 = new ArrayList<>();
        List<Card> list2 = new ArrayList<>();
        List<Card> list3 = new ArrayList<>();

        list1.add(new Card("1234", 21));
        list1.add(new Card("2345", 22));
        list2.add(new Card("3456", 23));
        list2.add(new Card("4567", 24));
        list2.add(new Card("5678", 25));
        list3.add(new Card("6789", 26));
        list3.add(new Card("7890", 27));

        user1.setCardsByList(list1);
        user2.setCardsByList(list2);
        user3.setCardsByList(list3);

        return new Object[][] {
                {user1, 2 },
                {user2, 3 },
                {user3, 2 }
        };
    }

    @Test(dataProvider = "testData")
    public void testCount(User user, int num) {
        Assert.assertEquals(user.getCountOfMyCard(), num);
    }
}
