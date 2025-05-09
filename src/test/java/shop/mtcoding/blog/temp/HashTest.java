package shop.mtcoding.blog.temp;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class HashTest {

    @Test
    public void encode_test() {
        // $2a$10$z0vF.yjNdfk13sbwrQFs7uM1o8WRysh8TjucDNqe1d8tjvacivBfu
        // $2a$10$D9DExWw4OHqzezgmi7EFtONtc8g58C8dwlDQQQT9AlYuwhylu3tyC
        String password = "1234";

        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(encPassword);
    }

    @Test
    public void decode_test() {
        // $2a$10$z0vF.yjNdfk13sbwrQFs7uM1o8WRysh8TjucDNqe1d8tjvacivBfu
        // $2a$10$D9DExWw4OHqzezgmi7EFtONtc8g58C8dwlDQQQT9AlYuwhylu3tyC
        String dbpassword = "$2a$10$D9DExWw4OHqzezgmi7EFtONtc8g58C8dwlDQQQT9AlYuwhylu3tyC";
        String password = "1234";

        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        if (encPassword.equals(password)) {
            System.out.println("비밀번호가 같아요");
        } else {
            System.out.println("비밀번호가 달라요");
        }

    }

    @Test
    public void decodev2_test() {
        // $2a$10$z0vF.yjNdfk13sbwrQFs7uM1o8WRysh8TjucDNqe1d8tjvacivBfu
        // $2a$10$D9DExWw4OHqzezgmi7EFtONtc8g58C8dwlDQQQT9AlYuwhylu3tyC
        String dbpassword = "$2a$10$D9DExWw4OHqzezgmi7EFtONtc8g58C8dwlDQQQT9AlYuwhylu3tyC";
        String password = "1234";

        Boolean isSame = BCrypt.checkpw(password, dbpassword);
        System.out.println(isSame);

    }
}
