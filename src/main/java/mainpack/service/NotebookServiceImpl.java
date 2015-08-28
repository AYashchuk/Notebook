package mainpack.service;

import mainpack.dao.*;
import mainpack.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 24.12.2014.
 */
@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private CPUDao cpuDao;
    @Autowired
    private MemoryDao memoryDao;
    @Autowired
    private NotebookDao notebookDao;
    @Autowired
    private SalesDao salesDao;
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private VendorDao vendorDao;

    @Override
    public Long receive(Notebook notebook, int amount, double price) {
        Store store = new Store(notebook,price,amount);
        return storeDao.create(store) ;
    }

    @Override
    public Long receive(Long notebook, int amount, double price) {
        return receive(notebookDao.read(notebook),amount,price);
    }

    @Override
    public Long sale(Store store,String date,Notebook notebook,Long soldNotebook, int amount) {
        Sales sales = new Sales(store,date,notebook,soldNotebook,amount);
        return salesDao.create(sales);
    }


    @Override
    public boolean createCPU(Vendor vendor, String model, Integer frequency) {
        CPU cpu = new CPU(frequency,model,vendor);
        if(cpuDao.create(cpu) != 0 ) return true;
        else return false;
    }

    @Override
    public boolean createMemory(Vendor vendor, Integer capacity, String model) {
        Memory memory = new Memory(model,vendor, capacity);
        if(memoryDao.create(memory) != 0 ) return true;
        else return false;
    }

    @Override
    public boolean createVendor(String vendorName) {
        Vendor vendor = new Vendor(vendorName);
        if(vendorDao.create(vendor) != 0 ) return true;
        else return false;
    }

    @Override
    public boolean createNotebook(Vendor vendor, String model, String date, CPU cpu, Memory memory) {
        Notebook notebook = new Notebook(model,vendor,date+"",cpu,memory);
        if(notebookDao.create(notebook) != 0 ) return true;
        else return false;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        store.setAmount(store.getAmount()-amount);
        return storeDao.update(store);
    }


    @Override
    public List<Notebook> getNotebooksByPortion(int size) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksStorePresent() {
        return null;
    }

    @Override
    public Map<Notebook, Integer> getSalesByDays() {
        return null;
    }

    @Override
    public List<Notebook> getNotebooksList() {
        return notebookDao.findAll();
    }

    @Override
    public List<CPU> getCPUList() {
        return cpuDao.findAll();
    }

    @Override
    public List<Vendor> getVendorList() {
        return vendorDao.findAll();
    }

    @Override
    public List<Memory> getMemoryList() {
        return memoryDao.findAll();
    }

    @Override
    public List<Sales> getSalesList() {
        return salesDao.findAll();
    }

    @Override
    public List<Store> getStoreList() {
        return storeDao.findAll();
    }


    public CPUDao getCpuDao() {
        return cpuDao;
    }

    public MemoryDao getMemoryDao() {
        return memoryDao;
    }

    public NotebookDao getNotebookDao() {
        return notebookDao;
    }

    public SalesDao getSalesDao() {
        return salesDao;
    }

    public StoreDao getStoreDao() {
        return storeDao;
    }

    public VendorDao getVendorDao() {
        return vendorDao;
    }

    public void setCpuDao(CPUDao cpuDao) {
        this.cpuDao = cpuDao;
    }

    public void setMemoryDao(MemoryDao memoryDao) {
        this.memoryDao = memoryDao;
    }

    public void setNotebookDao(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public void setVendorDao(VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }
}
