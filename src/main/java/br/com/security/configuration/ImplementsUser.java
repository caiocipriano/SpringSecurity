package br.com.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.security.model.Usuario;
import br.com.security.repository.UsuarioRepository;


@Repository
public class ImplementsUser implements UserDetailsService{

	@Autowired
	private UsuarioRepository user;	
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = user.findByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Erro no login!");
		}
		
		return usuario; //retornando UserDetails que foi implementada na Classe Usuario MODEL
	}
	
}
