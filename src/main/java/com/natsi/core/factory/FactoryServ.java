package com.natsi.core.factory;
import com.natsi.services.ClientService;
import com.natsi.services.Impl.ArticleServiceImpl;
import com.natsi.services.Impl.ClientServiceImpl;
import com.natsi.services.Impl.UserServiceImpl;

public class FactoryServ {

        UserServiceImpl userServiceImpl= null;
        ClientService clientServiceImpl= null;
        ArticleServiceImpl articleServiceImpl=null;
        FactoryRepo factoryService = new FactoryRepo();
        
    public  UserServiceImpl getInstanceUserServiceImpl(){
        if(userServiceImpl==null){
            userServiceImpl=new UserServiceImpl(factoryService.getInstanceUserRepository());
        }
        return userServiceImpl;
    }
    public ClientService  getInstanceClientService(){
        if(clientServiceImpl==null){
            clientServiceImpl= new ClientServiceImpl(factoryService.getInstanceUserRepository(),factoryService.getInstanceClientRepository());
        }
        return  clientServiceImpl;
    }

}
