/**
 * 
 */
package monopoly.model.tarjetas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import monopoly.model.Jugador;
import monopoly.model.tablero.Casillero;
import monopoly.model.tablero.Casillero.TipoCasillero;
import monopoly.model.tablero.CasilleroEstacion;

/**
 * @author Bostico Alejandro
 * @author Moreno Pablo
 * 
 * 
 */
@Entity
@Table(name = "tarjeta_estacion", catalog = "monopoly_db")
@PrimaryKeyJoinColumn(name = "tarjetaPropiedadID")
public class TarjetaEstacion extends TarjetaPropiedad implements Serializable {

	private static final long serialVersionUID = 1459008914691723627L;

	@Column(name = "precioAlquiler")
	private int precioAlquiler;

	@Column(name = "valorDosEstacion")
	private int valorDosEstacion;

	@Column(name = "valorTresEstacion")
	private int valorTresEstacion;

	@Column(name = "valorCuatroEstacion")
	private int valorCuatroEstacion;

	public TarjetaEstacion() {
		super();
	}

	public TarjetaEstacion(Jugador jugador, String nombre,
			int valorHipotecario, int precioAlquiler, int valorDosEstacion,
			int valorTresEstacion, int valorCuatroEstacion,
			String nombreImagen, int valorPropiedad, Casillero casillero) {
		super(jugador, nombre, valorHipotecario, nombreImagen, valorPropiedad,
				casillero);
		this.precioAlquiler = precioAlquiler;
		this.valorDosEstacion = valorDosEstacion;
		this.valorTresEstacion = valorTresEstacion;
		this.valorCuatroEstacion = valorCuatroEstacion;
	}

	/**
	 * @return the precioAlquiler
	 */
	public int getPrecioAlquiler() {
		return precioAlquiler;
	}

	/**
	 * @param precioAlquiler
	 *            the precioAlquiler to set
	 */
	public void setPrecioAlquiler(int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	/**
	 * @return the valorDosEstacion
	 */
	public int getValorDosEstacion() {
		return valorDosEstacion;
	}

	/**
	 * @param valorDosEstacion
	 *            the valorDosEstacion to set
	 */
	public void setValorDosEstacion(int valorDosEstacion) {
		this.valorDosEstacion = valorDosEstacion;
	}

	/**
	 * @return the valorTresEstacion
	 */
	public int getValorTresEstacion() {
		return valorTresEstacion;
	}

	/**
	 * @param valorTresEstacion
	 *            the valorTresEstacion to set
	 */
	public void setValorTresEstacion(int valorTresEstacion) {
		this.valorTresEstacion = valorTresEstacion;
	}

	/**
	 * @return the valorCuatroEstacion
	 */
	public int getValorCuatroEstacion() {
		return valorCuatroEstacion;
	}

	/**
	 * @param valorCuatroEstacion
	 *            the valorCuatroEstacion to set
	 */
	public void setValorCuatroEstacion(int valorCuatroEstacion) {
		this.valorCuatroEstacion = valorCuatroEstacion;
	}

	/**
	 * Método que calcula el valor del alquiler.
	 * 
	 * @return el monto a pagar por el alquiler de la propiedad.
	 *
	 */
	public int calcularAlquiler() {
		int cantEstaciones = 0;
		for (TarjetaPropiedad tarjProp : this.getJugador()
				.getTarjPropiedadList()) {
			if (tarjProp.getCasillero().getTipoCasillero() == TipoCasillero.C_ESTACION) {
				CasilleroEstacion casEst = (CasilleroEstacion) tarjProp
						.getCasillero();
				if (casEst.getTarjetaEstacion().getJugador()
						.equals(this.getJugador())) {
					cantEstaciones++;
				}
			}
		}

		return this.calcularAlquiler(cantEstaciones);
	}

	/**
	 * Método que calcula el valor del alquiler.
	 * 
	 * @param nroEstaciones
	 *            cantidad de estaciones que posee el jugador.
	 * @return el monto a pagar por el alquiler de la propiedad.
	 */
	public int calcularAlquiler(int nroEstaciones) {
		int monto = 0;
		switch (nroEstaciones) {
		case 0:
			monto = this.precioAlquiler;
			break;
		case 1:
			monto = this.precioAlquiler;
			break;
		case 2:
			monto = this.valorDosEstacion;
			break;
		case 3:
			monto = this.valorTresEstacion;
			break;
		case 4:
			monto = this.valorCuatroEstacion;
			break;
		default:
			monto = 0;
			break;
		}
		return monto;
	}

	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;

		TarjetaEstacion tp = (TarjetaEstacion) object;
		if (super.getIdTarjeta() != tp.getIdTarjeta())
			return false;

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.getIdTarjeta();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\n\tTarjetaEstacion [precioAlquiler="
				+ precioAlquiler + ", valorDosEstacion=" + valorDosEstacion
				+ ", valorTresEstacion=" + valorTresEstacion
				+ ", valorCuatroEstacion=" + valorCuatroEstacion + "]";
	}

}
