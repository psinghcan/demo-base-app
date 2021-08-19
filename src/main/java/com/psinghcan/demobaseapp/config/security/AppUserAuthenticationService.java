package com.psinghcan.demobaseapp.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserAuthenticationService implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException
    {
        System.out.println("test");
        Authentication retVal = null;
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

        if (auth != null)
        {
            String name = auth.getName();
            String password = auth.getCredentials().toString();
            System.out.println("name: " + name);
            System.out.println("password: " + password);

            if (name.equals("admin") && password.equals("admin123"))
            {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_STAFF"));
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                retVal = new UsernamePasswordAuthenticationToken(
                        name, "", grantedAuths
                );
                System.out.println("grant Admin");
            }
            else if (name.equals("staff") && password.equals("staff123"))
            {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_STAFF"));
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                retVal = new UsernamePasswordAuthenticationToken(
                        name, "", grantedAuths
                );
                System.out.println("grant Staff");
            }
            else if (name.equals("user") && password.equals("user123"))
            {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                retVal = new UsernamePasswordAuthenticationToken(
                        name, "", grantedAuths
                );
                System.out.println("grant User");
            }
        }
        else
        {
            System.out.println("invalid login");
            retVal = new UsernamePasswordAuthenticationToken(
                    null, null, grantedAuths
            );
            System.out.println("bad Login");
        }

        System.out.println("return login info");
        return retVal;
    }


    @Override
    public boolean supports(Class<?> tokenType)
    {
        return tokenType.equals(UsernamePasswordAuthenticationToken.class);
    }
}