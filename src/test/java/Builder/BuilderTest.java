package Builder;

import org.junit.jupiter.api.Test;

public class BuilderTest {
    @Test
    public void builderTest() {
        UserModel user = UserModel.builder()
                .age(20)
                .salary(24.44)
                .username("nickname").build();
    }

    UserModel user2 = UserModel.builder()
            .password("asdfasdf")
            .username("nickname").build();
}

