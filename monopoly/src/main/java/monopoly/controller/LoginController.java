/**
 * 
 */
package monopoly.controller;

import monopoly.dao.IUsuarioDao;
import monopoly.model.Usuario;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Bostico Alejandro
 * @author Moreno Pablo
 * @author Oliva Pablo
 *
 */
public class LoginController {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"spring/config/BeanLocations.xml");
	
	public static Usuario validarUsuario(String userName, String password)
	{
		IUsuarioDao usuarioDao = (IUsuarioDao) appContext.getBean("usuarioDao");
		Usuario usuario = usuarioDao.validarUsuario(userName, password);
				
		return usuario;
	}

}
