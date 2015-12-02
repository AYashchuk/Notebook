package mainpack.dao;

import mainpack.domain.Memory;

import java.util.List;

/**
 * @author Yashchuk A.F.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List<Memory> findAll();
}
