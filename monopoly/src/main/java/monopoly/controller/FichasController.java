package monopoly.controller;

import java.io.Serializable;
import java.util.List;

import monopoly.dao.IFichaDao;
import monopoly.model.Ficha;
import monopoly.model.Ficha.TipoFicha;
import monopoly.util.GestorLogs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FichasController implements Serializable {

	private static final long serialVersionUID = -2015715413188534917L;
	private static ApplicationContext appContext;

	public static List<Ficha> getFichas() {
		appContext = new ClassPathXmlApplicationContext(
				"spring/config/BeanLocations.xml");

		IFichaDao fichaDao = (IFichaDao) appContext.getBean("fichaDao");

		GestorLogs.registrarLog("Fichas cargadas");
		return  fichaDao.getAll();
	}

	/**
	 * Devuelve la ficha que tiene el nombre pasado por parámetro. El nombre
	 * debe ser alguna de las constantes estáticas de la clase Ficha:
	 * <ul>
	 * <li>Ficha.TIPO_CARRETILLA</li>
	 * <li>Ficha.TIPO_AUTO</li>
	 * <li>Ficha.TIPO_SOMBRERO</li>
	 * <li>Ficha.TIPO_BOTA</li>
	 * <li>Ficha.TIPO_PLANCHA</li>
	 * <li>Ficha.TIPO_CARRETILLA</li>
	 * <li>Ficha.TIPO_DEDAL</li>
	 * <li>Ficha.TIPO_BARCO</li>
	 * <li>Ficha.TIPO_PERRO</li>
	 * <li>Ficha.TIPO_BOLSA_DINERO</li>
	 * <li>Ficha.TIPO_CABALLO</li>
	 * <li>Ficha.TIPO_CANON</li>
	 * </ul>
	 * 
	 * @param tipoFicha
	 *            El tipo de la ficha
	 * @return La instancia de la clase Ficha o null si no se encuentra una
	 *         ficha con ese nombre.
	 */
	public Ficha getFicha(TipoFicha tipoFicha) {
		for (Ficha ficha : getFichas()) {
			if (ficha.getNombre().compareTo(tipoFicha.getNombreTipo()) == 0) {
				return ficha;
			}
		}
		return null;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder("GestorFichas [ ");

		sb.append("fichas=");
		for (Ficha ficha : getFichas()) {
			sb.append("'");
			sb.append(ficha.getNombre());
			sb.append("' ");

		}

		sb.append("]");
		return sb.toString();
	}
}
