/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Palalae
 */
public class PersistenceUtil {

    public static final boolean DEBUG = true;

    private static final PersistenceUtil singleton = new PersistenceUtil();

    protected EntityManagerFactory emf;

    public static PersistenceUtil getInstance() {

        return singleton;
    }

    private PersistenceUtil() {
    }

    public EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {
            createEntityManagerFactory();
        }
        return emf;
    }

    public void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        if (DEBUG) {
            System.out.println("n*** Persistence started at " + new java.util.Date());
        }
    }
}
