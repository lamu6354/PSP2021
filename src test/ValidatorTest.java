import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    Validator validator;

    @BeforeEach
    public void init() {validator = new Validator();}

    @Test
    void testPasswordIncorrectLength(){
        assertFalse(validator.checkPasswordLength("password", 8));
    }

    @Test
    void testPasswordCorrectLength(){
        assertTrue(validator.checkPasswordLength("password123",8));
    }

    @Test
    void testPasswordForNoUppercase(){
        assertFalse(validator.checkPasswordUppercases("password"));
    }

    @Test
    void testPasswordForUppercase(){
        assertTrue(validator.checkPasswordUppercases("Password"));
    }

    @Test
    void testPasswordForNoSpecialSymbols(){
        assertFalse(validator.checkPasswordSpecialSymbols("password"));
    }

    @Test
    void testPasswordForSpecialSymbols(){
        assertTrue(validator.checkPasswordSpecialSymbols("Password!@#"));
    }

    @Test
    void testPhoneNumberForUnexpectedSymbols(){
        assertFalse(validator.checkPhoneNumber("86575757a"));
    }

    @Test
    void testPhoneNumberForExpectedSymbols(){
        assertTrue(validator.checkPhoneNumber("865757577"));
    }

    @Test
    void testPhoneNumberAfterChange(){
        assertEquals("+37065757577", validator.changePhoneNumberPrefix("865757577"));
    }

    @Test
    void testPhoneNumberForInvalidPrefix(){
        assertFalse(validator.checkPhoneNumberPrefix("33", 10, "France"));
    }

    @Test
    void testPhoneNumberForInvalidLength(){
        assertFalse(validator.checkPhoneNumberPrefix("+33", 3, "France"));
    }

    @Test
    void testPhoneNumberForValidPrefix(){
        assertTrue(validator.checkPhoneNumberPrefix("+33", 10, "France"));
    }

    @Test
    void testEmailForNoAt(){
        assertFalse(validator.checkEmailForAt("laura.com"));
    }

    @Test
    void testEmailForTooManyAt(){
        assertFalse(validator.checkEmailForAt("lau@ra@gmail.com"));
    }

    @Test
    void testEmailForValidAt(){
        assertTrue(validator.checkEmailForAt("lauram@gmail.com"));
    }

    @Test
    void testEmailForInvalidCharacters(){
        assertFalse(validator.checkEmailCharacters("l!au$ram@gmai%l.com"));
    }

    @Test
    void testEmailForValidCharacters(){
        assertTrue(validator.checkEmailCharacters("lauram@gmail.com"));
    }

    @Test
    void testEmailForInvalidDomain(){
        assertFalse(validator.checkEmailDomain("lauram@gmaaaaail.com"));
    }

    @Test
    void testEmailForInvalidTLD(){
        assertFalse(validator.checkEmailDomain("lauram@gmail.asdvdsih"));
    }

    @Test
    void testEmailForValidDomainAndTLD(){
        assertTrue(validator.checkEmailDomain("lauram@gmail.com"));
    }

    @AfterEach
    void tearDown(){}
}
