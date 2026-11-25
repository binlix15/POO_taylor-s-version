package db;

import models.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    // CREATE: guardar un album nuevo
    public void saveDB(Album a) {
        String sql = "INSERT INTO albums (name, release_year, singles, rerecorded, favorite) VALUES (?,?,?,?,?)";
        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getName());
            ps.setInt(2, a.getYear());
            // la base de datos no guarda arreglos asi que junto los sencillos en un solo texto
            ps.setString(3, String.join(",", a.getSingles()));
            ps.setBoolean(4, a.isRerecorded());
            ps.setBoolean(5, a.isFavorite());
            ps.executeUpdate();
            System.out.println("Album agregado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // READ: traer todos los albumes
    public List<Album> readAllAlbumsDB() {
        List<Album> listaAlbumes = new ArrayList<>();
        String sql = "SELECT * FROM albums ORDER BY id";
        try (Connection conn = Database.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                listaAlbumes.add(fromRow(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaAlbumes;
    }

    // UPDATE: cambiar los datos de un album usando su id
    public void updateDB(Album a) {
        String sql = "UPDATE albums SET name = ?, release_year = ?, singles = ?, rerecorded = ?, favorite = ? WHERE id = ?";
        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getName());
            ps.setInt(2, a.getYear());
            ps.setString(3, String.join(",", a.getSingles()));
            ps.setBoolean(4, a.isRerecorded());
            ps.setBoolean(5, a.isFavorite());
            ps.setInt(6, a.getId());

            int filas = ps.executeUpdate();   // devuelve cuantas filas cambio
            if (filas > 0) {
                System.out.println("Album actualizado");
            } else {
                System.out.println("No existe un album con ese id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE: borrar un album por su id
    public void deleteDB(int id) {
        String sql = "DELETE FROM albums WHERE id = ?";
        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Album eliminado");
            } else {
                System.out.println("No existe un album con ese id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Convierte una fila de la base de datos en un objeto Album
    private Album fromRow(ResultSet rs) throws SQLException {
        Album a = new Album();
        a.setId(rs.getInt("id"));
        a.setName(rs.getString("name"));
        a.setYear(rs.getInt("release_year"));
        // el texto guardado "a,b,c" lo separo otra vez en un arreglo
        a.setSingles(rs.getString("singles").split(","));
        a.setRerecorded(rs.getBoolean("rerecorded"));
        a.setFavorite(rs.getBoolean("favorite"));
        return a;
    }

}