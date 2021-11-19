package br.com.security.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.security.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,String>{
	
	Usuario findByLogin(String login);
}
