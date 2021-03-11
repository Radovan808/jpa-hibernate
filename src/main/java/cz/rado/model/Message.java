package cz.rado.model;

import javax.persistence.*;
import java.util.Date;

@Entity


public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    public Message(String message) {
        this.message = message;
    }

    private String message;

    Date CREATE_DATE;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
