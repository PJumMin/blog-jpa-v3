package shop.mtcoding.blog.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class DTO {
        // 규칙 2 : DTO에 민감정보 빼기, 날짜는 String으로 (날짜 공부하기 전까지)
        private Integer id;
        private String username;
        //        private String password; // 보안에 민감한 데이터는 주면 안됨
        private String email;
        private String createdAt; // 날짜는 Timestamp 말고 String으로 받기

        public DTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.createdAt = user.getCreatedAt().toString(); // . toString하면 문자열로 바뀜
        }
    }
}
