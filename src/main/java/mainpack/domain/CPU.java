package mainpack.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yashchuk A.F.
 */
@Entity
@Table(name = "CPUS")
public class CPU implements GetIdtable {
    public CPU(){
        
    }
    public CPU(Integer frequency, String model, Vendor vendor, Set<Notebook> notebooks) {
        this.frequency = frequency;
        this.model = model;
        this.vendor = vendor;
        this.notebooks = notebooks;
    }

    public CPU(Integer frequency, String model, Vendor vendor) {
        this.frequency = frequency;
        this.model = model;
        this.vendor = vendor;
    }
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPUS_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "CPU_ID")
    private Long id;

    @Column(name = "CPU_FREQUENCY")
    private Integer frequency;

    @Column(name = "CPU_MODEL")
    private String model;

    @JoinColumn(name="VENDOR_ID")
    @ManyToOne
    private Vendor vendor;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "cpu", orphanRemoval = false)
    private Set<Notebook> notebooks = new HashSet<>();


    public Long getId() {
        return id;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public String getModel() {
        return model;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public Long getIdEntity(){
        return this.getId();
    }

    @Override
    public String toString(){
        return "CPU: id = " +id + ", "+ model + ", "+ frequency;
    }
}
