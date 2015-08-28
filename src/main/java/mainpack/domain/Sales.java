package mainpack.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by admin on 11.12.2014.
 */
@Entity
@Table(name = "SALES")
public class Sales implements GetIdtable {
    public Sales(){

    }

    public Sales(Store store, String date, Notebook notebook, Long soldNotebook, Integer amount) {
        this.store = store;
        this.date = date;
        this.notebook = notebook;
        this.soldNotebook = soldNotebook;
        this.amount = amount;
    }

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SALES_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")


    @Column(name = "SALES_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @Column(name = "SALES_DATE")
    @Type(type = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "NOTEBOOK_ID")
    private Notebook notebook;

    @Column(name = "SOLD_NOTEBOOKS")
    private Long soldNotebook;

    public void setSoldNotebook(Long soldNotebook) {
        this.soldNotebook = soldNotebook;
    }

    public Long getSoldNotebook() {

        return soldNotebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Notebook getNotebook() {

        return notebook;
    }

    @Column(name = "SALES_AMOUNT")
    private Integer amount;

    public Long getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }

    public String getDate() {
        return date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public Long getIdEntity(){
        return this.getId();
    }

    @Override
    public String toString() {
        return "Sales: id = " + id + ", " + date+ ", " + amount + ", " + store;
    }
}
