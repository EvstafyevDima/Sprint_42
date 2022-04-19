package ru.yandex.architect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private String name;
    private boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][] {
                {"Я О", true}, // 3 знака: 2 буквы, пробел посередине
                {"Яна ИвановаСергевна", true}, // 19 знаков: 18 букв, пробел посередине
                {" Я О", false}, // пробел в начале
                {"Я О ", false}, // пробел в конце
                {"Я  О", false}, // двойной пробел в середине
                {"Я О Ф", false}, // 2 пробела
                {"ЯЫ", false}, // 2 знака без пробела
                {"Яна ИвановаСергевнаа", false}, // 20 знаков: 19 букв, пробел посередине
                {"", false} // Пустая строка
        };
    }

    @Test
    public void checkNameToEmbossTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

}
