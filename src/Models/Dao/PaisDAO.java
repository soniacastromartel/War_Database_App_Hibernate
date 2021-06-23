package Models.Dao;

import Models.Pojo.Pais;
import Models.Pojo.PeriodoIndependecia;
import Models.Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import views.viewCountries;

/**
 *
 * @author Sonia Castro (soniacastromartel@gmail.com)
 */
public class PaisDAO implements GenericDAO<Pais> {

    List<Pais> paises;
    List<String[]> countriesStringData;
    Pais pais;
    viewCountries viewCountrie;

    @Override
    public void addObject(Pais pais) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.save(pais);
	    transObj.commit();
	    JOptionPane.showMessageDialog(viewCountrie, "Pais insertado correctamente");

	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
	    }
	    JOptionPane.showMessageDialog(viewCountrie, "No se ha podido insertar el pais");
	    exObj.printStackTrace();

	} finally {
	    sessionObj.close();
	}

    }

    public void addIndependencePeriodtoCountry(int id, PeriodoIndependecia periodo) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    Pais pais = (Pais) sessionObj.load(Pais.class, id);
	    pais.getPeriodoIndependecias().add(periodo);
	    sessionObj.update(pais);
	    transObj.commit();
	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
	    }
	    exObj.printStackTrace();
	} finally {
	    sessionObj.close();
	}
    }

    @Override
    public void updateObject(Pais pais) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.update(pais);
	    transObj.commit();
	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
	    }
	    exObj.printStackTrace();
	} finally {
	    sessionObj.close();
	}

    }

    //Obtener el objeto
    public Object[] getCountryDTO(int indice) {
	 Object[] values = countriesStringData.get(indice);
        return values;
    }

    public void queriesI() {
	Session session = HibernateUtil.getSessionFactory().openSession();

	Query q = session.createQuery("from Pais");
	chargeAllCountriesData(q);

	session.close();
    }

    @Override
    public List<Pais> list() {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    String hql = "from Pais";
	    Query query = sesion.createQuery(hql);
	    paises = query.list();
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return paises;

    }
    
    /*"select p.nombre from pais p INNER JOIN union_bandos u on p.id_pais= u.id_pais INNER join contendiente c on u.id_contendiente=c.id_contendiente where c.nombre=?"*/
    /*from Cat as cat
    join cat.mate as mate
    left join cat.kittens as kitten*/
    /*from Contendiente c where c.guerra.nombre = :nombre*/
    //from Pais p inner join p.unionBandoses u  inner join u.contendiente c  where c.nombre = :nombre
    
    public List<Pais> listCountryOfContender(String nombre){
	
	Session sesion;
	try {
	    sesion = HibernateUtil.getSessionFactory().openSession();
	    Query query = sesion.createQuery("SELECT p FROM Pais p inner join p.unionBandoses u  inner join u.contendiente c  where u.contendiente.nombre= :nombre");
	    query.setParameter("nombre", nombre);
	    paises = query.list();
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return paises;
    }

    @Override
    public Pais getById(int id) {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    Transaction t = sesion.beginTransaction();
	    pais = (Pais) sesion.get(Pais.class, id);

	    System.out.println("pais" + pais);
	    t.commit();

	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}

	return pais;

    }

    @Override
    public void remove(Pais pais) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.delete(pais);
	    transObj.commit();
	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
	    }
	    exObj.printStackTrace();
	} finally {
	    sessionObj.close();
	}

    }
    
    //from Guerra g where g.nombre like:nombre or g.anioInicio like:nombre or g.anioFin like:nombre
    //SELECT p FROM Pais p inner join p.unionBandoses u  inner join u.contendiente c  where u.contendiente.nombre= :nombre

    public List<Pais> lightSearch(String nombre) {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    Query query = sesion.createQuery("SELECT p FROM Pais p LEFT JOIN p.periodoIndependecias pi WHERE p.nombre LIKE :nombre OR pi.anioInicio LIKE :nombre OR pi.anioFin LIKE :nombre");
	    query.setParameter("nombre", "%" + nombre + "%");
	    chargeAllCountriesData(query);
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return paises;

    }

    public int getSizeList() {
	try{       
            return countriesStringData.size();
        }catch(NullPointerException npe){
            return 0;
        }
    }
    
    private void chargeAllCountriesData(Query query) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Pais> countriesFromDatabase = new ArrayList<>(query.list());
        countriesStringData = new ArrayList<>();   
        for (Pais p : countriesFromDatabase) {
            String[] countriesData = new String[5];
            countriesData[0] = Integer.toString(p.getIdPais());
            countriesData[1] = p.getNombre();

            List<PeriodoIndependecia> pi = new ArrayList<>(p.getPeriodoIndependecias());

            for (PeriodoIndependecia periodoIndependecia : pi) {

                countriesData[2] = Integer.toString(periodoIndependecia.getIdPeriodo());
                countriesData[3] = Integer.toString(periodoIndependecia.getAnioInicio());
                try {
                    countriesData[4] = Integer.toString(periodoIndependecia.getAnioFin());
                } catch (Exception nfe) {
                    countriesData[4] = null;
                }
            }

            countriesStringData.add(countriesData);

        }

        session.close();
    }

}
