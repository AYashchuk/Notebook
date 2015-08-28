package mainpack.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 11.12.2014.
 */
@Entity
@Table(name = "MEMORY")
public class Memory implements GetIdtable {
    public Memory(){

    }

    public Memory(String model, Vendor vendor, Integer hdd) {
        this.model = model;
        this.vendor = vendor;
        this.hdd = hdd;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORYS_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "MEMORY_ID")
    private Long id;

    @Column(name = "MEMORY_MODEL")
    private String model;

    @JoinColumn(name="VENDOR_ID")
    @ManyToOne
    private Vendor vendor;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "cpu", orphanRemoval = false)
    private Set<Notebook> notebooks = new HashSet<>();

    @Column(name = "MEMORY_HDD")
    private Integer hdd;

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Integer getHdd() {
        return hdd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }

    @Override
    public Long getIdEntity(){
        return this.getId();
    }

    @Override
    public String toString(){
        return "Memory: id = " +id + ", "+ model + ", "+ vendor.getName() + ", "+hdd;
    }
}
