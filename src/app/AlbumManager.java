/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Entity.Album;
import Entity.Artist;
import Util.PersistenceUtil;
import java.sql.SQLException;
import repo.AlbumRepository;
import repo.ArtistRepository;
import repo.Database;

/**
 *
 * @author Palalae
 */
public class AlbumManager {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Database db = Database.getInstance();
        ArtistRepository art = new ArtistRepository();
        Artist artist1 = new Artist(1,"Eminem","USA");
        Artist artist2 = new Artist(2,"Michael Jackson","USA");
        Artist artist3 = new Artist(3,"Deliric","Romania");
        Artist artist4 = new Artist(4,"Parazitii","Romania");
        art.create(artist1);
        art.create(artist2);
        art.create(artist3);
        art.create(artist4);
        
        Artist artist5 = art.findByName("Eminem");
        System.out.println(artist5.getName() +" "+ artist5.getId() +" "+ artist5.getCountry());
        Album album1 = new Album(1, "Kamikaze", 2018, 1);
        Album album2 = new Album(2, "History", 1995, 2);
        Album album3 = new Album(3, "DeliricXSlentStrike", 2016, 3);
        Album album4 = new Album(4, "Arma Secreta", 2019, 4);
        AlbumRepository album = new AlbumRepository();
        album.create(album1);
        album.create(album2);
        album.create(album3);
        album.create(album4);
        //album.findByArtist(1);
        //PersistenceUtil util = PersistenceUtil.getInstance();
        //util.getEntityManagerFactory();
    }
}
