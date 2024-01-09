package med.appointments.casestudy.security;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

   @Lazy
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        User user = authenticatedUserService.loadCurrentUser();


        if ("doctor".equals(user.getUserType())) {
            response.sendRedirect("/users/doctorhome");
        } else if ("patient".equals(user.getUserType())) {
            response.sendRedirect("/home/page");
        } else {
            // Default redirect for other roles or unknown roles
            response.sendRedirect("/");
        }



    }

}
