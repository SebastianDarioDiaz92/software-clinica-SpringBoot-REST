/**
 * 
 */
package ar.edu.unju.fi.clinica.Config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.clinica.Entity.User;
import ar.edu.unju.fi.clinica.Repository.UserRepository;

/**
 * Clase que implementa la Interfaz UserDetailsService.
 * Esta clase reconfigura el manejo de la clase User utilizada para el Login.
 * @author Diaz, Sebastián Darío
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	/**
	 * Constructor de la Clase CustomUserDetailsService.
	 * @param userRepository : Repositorio de la Clase User.
	 */
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Método sobrescrito para personalizar el proceso de busqueda del Usuario.
     */
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(usernameOrEmail);
        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getEmail()
                    , user.getPassword(),
                    user.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getDescriptionRol()))
                            .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }

}
