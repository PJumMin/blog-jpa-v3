package shop.mtcoding.blog.user;

import lombok.Builder;
import lombok.Data;

public class UserResponse {

    @Data
    public static class TokenDTO {
        private String accessToken;

        private String refreshToken;

        @Builder
        public TokenDTO(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }

    @Data
    public static class DTO {
        private Integer id;

        private String username;

        private String email;

        private String createdAt;

        public DTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.createdAt = user.getCreatedAt().toString();
        }
    }
}