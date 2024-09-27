package com.natsi.core.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.natsi.entities.User;
import com.natsi.repositories.bd.ClientRepositoryBD;
import com.natsi.repositories.bd.UserRepositoryBD;
import com.natsi.repositories.list.ClientRepository;
import com.natsi.repositories.list.UserRepository;

public class FactoryRepo {
        /*private EntityManagerFactory emf= Persistence.createEntityManagerFactory("SQL");
        private EntityManager em = emf.createEntityManager();*/
        
        private  ClientRepository clientRepo=null;
        private  UserRepository<User> userRepository=null;
        
    public  ClientRepository getInstanceClientRepository(){
        if(clientRepo==null){
            clientRepo=new ClientRepositoryBD();
        }
        return clientRepo;
    }
    public  UserRepository<User>  getInstanceUserRepository(){
        ClientRepositoryBD clientRepositoryBD = new ClientRepositoryBD();
        if( userRepository==null){
            userRepository= new UserRepositoryBD(clientRepositoryBD);
        }
        return  userRepository;
    }
    


    //UserRepository<User> userRepository= new UserRepositoryBD(clientRepositoryBD);
    
}
