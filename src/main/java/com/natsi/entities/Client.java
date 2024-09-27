package com.natsi.entities;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import lombok.Data;
@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    private int id;
    private String surname;
    private String telephone;
    private String adresse;
    @OneToOne
    private User user; 
}
