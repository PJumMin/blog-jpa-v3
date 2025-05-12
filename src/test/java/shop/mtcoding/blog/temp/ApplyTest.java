package shop.mtcoding.blog.temp;

import org.junit.jupiter.api.Test;
import shop.mtcoding.blog.Apply;

public class ApplyTest {

    @Test
    public void create_test() {
//        System.out.println(ApplyEnum.PASS.value);
//        System.out.println(ApplyEnum.FAIL.value);

        Apply apply = new Apply(1, "홍길동", 3, "합격");
        System.out.println(apply.getStatus());
    }
}
