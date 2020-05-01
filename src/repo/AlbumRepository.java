/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import Entity.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

/**
 *
 * @author Palalae
 */
public class AlbumRepository {

    public void create(Album album) {
        Connection connection;
        Statement statement = null;

        try {
            connection = Database.getConnection();

            statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS artists (id int primary key unique auto_increment, name varchar(100) not null, country varchar(100))");
            statement.execute("CREATE TABLE IF NOT EXISTS albums "
                    + "(id int primary key unique auto_increment,"
                    + " name varchar(100) not null,"
                    + " artist_id int not null references artists on delete restrict,"
                    + " release_year int)");
            PreparedStatement posted;
            posted = connection.prepareStatement("insert into albums(name,artist_id,release_year) values('" + album.getName() + "'," + album.getArtistId() + "," + album.getReleaseYear() + ");");
            posted.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Album findById(int id) throws SQLException {
        Album album_founded = new Album();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from albums where id='" + id + "';");
            //System.out.println("select works");
            album_founded.setArtistId(Integer.parseInt(result.getString("artist_id")));
            album_founded.setName(result.getString("name"));
            album_founded.setId(Integer.parseInt(result.getString("id")));
            album_founded.setReleaseYear(Integer.parseInt(result.getString("release_year")));
            return album_founded;
            //System.out.print(result.getString("id") + " " + result.getString("name") + " " + result.getString("artist_id") + " " + result.getString("release_year") + "\n");

        } catch (SQLException e) {
            System.out.println(e);
        }
        return album_founded;
    }

    public Album findByName(String name) throws SQLException {
        Album album_founded = new Album();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from albums where name='" + name + "';");
            //System.out.println("select works");
            album_founded.setArtistId(Integer.parseInt(result.getString("artist_id")));
            album_founded.setName(result.getString("name"));
            album_founded.setId(Integer.parseInt(result.getString("id")));
            album_founded.setReleaseYear(Integer.parseInt(result.getString("release_year")));
            System.out.print(result.getString("id") + " " + result.getString("name") + " " + result.getString("artist_id") + " " + result.getString("release_year") + "\n");
            return album_founded;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return album_founded;
    }

    public void findByArtist(int artistId) throws SQLException {
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT a from Album a where ArtistId=" + artistId + "";
            EntityManager em = null;
            List<Album> posts = em.createNamedQuery("Album.findByArtistId", Album.class).getResultList();
            //System.out.println("select works");
            /*while (result.next()) {
                System.out.print(result.getString("id") + " " + result.getString("name") + " " + result.getString("artist_id") + " " + result.getString("release_year") + "\n");
            }*/
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
