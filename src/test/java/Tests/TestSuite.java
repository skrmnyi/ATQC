package Tests;


import com.sun.tools.javac.comp.Check;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CheckLoginTest.class, CheckUpdatedUserData.class, CheckNewVacancyCreation.class,
CheckCreatedVacancyIsDispalyed.class, CheckDeleteOfCreatedVacancy.class})

public class TestSuite {
}
