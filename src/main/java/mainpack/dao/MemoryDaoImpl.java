package mainpack.dao;

import mainpack.domain.Memory;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pavlo Kozhukhar on 11.12.2014.
 */
@Repository
@Transactional
public class MemoryDaoImpl implements MemoryDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    @Autowired
    SessionFactory factory;

    @Override
    public Long create(Memory memory) {
        return (Long) factory.getCurrentSession().save(memory);
    }

    @Override
    @Transactional(readOnly = true)
    public Memory read(Long id) {
        return (Memory) factory.getCurrentSession().get(Memory.class, id);
    }

    @Override
    public boolean update(Memory memory) {
        factory.getCurrentSession().update("MEMORIES", memory);
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        factory.getCurrentSession().delete(memory);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Memory> findAll() {
        return factory.getCurrentSession().createCriteria(Memory.class).addOrder(Order.asc("id")).list();
    }

}
