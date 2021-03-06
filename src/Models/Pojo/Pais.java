package Models.Pojo;
// Generated 19-may-2021 10:48:07 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Pais generated by hbm2java
 */
@Entity
@Table(name="pais"
    ,catalog="guerras_bd"
    , uniqueConstraints = @UniqueConstraint(columnNames="nombre") 
)
public class Pais  implements java.io.Serializable {


     private Integer idPais;
     private String nombre;
     private Set periodoIndependecias = new HashSet(0);
     private Set unionBandoses = new HashSet(0);

    public Pais() {
    }

	
    public Pais(String nombre) {
        this.nombre = nombre;
    }
    public Pais(String nombre, Set periodoIndependecias, Set unionBandoses) {
       this.nombre = nombre;
       this.periodoIndependecias = periodoIndependecias;
       this.unionBandoses = unionBandoses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_pais", unique=true, nullable=false)
    public Integer getIdPais() {
        return this.idPais;
    }
    
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    
    @Column(name="nombre", unique=true, nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="pais")
    public Set getPeriodoIndependecias() {
        return this.periodoIndependecias;
    }
    
    public void setPeriodoIndependecias(Set periodoIndependecias) {
        this.periodoIndependecias = periodoIndependecias;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="pais")
    public Set getUnionBandoses() {
        return this.unionBandoses;
    }
    
    public void setUnionBandoses(Set unionBandoses) {
        this.unionBandoses = unionBandoses;
    }

    @Override
    public String toString() {
	return "Pais{" + "idPais=" + idPais + ", nombre=" + nombre + '}';
    }
    
    




}


