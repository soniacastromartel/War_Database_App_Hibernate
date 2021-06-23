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
public class PeriodoIndependeciaDAO implements GenericDAO<PeriodoIndependecia> {

    List<PeriodoIndependecia> periodos;
    PeriodoIndependecia period;
    viewCountries view;

    @Override
    public void addObject(PeriodoIndependecia periodo) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.save(periodo);
	    transObj.commit();
	    JOptionPane.showMessageDialog(view, "Independecia insertada correctamente");
	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
	    }
	    exObj.printStackTrace();
	    System.out.println("Independencia no insertada");
	} finally {
	    sessionObj.close();
	}

    }

    public void addIndependencePeriod(Pais pais) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    Query query = sessionObj.createQuery("SELECT p FROM Pais p WHERE p.nombre = :nombre");
	    query.setParameter("nombre", pais.getNombre());
	    //Obteniendo objeto PAIS de la BBDD, para poder insertarselo a PeriodoInd
	    Pais paisNuevo = (Pais) query.uniqueResult();
	    PeriodoIndependecia periodoIndependencia = (PeriodoIndependecia) (new ArrayList<>(pais.getPeriodoIndependecias())).get(0);
	    //Indertando PAIS (que es la clave primaria [PK] de nuestro objeto ==>) a PeriodoInd. 
	    periodoIndependencia.setPais(paisNuevo);
	    sessionObj.save(periodoIndependencia);
	    transObj.commit();
	    JOptionPane.showMessageDialog(view, "Independencia añadida correctamente");

	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
	    }
	    exObj.printStackTrace();
	} finally {
	    sessionObj.close();
	}
    }

    public void UpdateOrSavePeriod(Pais pais, PeriodoIndependecia period) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    Query query = sessionObj.createQuery("SELECT p FROM Pais p WHERE p.nombre = :nombre");
	    query.setParameter("nombre", pais.getNombre());
	    //Obteniendo objeto PAIS de la BBDD, para poder insertarselo a PeriodoInd
	    Pais paisNuevo = (Pais) query.uniqueResult();
	    try {
		PeriodoIndependecia periodNuevo = (PeriodoIndependecia) (new ArrayList<>(paisNuevo.getPeriodoIndependecias())).get(0);
		periodNuevo.setAnioInicio(period.getAnioInicio());
		periodNuevo.setAnioFin(period.getAnioFin());
		//Indertando PAIS (que es la clave primaria [PK] de nuestro objeto ==>) a PeriodoInd. 
		sessionObj.update(periodNuevo);
		transObj.commit();
		JOptionPane.showMessageDialog(view, "Independencia actualizada correctamente");

	    } catch (Exception e) {
		period.setPais(paisNuevo);
		sessionObj.save(period);
		transObj.commit();
		JOptionPane.showMessageDialog(view, "Independencia añadida correctamente");
	    }

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
    public void updateObject(PeriodoIndependecia periodo) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.update(periodo);
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
    public PeriodoIndependecia getPeriod(int indice) {
	period = periodos.get(indice);
	return period;
    }

    public void queriesI() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Query q = session.createQuery("from PeriodoIndependecia");
	periodos = new ArrayList<PeriodoIndependecia>(q.list());
	session.close();
    }

    @Override
    public List<PeriodoIndependecia> list() {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    String hql = "from PeriodoIndependecia ";
	    Query query = sesion.createQuery(hql);
	    periodos = query.list();
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return periodos;

    }

//    public PeriodoIndependecia findIndependencePeriod(Pais pais) {
//	Session sesion = null;
//	Transaction t = null;
//	try {
//	    sesion = HibernateUtil.getSessionFactory().openSession();
//	    t = sesion.beginTransaction();
//	    Query query = sesion.createQuery("from PeriodoIndependecia pi inner join pi.pais p on p.idPais= :id");
//	    query.setParameter("id", pais.getIdPais());
//	    period = (PeriodoIndependecia) query.uniqueResult();
//	    t.commit();
//	} catch (HibernateException e) {
//	    e.printStackTrace(System.out);
//	} finally {
//	    sesion.close();
//
//	}
//	return period;
//
//    }

    @Override
    public PeriodoIndependecia getById(int id) {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    Transaction t = sesion.beginTransaction();
	    period = (PeriodoIndependecia) sesion.get(PeriodoIndependecia.class, id);

	    System.out.println("periodo" + period);
	    t.commit();

	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}

	return period;

    }

    @Override
    public void remove(PeriodoIndependecia periodo) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.delete(period);
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

    public int getSizeList() {
	return periodos.size();
    }
    
    public void deletePeriodoIndependencia(Pais pais) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Pais p WHERE p.nombre = :nombre");
        query.setParameter("nombre", pais.getNombre());

        Pais paisBBDD = (Pais) query.uniqueResult();

        if (paisBBDD.getPeriodoIndependecias().size() > 0) {
            session.delete((PeriodoIndependecia) (new ArrayList<>(paisBBDD.getPeriodoIndependecias())).get(0));

        }

        session.getTransaction().commit();
        session.close();
    }

}
