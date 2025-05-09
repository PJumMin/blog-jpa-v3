package shop.mtcoding.blog._core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import shop.mtcoding.blog._core.error.ex.ExceptionApi401;
import shop.mtcoding.blog.user.User;

@Deprecated // 버리긴 아깝고 비활성화는 시켜야할 때 사용
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        // localhost:8080/s/api/board
        System.out.println("uri: " + uri); // /s/api/board

        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("sessionUser");

        if (uri.startsWith("/s")) { // /s 로 시작되는 것을 비교
            if (sessionUser == null) throw new ExceptionApi401("인증이 필요합니다");
        }

        return true;
    }
}