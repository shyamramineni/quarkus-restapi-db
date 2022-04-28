package org.shyam;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Todo extends PanacheEntity {

    /* @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todoSeq")
    @SequenceGenerator(name = "todoSeq",sequenceName = "todo_id_seq",initialValue = 1, allocationSize = 1)
    public Long id;    */

    public String title;
    public boolean completed;
    @Column(name="ordering")
    public int order;

    public Todo(String title, boolean completed, int order) {

        this.title = title;
        this.completed = completed;
        this.order = order;

    }

    public Todo() {
        
    }

}
