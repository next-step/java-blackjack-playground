package nextstep.fp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("pobi", 0);
//        Car actual = car.move(new MoveStrategy() {
//            @Override
//            public boolean isMovable() {
//                return true;
//            }
//        });

        Car lambdaCar = car.move(() ->{
            return true;
        });

        assertThat(lambdaCar).isEqualTo(new Car("pobi", 1));
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });

        Car lambdaCar = car.move(() -> {return false;});

        assertThat(lambdaCar).isEqualTo(new Car("pobi", 0));
    }
}
