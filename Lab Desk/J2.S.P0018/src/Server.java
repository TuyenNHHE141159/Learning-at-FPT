

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SAP-LAB-COMPUTER
 */
public class Server extends UnicastRemoteObject implements Register_Interface {

    public Server() throws RemoteException {
        super();
    }
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Register_Interface stub=new Server(); 
            Registry rgsty = LocateRegistry.createRegistry(8888);
            rgsty.rebind("addstudent",stub);
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Student addStudent(Student student) throws RemoteException {
         return student;
    }

    

}
