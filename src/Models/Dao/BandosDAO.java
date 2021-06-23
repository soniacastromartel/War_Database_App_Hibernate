package Models.Dao;

import Models.Pojo.Contendiente;
import Models.Pojo.Pais;
import Models.Pojo.UnionBandos;
import Models.Util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import views.viewContenders2;

/**
 *
 * @author Sonia Castro (soniacastromartel@gmail.com)
 */
public class BandosDAO implements GenericDAO<UnionBandos> {

    List<UnionBandos> unionBandosList;
    UnionBandos unionBandos;
    viewContenders2 viContenders2;

    @Override
    public void addObject(UnionBandos valor) {

    }

    @Override
    public void updateObject(UnionBandos valor) {

    }

    @Override
    public void remove(UnionBandos valor) {

    }

    @Override
    public UnionBandos getById(int id) {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    Transaction t = sesion.beginTransaction();
	    unionBandos = (UnionBandos) sesion.get(UnionBandos.class, id);

	    System.out.println("union de bandos:" + unionBandos);
	    t.commit();

	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}

	return unionBandos;
    }

    public UnionBandos getUnionBandos(String nombreContendiente, String nombrePais) {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("SELECT u FROM UnionBandos u WHERE u.contendiente = (SELECT c FROM Contendiente c WHERE c.nombre = :contendiente) AND u.pais = (SELECT p FROM Pais p WHERE p.nombre = :pais)");
	query.setParameter("contendiente", nombreContendiente);
	query.setParameter("pais", nombrePais);

	UnionBandos unionBandosNuevo = (UnionBandos) query.uniqueResult();

	session.close();

	return unionBandosNuevo;
    }

    @Override
    public List<UnionBandos> list() {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    String hql = "from UnionBandos";
	    Query query = sesion.createQuery(hql);
	    unionBandosList = query.list();
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return unionBandosList;
    }

    public void addBandos(UnionBandos unionBandos, String nombreContendiente, String nombrePais) {
	Session session = null;

	try {

	    session = HibernateUtil.getSessionFactory().openSession();
	    Query query = session.createQuery("SELECT p FROM Pais p WHERE p.nombre = :nombre");
	    query.setParameter("nombre", nombrePais);

	    Pais paisBBDD = (Pais) query.uniqueResult();

	    query = session.createQuery("SELECT c FROM Contendiente c WHERE c.nombre = :nombre");
	    query.setParameter("nombre", nombreContendiente);

	    Contendiente contendienteBBDD = (Contendiente) query.uniqueResult();
	    unionBandos.setPais(paisBBDD);
	    unionBandos.setContendiente(contendienteBBDD);

	    session.beginTransaction();
	    session.save(unionBandos);
	    session.getTransaction().commit();
	    JOptionPane.showMessageDialog(viContenders2, "Insertado correctamente");

	} catch (HibernateException he) {
	    session.getTransaction().rollback();
	    JOptionPane.showMessageDialog(viContenders2, "No se ha podido insertar");

	} finally {
	    session.close();

	}
    }

    public void updateBandos(UnionBandos unionBandos, String nombreContendiente, String nombrePais) {

	Session session = null;
	try {
	    session = HibernateUtil.getSessionFactory().openSession();

	    Query query = session.createQuery("SELECT u FROM UnionBandos u WHERE u.contendiente = (SELECT c FROM Contendiente c WHERE c.nombre = :contendiente) AND u.pais = (SELECT p FROM Pais p WHERE p.nombre = :pais)");
	    query.setParameter("contendiente", nombreContendiente);
	    query.setParameter("pais", nombrePais);

	    UnionBandos unionBandosBBDD = (UnionBandos) query.uniqueResult();

	    unionBandosBBDD.setFechaUnion(unionBandos.getFechaUnion());
	    unionBandosBBDD.setFechaAbandono(unionBandos.getFechaAbandono());

	    session.beginTransaction();
	    session.save(unionBandosBBDD);
	    session.getTransaction().commit();
	    JOptionPane.showMessageDialog(viContenders2, "Actualizado correctamente");

	} catch (HibernateException e) {
	    session.getTransaction().rollback();
	    JOptionPane.showMessageDialog(viContenders2, "No se ha podido actualizar");

	} finally {
	    session.close();

	}

    }

    public void removeContries(String nombreContendiente, String nombrePais) {

	Session session = null;
	try {
	    session = HibernateUtil.getSessionFactory().openSession();

	    Query query = session.createQuery("SELECT u FROM UnionBandos u WHERE u.contendiente = (SELECT c FROM Contendiente c WHERE c.nombre = :contendiente) AND u.pais = (SELECT p FROM Pais p WHERE p.nombre = :pais)");
	    query.setParameter("contendiente", nombreContendiente);
	    query.setParameter("pais", nombrePais);

	    UnionBandos unionBandosBBDD = (UnionBandos) query.uniqueResult();

	    session.beginTransaction();
	    session.delete(unionBandosBBDD);
	    session.getTransaction().commit();
	    JOptionPane.showMessageDialog(viContenders2, "eliminado correctamente");
	} catch (HibernateException e) {
	    session.getTransaction().rollback();
	    JOptionPane.showMessageDialog(viContenders2, "No se ha podido eliminar");
	} finally {
	    session.close();

	}

    }

}
