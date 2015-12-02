package mainpack.dao;

import mainpack.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yashchuk A.F.
 */
@Repository
@Transactional
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);
    @Autowired
    SessionFactory factory;

    @Override
    public Long create(CPU cpu) {
        return (Long) factory.getCurrentSession().save(cpu);
    }

    @Override
    @Transactional (readOnly = true)
    public CPU read(Long id) {
        return (CPU) factory.getCurrentSession().get(CPU.class, id);
    }

    @Override
    public boolean update(CPU cpu) {
        factory.getCurrentSession().update("PROCESSORS", cpu);
        return true;
    }

    @Override
    public boolean delete(CPU cpu) {
        factory.getCurrentSession().delete(cpu);
        return true;
    }

    @Override
    @Transactional (readOnly = true)
    public List<CPU> findAll() {
        return factory.getCurrentSession().createCriteria(CPU.class).addOrder(Order.asc("id")).list();
    }
}
