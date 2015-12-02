package mainpack.service;

import mainpack.domain.*;

import java.util.List;
import java.util.Map;

/**
 * @author Yashchuk A.F.
 */
public interface NotebookService {


    Long receive(Notebook notebook, int amount, double price);
    Long receive(Long notebook, int amount, double price);
    Long sale(Store store, String date, Notebook notebook, Long soldNotebook, int amount);

    boolean createCPU(Vendor vendorName, String model, Integer frequency);
    boolean createMemory(Vendor vendor, Integer capacity, String model);
    boolean createVendor(String vendorName);
    boolean createNotebook(Vendor vendor, String model, String date, CPU cpu, Memory memory);

    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);

    List<Notebook> getNotebooksByPortion(int size);
    List<Notebook> getNotebooksGtAmount(int amount);
    List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor);
    List<Notebook> getNotebooksFromStore();
    List<Notebook> getNotebooksStorePresent();
    Map<Notebook, Integer> getSalesByDays();

    List<Notebook> getNotebooksList();
    List<CPU> getCPUList();
    List<Vendor> getVendorList();
    List<Memory> getMemoryList();
    List<Sales> getSalesList();
    List<Store> getStoreList();
}
