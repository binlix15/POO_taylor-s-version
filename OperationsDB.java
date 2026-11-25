package operations;

import db.AlbumDAO;
import models.Album;

public class OperationsDB {

    private static final AlbumDAO dao = new AlbumDAO();

    public static void saveAlbumDB(Album a2save) {
        dao.saveDB(a2save);
    }

    public static void readAllAlbumsDB() {
        for (Album a : dao.readAllAlbumsDB()) {
            System.out.println(a);
        }
    }

    public static void updateAlbumDB(Album a2update) {
        dao.updateDB(a2update);
    }

    public static void deleteAlbumDB(int id) {
        dao.deleteDB(id);
    }

}