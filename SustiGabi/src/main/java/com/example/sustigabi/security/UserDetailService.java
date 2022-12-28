package com.example.sustigabi.security;

import com.example.sustigabi.model.Usuario;
import com.example.sustigabi.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private IUsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usu = repository.findByUsuario(username);
		
		if (usu != null) {
			
			List<GrantedAuthority> listGranted = new ArrayList<>();
			
			GrantedAuthority granted = new SimpleGrantedAuthority(usu.getRol());
			
			listGranted.add(granted);
			
			return new User(
					usu.getUsuario(),
					usu.getContrasenia(),
					listGranted
					);
					
					
		}else {
			throw new UsernameNotFoundException("Usuario no existe: " + username);
		}
		
	}

}
