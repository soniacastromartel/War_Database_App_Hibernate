package Models.Dao;
import java.util.List;

/**
 *
 * @author Sonia Castro (soniacastromartel@gmail.com)
 * @param <T>
 */
public interface GenericDAO<T> {

    public void addObject(T valor);

    public void updateObject(T valor);

    public List<T> list();

    public T getById(int id);

    public void remove(T valor);

}