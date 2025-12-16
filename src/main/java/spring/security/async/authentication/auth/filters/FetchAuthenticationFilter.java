package spring.security.async.authentication.auth.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.async.WebAsyncUtils;
import spring.security.async.authentication.auth.token.FetchAuthenticationToken;
import spring.security.async.authentication.auth.users.domain.vo.UserInfomation;
import spring.security.async.authentication.util.WebUtil;

import java.io.IOException;

public class FetchAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper  objectMapper = new ObjectMapper();

    //인증필터 동작 패턴 정의(url/method)
    public FetchAuthenticationFilter() {
        super(new AntPathRequestMatcher("/fetch/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if(!HttpMethod.POST.name().equals(request.getMethod()) || !WebUtil.isAjax(request)) {
            throw new IllegalArgumentException("Authentication method not supported: " + request.getMethod());
        }

        UserInfomation userInfomation = objectMapper.readValue(request.getReader(), UserInfomation.class);

        if(!StringUtils.hasText(userInfomation.getUsername()) || !StringUtils.hasText(userInfomation.getPassword())) {
            throw new AuthenticationServiceException("Username or password is empty");
        }

        FetchAuthenticationToken fetchAuthenticationToken =  new FetchAuthenticationToken(userInfomation.getUsername(), userInfomation.getPassword());

        return getAuthenticationManager().authenticate(fetchAuthenticationToken);

    }
}
