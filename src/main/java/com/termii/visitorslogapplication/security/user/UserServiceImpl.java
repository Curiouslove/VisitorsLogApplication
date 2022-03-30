package com.termii.visitorslogapplication.security.user;

import com.termii.visitorslogapplication.data.model.Authority;
import com.termii.visitorslogapplication.data.model.Staff;
import com.termii.visitorslogapplication.data.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Staff user = staffRepository.findByEmailAddress(emailAddress);
        if(user == null){
            throw new UsernameNotFoundException("Staff does not exist");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(), getAuthorities(user.getAuthorities()));
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Authority> authorities){
        return authorities.stream().map(authority -> {return new SimpleGrantedAuthority(
         authority.getAuthority().name());}).collect(Collectors.toList());
    }

}
