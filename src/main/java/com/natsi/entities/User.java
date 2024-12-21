package com.natsi.entities;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import lombok.Data;
@Data
@Entity
@Table(name = "user")

public class User {
  
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    private int id;
    private String login;
    private String nom;
    private String prenom;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role ;
    private Etat etat;

    @OneToOne
    @JoinColumn(name ="client_id",nullable=true)
    private Client client;
    
    
}
