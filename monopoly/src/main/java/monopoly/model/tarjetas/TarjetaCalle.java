/**
 * 
 */
package monopoly.model.tarjetas;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Bostico Alejandro
 * @author Moreno Pablo
 * @author Oliva Pablo
 *
 */
@Entity
@Table(name="tarjeta_calle", catalog = "monopoly_db")
@AttributeOverrides({
    @AttributeOverride(name="jugador", column=@Column(name="jugadorID")),
    @AttributeOverride(name="nombre", column=@Column(name="nombre")),
    @AttributeOverride(name="valorHipoticario", column=@Column(name="valorHipoticario"))
})
public class TarjetaCalle extends TarjetaPropiedad {

    @Column(name = "precioAlquiler")
    private Integer precioAlquiler;
    
    @Column(name = "valorUnaCasa")
    private Integer valorUnaCasa;
    
    @Column(name = "valorDosCasas")
    private Integer valorDosCasas;
    
    @Column(name = "valorTresCasas")
    private Integer valorTresCasas;
    
    @Column(name = "valorCuatroCasas")
    private Integer valorCuatroCasas;
    
    @Column(name = "valorHotel")
    private Integer valorHotel;
    
    @Column(name = "precioCadaCasa")
    private Integer precioCadaCasa;
    
    @Column(name = "precioCadaHotel")
    private Integer precioCadaHotel;

    
    /**
     * 
     */
    public TarjetaCalle() {
	super();
    }

    /**
     * @return the precioAlquiler
     */
    public Integer getPrecioAlquiler() {
        return precioAlquiler;
    }


    /**
     * @param precioAlquiler the precioAlquiler to set
     */
    public void setPrecioAlquiler(Integer precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }


    /**
     * @return the valorUnaCasa
     */
    public Integer getValorUnaCasa() {
        return valorUnaCasa;
    }


    /**
     * @param valorUnaCasa the valorUnaCasa to set
     */
    public void setValorUnaCasa(Integer valorUnaCasa) {
        this.valorUnaCasa = valorUnaCasa;
    }


    /**
     * @return the valorDosCasas
     */
    public Integer getValorDosCasas() {
        return valorDosCasas;
    }


    /**
     * @param valorDosCasas the valorDosCasas to set
     */
    public void setValorDosCasas(Integer valorDosCasas) {
        this.valorDosCasas = valorDosCasas;
    }


    /**
     * @return the valorTresCasas
     */
    public Integer getValorTresCasas() {
        return valorTresCasas;
    }


    /**
     * @param valorTresCasas the valorTresCasas to set
     */
    public void setValorTresCasas(Integer valorTresCasas) {
        this.valorTresCasas = valorTresCasas;
    }


    /**
     * @return the valorCuatroCasas
     */
    public Integer getValorCuatroCasas() {
        return valorCuatroCasas;
    }


    /**
     * @param valorCuatroCasas the valorCuatroCasas to set
     */
    public void setValorCuatroCasas(Integer valorCuatroCasas) {
        this.valorCuatroCasas = valorCuatroCasas;
    }


    /**
     * @return the valorHotel
     */
    public Integer getValorHotel() {
        return valorHotel;
    }


    /**
     * @param valorHotel the valorHotel to set
     */
    public void setValorHotel(Integer valorHotel) {
        this.valorHotel = valorHotel;
    }


    /**
     * @return the precioCadaCasa
     */
    public Integer getPrecioCadaCasa() {
        return precioCadaCasa;
    }


    /**
     * @param precioCadaCasa the precioCadaCasa to set
     */
    public void setPrecioCadaCasa(Integer precioCadaCasa) {
        this.precioCadaCasa = precioCadaCasa;
    }


    /**
     * @return the precioCadaHotel
     */
    public Integer getPrecioCadaHotel() {
        return precioCadaHotel;
    }


    /**
     * @param precioCadaHotel the precioCadaHotel to set
     */
    public void setPrecioCadaHotel(Integer precioCadaHotel) {
        this.precioCadaHotel = precioCadaHotel;
    }
    
}