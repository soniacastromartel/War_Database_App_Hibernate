package Models.Dao;

import Models.Pojo.Contendiente;
import Models.Pojo.Guerra;
import Models.Util.HibernateUtil;
import java.util.ArrayList;
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
public class ContenderDAO implements GenericDAO<Contendiente> {

    List<Contendiente> contendientes;
    Contendiente contendiente;
    viewContenders2 viContenders2;

    public void addContender(Contendiente contendiente, String nombreGuerra) {
	Transaction transObj = null;
	Session session = null;
	try {
	    session = HibernateUtil.getSessionFactory().openSession();
	    Query query = session.createQuery("SELECT g FROM Guerra g WHERE g.nombre = :nombre");
	    query.setParameter("nombre", nombreGuerra);
	    Guerra guerraBBDD = (Guerra) query.uniqueResult();
	    contendiente.setGuerra(guerraBBDD);

	    session.beginTransaction();
	    session.save(contendiente);
	    session.getTransaction().commit();
	    JOptionPane.showMessageDialog(viContenders2, "Insertado correctamente");
	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
		JOptionPane.showMessageDialog(viContenders2, "No se ha podido insertar");
	    }
	    exObj.printStackTrace();
	} finally {
	    session.close();
	}

    }

    @Override
    public void updateObject(Contendiente contendiente) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.update(contendiente);
	    transObj.commit();
	    JOptionPane.showMessageDialog(viContenders2, "Actualizado correctamente");
	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
		JOptionPane.showMessageDialog(viContenders2, "No se ha podido actualizar");

	    }
	    exObj.printStackTrace();
	} finally {
	    sessionObj.close();
	}

    }

    @Override
    public List<Contendiente> list() {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    String hql = "from Contendiente";
	    Query query = sesion.createQuery(hql);
	    contendientes = query.list();
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return contendientes;

    }

    public List<Contendiente> listWarContenders(String nombre) {

	Session sesion;
	try {
	    sesion = HibernateUtil.getSessionFactory().openSession();
	    Query query = sesion.createQuery("from Contendiente c where c.guerra.nombre = :nombre");
	    query.setParameter("nombre", nombre);
	    contendientes = query.list();
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return contendientes;

    }

    @Override
    public Contendiente getById(int id) {

	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    Transaction t = sesion.beginTransaction();
	    contendiente = (Contendiente) sesion.get(Contendiente.class, id);

	    System.out.println("contendiente" + contendiente);
	    t.commit();

	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}

	return contendiente;

    }

    @Override
    public void remove(Contendiente contendiente) {
	Transaction trans = null;
	Session session = null;
	try {
	    String nombreContendiente = contendiente.getNombre();
	    session = HibernateUtil.getSessionFactory().openSession();
	    Query query = session.createQuery("SELECT c FROM Contendiente c WHERE c.nombre = :nombre");
	    query.setParameter("nombre", nombreContendiente);
	    Contendiente contendienteNuevo = (Contendiente) query.uniqueResult();
	    trans = session.beginTransaction();
	    session.delete(contendienteNuevo);
	    trans.commit();
	    JOptionPane.showMessageDialog(viContenders2, "Eliminado correctamente");

	} catch (HibernateException exObj) {
	    if (trans != null) {
		trans.rollback();
		JOptionPane.showMessageDialog(viContenders2, "No se ha podido eliminar");
	    }
	    exObj.printStackTrace();
	} finally {
	    session.close();

	}
    }

    public Contendiente getCountender(int indice) {
	contendiente = contendientes.get(indice);
	return contendiente;
    }

    public void queriesI() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Query q = session.createQuery("from Contendiente");
	contendientes = new ArrayList<Contendiente>(q.list());
	session.close();
    }

    public int getSizeList() {
	return contendientes.size();
    }

    public int winnerOrNot(String nombreContendiente) {

	Integer winner;
	Session session = HibernateUtil.getSessionFactory().openSession();

	Query query = session.createQuery("SELECT c.ganador FROM Contendiente c WHERE c.nombre = :nombre");
	query.setParameter("nombre", nombreContendiente);

	try {
	    winner = (Integer) query.list().get(0);
	} catch (Exception e) {
	    winner = 0;
	}

	session.close();

	return winner;
    }

    @Override
    public void addObject(Contendiente valor) {

    }

    public void updateContendiente(Contendiente contendiente, String oldName) {

	Session session = null;
	session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("SELECT c From Contendiente c WHERE c.nombre = :nombre");
	query.setParameter("nombre", oldName);

	Contendiente contendienteBBDD = (Contendiente) query.uniqueResult();
	contendienteBBDD.setGanador(contendiente.getGanador());
	contendienteBBDD.setNombre(contendiente.getNombre());
	try {
	    session.beginTransaction();
	    session.save(contendienteBBDD);
	    session.getTransaction().commit();
	    JOptionPane.showMessageDialog(viContenders2, "Actualizado correctamente");

	} catch (HibernateException e) {
	  
		session.getTransaction().rollback();
		JOptionPane.showMessageDialog(viContenders2, "No se ha podido actualizar");

	    
	    e.printStackTrace();
	} finally {
	    session.close();

	}

    }

}
