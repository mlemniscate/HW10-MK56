package ir.maktab.todo.base.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> {

    public static final String IS_DELETED = "is_deleted";
    public static final String ID = "id";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private ID id;

    @Column(name = IS_DELETED, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Integer isDeleted;

    public BaseEntity() {
    }

    public BaseEntity(ID id) {
        this.id = id;
    }

    public BaseEntity(ID id, Integer isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Integer getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Integer deleted) {
        isDeleted = deleted;
    }
}
