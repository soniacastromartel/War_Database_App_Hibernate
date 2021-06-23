package Models.Dao;

import Models.Pojo.Guerra;
import Models.Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import views.viewWars;

/**
 *
 * @author Sonia Castro (soniacastromartel@gmail.com)
 */
public class GuerrasDAO implements GenericDAO<Guerra> {

    List<Guerra> guerras;
    Guerra g;
    viewWars viWars;

    @Override
    public void addObject(Guerra guerra) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.save(guerra);
	    transObj.commit();
	    JOptionPane.showMessageDialog(viWars, "Insertado correctamente");
	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
		exObj.printStackTrace();
		JOptionPane.showMessageDialog(viWars, "No se ha podido insertar");
	    }
	} finally {
	    sessionObj.close();
	}
    }

    @Override
    public void updateObject(Guerra guerra) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.update(guerra);
	    transObj.commit();
	    JOptionPane.showMessageDialog(viWars, "Actualizado correctamente");

	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
		exObj.printStackTrace();
		JOptionPane.showMessageDialog(viWars, "No se ha podido actualizar");

	    }
	} finally {
	    sessionObj.close();
	}

    }

    //Obtener el objeto
    public Guerra getWarDTO(int indice) {
	g = guerras.get(indice);
	return g;
    }

    public void queriesI() {
	Session session = HibernateUtil.getSessionFactory().openSession();

	Query q = session.createQuery("from Guerra");
	guerras = new ArrayList<Guerra>(q.list());

	session.close();
    }

    @Override
    public List<Guerra> list() {
	guerras = null;
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    String hql = "from Guerra";
	    Query query = sesion.createQuery(hql);
	    guerras = query.list();
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return guerras;

    }

    @Override
    public Guerra getById(int id) {
	Guerra guerra = null;
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    Transaction t = sesion.beginTransaction();
	    guerra = (Guerra) sesion.get(Guerra.class, id);

	    System.out.println("guerra" + guerra);
	    t.commit();

	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}

	return guerra;

    }

    @Override
    public void remove(Guerra guerra) {
	Transaction transObj = null;
	Session sessionObj = null;
	try {
	    sessionObj = HibernateUtil.getSessionFactory().openSession();
	    transObj = sessionObj.beginTransaction();
	    sessionObj.delete(guerra);
	    transObj.commit();
	    JOptionPane.showMessageDialog(viWars, "Eliminado correctamente");

	} catch (HibernateException exObj) {
	    if (transObj != null) {
		transObj.rollback();
		JOptionPane.showMessageDialog(viWars, "No se ha podido eliminar");

	    }
	    exObj.printStackTrace();
	} finally {
	    sessionObj.close();
	}

    }

    public List<Guerra> lightSearch(String nombre) {
	try {
	    Session sesion = HibernateUtil.getSessionFactory().openSession();
	    Query query = sesion.createQuery("from Guerra g where g.nombre like:nombre or g.anioInicio like:nombre or g.anioFin like:nombre");
	    query.setParameter("nombre", "%" + nombre + "%");
	    guerras = new ArrayList<Guerra>(query.list());
	    sesion.close();
	} catch (HibernateException e) {
	    e.printStackTrace(System.out);
	}
	return guerras;

    }

    public int getSizeList() {
	return guerras.size();
    }

}
