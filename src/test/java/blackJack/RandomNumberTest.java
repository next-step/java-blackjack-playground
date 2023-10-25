package blackJack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.time.Duration;
import mission.domain.NumberGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RandomNumberTest extends NsTest {

    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @Nested
    class AllFeatureTest {

        @Test
        void pwc() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
                runMain();
                assertThat(output()).contains(
                    "0"
                );
            });
        }
    }

    @Override
    protected void runMain() {
        NumberGenerator numberGenerator = new NumberGenerator() {
            @Override
            public int generate() {
                return 0;
            }
        };
        System.out.println(numberGenerator.generate());
    }
}
