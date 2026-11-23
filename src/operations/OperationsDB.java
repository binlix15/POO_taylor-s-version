package operations;

import db.HeroDAO;
import models.Hero;

public class OperationsDB {

    private static final HeroDAO dao = new HeroDAO();

    public static void saveHeroDB(Hero h2save)
    {
        dao.saveDB(h2save);
    }

    public static void readAllHeroresDB(){
    for (Hero h: dao.readAllHerosDB()){
        System.out.println(h);
    }
    }

}
