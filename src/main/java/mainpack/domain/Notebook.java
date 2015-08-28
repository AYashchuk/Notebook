package mainpack.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 11.12.2014.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook implements GetIdtable {
    public Notebook() {
    }

    public Notebook(String model, Vendor vendor, String date, CPU cpu, Memory memory) {
        this.model = model;
        this.vendor = vendor;
        this.date = date;
        this.cpu = cpu;
        this.memory = memory;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")


    @Column(name = "NOTEBOOK_ID")
    private Long id;

    @Column(name = "NOTEBOOK_MODEL")
    private String model;

    @ManyToOne
    @JoinColumn(name="VENDOR_ID")
    private Vendor vendor;

    @Column(name = "NOTEBOOK_DATE_OF_MANUFACTURE")
    private String date;

    @JoinColumn(name="CPU_ID")
    @ManyToOne
    private CPU cpu;

    @ManyToOne
    @JoinColumn(name="MEMORY_ID")
    private Memory memory;


    @OneToMany (fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "storeId", orphanRemoval = false)
    private Set<Store> stores = new HashSet<>();


    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Long getId() {

        return id;
    }

    public String getModel() {
        return model;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getDate() {
        return date;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    @Override
    public Long getIdEntity(){
        return this.getId();
    }

    @Override
    public String toString(){
        return "Notebook: id = " +id + ", "+ model + ", "+ vendor.getName() + ", "+ cpu.getModel()+", "+memory.getModel()+", " + date;
    }
}
