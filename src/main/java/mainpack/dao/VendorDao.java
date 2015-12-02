package mainpack.dao;

import mainpack.domain.Vendor;

import java.util.List;

/**
 * @author Yashchuk A.F.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    Vendor findByName(String name);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List<Vendor> findAll();
}
