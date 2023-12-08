package med.appointments.casestudy.security;

import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.UserDAO;
import med.appointments.casestudy.database.dao.UserRoleDAO;
import med.appointments.casestudy.database.entity.User;
import med.appointments.casestudy.database.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserDAO userDao;
    @Autowired
    private UserRoleDAO userRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //look up incoming user name in database
        User user = userDao.findByEmailIgnoreCase(username);



        // if not found throw exception
        // if we did not find the user in the database
        // then we throw an exception because the user is not valid
        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;




        List<UserRole> userRoles = userRoleDao.findByUserId(user.getId());

        // setup user roles
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);


        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), accountIsEnabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);

    }



    public static Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        }

        // always add the user role
        authorities.add(new SimpleGrantedAuthority("USER"));

        return authorities;
    }
}


//public class UserDetailsServiceImpl {
//}
