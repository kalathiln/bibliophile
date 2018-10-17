package com.koma.library.dbservice.model;

import javax.persistence.*;

@Entity
@Table(name="quotes" , catalog="test")
public class Quote {

    @Id
    // Specifying that the ID will be auto generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    // The column name is specified as id
    @Column(name = "id")
     private int id;
    @Column(name = "user_name")
     private String userName;
    @Column(name = "quote")
     private String quote;

    public Quote(String userName, String quote) {
		this.userName = userName;
		this.quote = quote;
	}

	public Quote() {
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
