package Models.Pojo;
// Generated 19-may-2021 10:48:07 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * PeriodoIndependecia generated by hbm2java
 */
@Entity
@Table(name="periodo_independecia"
    ,catalog="guerras_bd"
    , uniqueConstraints = @UniqueConstraint(columnNames="id_pais") 
)
public class PeriodoIndependecia  implements java.io.Serializable {


     private Integer idPeriodo;
     private Pais pais;
     private int anioInicio;
     private Integer anioFin;

    public PeriodoIndependecia() {
    }

	
    public PeriodoIndependecia(Pais pais, int anioInicio) {
        this.pais = pais;
        this.anioInicio = anioInicio;
    }
    public PeriodoIndependecia(Pais pais, int anioInicio, Integer anioFin) {
       this.pais = pais;
       this.anioInicio = anioInicio;
       this.anioFin = anioFin;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_periodo", unique=true, nullable=false)
    public Integer getIdPeriodo() {
        return this.idPeriodo;
    }
    
    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_pais", unique=true, nullable=false)
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
    @Column(name="anio_inicio", nullable=false)
    public int getAnioInicio() {
        return this.anioInicio;
    }
    
    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    
    @Column(name="anio_fin")
    public Integer getAnioFin() {
        return this.anioFin;
    }
    
    public void setAnioFin(Integer anioFin) {
        this.anioFin = anioFin;
    }

    @Override
    public String toString() {
	return "PeriodoIndependecia{" + "idPeriodo=" + idPeriodo + ", pais=" + pais + ", anioInicio=" + anioInicio + ", anioFin=" + anioFin + '}';
    }
    
    




}


