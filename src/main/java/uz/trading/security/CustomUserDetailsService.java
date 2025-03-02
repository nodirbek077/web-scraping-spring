package uz.trading.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(!username.equals("scraping_app")){
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(
                username,
                "scraping_app",
                "scraping_app123",
                "ACTIVE"
        );
    }
}
