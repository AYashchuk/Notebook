package mainpack.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Yashchuk A.F.
 */
@Entity
@Table(name = "STORES")
public class Store implements Serializable, GetIdtable {
    public Store(){

    }
    public Store(Notebook notebook, Double price, Integer amount) {
        this.notebook = notebook;
        this.price = price;
        this.amount = amount;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "STORES_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name = "STORE_ID")
    private Long storeId;


    @ManyToOne
    @JoinColumn(name = "NOTEBOOK_ID"/*, unique = true*/)
    private Notebook notebook;



    //@OneToMany (fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "store", orphanRemoval = false)
    //private Set<Sales> sales = new HashSet<>();

    @Column(name = "STORE_PRICE")
    private Double price;

    @Column(name = "STORE_AMOUNT")
    private Integer amount;


    public Long getId() {
        return storeId;
    }

/*  //  public Set<Sales> getSales() {
        return sales;
    }*/

    public Double getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.storeId = id;
    }

    public void setNotebood(Notebook notebood) {
        this.notebook = notebood;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

   /* public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }
*/
    public Notebook getNotebook() {

        return notebook;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Store: id = " + storeId + ", " + notebook.getModel() + ", " + amount + ", " + price;
    }

    @Override
    public Long getIdEntity() {
        return this.getId();
    }
}
