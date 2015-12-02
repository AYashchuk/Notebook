package mainpack.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yashchuk A.F.
 */
@Entity
@Table(name = "VENDORS")
public class Vendor implements GetIdtable {
    public Vendor(){

    }
    public Vendor(String name, Set<Notebook> notebooks, Set<CPU> cpus, Set<Memory> hdd) {
        this.name = name;
        this.notebooks = notebooks;
        this.cpus = cpus;
        this.hdd = hdd;
    }
    public Vendor(String name) {
        this.name = name;

    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VENDORS_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "VENDOR_ID")
    private Long id;

    @Column(name = "VENDOR_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "vendor")
    private Set<Notebook> notebooks = new HashSet<Notebook>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "vendor")
    private Set<CPU> cpus = new HashSet<CPU>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "vendor")
    private Set<Memory> hdd = new HashSet<Memory>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }

    public Set<CPU> getCpus() {
        return cpus;
    }

    public Set<Memory> getHdd() {
        return hdd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotebooks(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public void setCpus(Set<CPU> cpus) {
        this.cpus = cpus;
    }

    public void setHdd(Set<Memory> hdd) {
        this.hdd = hdd;
    }

    @Override
    public Long getIdEntity(){
        return this.getId();
    }

    @Override
    public String toString() {
        return "Vendor: id = " + id + ", " + name ;
    }
}
