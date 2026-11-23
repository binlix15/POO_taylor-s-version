package db;
import models.Hero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HeroDAO {

    public void saveDB(Hero h)
    {
        String sql = "INSERT INTO heroes (name, secretName, team, alive) VALUES (?,?,?,?)";
        try (Connection conn = Database.connect();
        PreparedStatement ps = conn.prepareStatement(sql)
        )
        {
            ps.setString(1,h.getName());
            ps.setString(2,h.getSecretName());
            ps.setBoolean(3,h.isTeam());
            ps.setBoolean(4,h.alive);
            ps.executeUpdate();
            System.out.println("Hero added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Hero> readAllHerosDB()
    {
        List<Hero> listaHeroes = new ArrayList<>();
        String sql = "SELECT * FROM heroes";
        try (
                Connection conn = Database.connect();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ){
            while (rs.next()) {
                listaHeroes.add(fromRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHeroes;
    }

    private Hero fromRow(ResultSet rs) throws SQLException {
        Hero h = new Hero();
        h.setId(rs.getInt("id"));
        h.setName(rs.getString("name"));
        h.setSecretName(rs.getString("secretName"));
        h.alive=rs.getBoolean("alive");

return h;
    }

}
