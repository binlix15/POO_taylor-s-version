import db.Database;
import models.Album;
import operations.OperationsDB;

import java.util.Scanner;

public class Main {

    // un solo Scanner para todo el programa
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        // crea la tabla si todavia no existe
        Database.createTable();

        int opcion;

        do {
            System.out.println("\n ************** CRUD TAYLOR SWIFT ***********");
            System.out.println("1. Crear album");
            System.out.println("2. Mostrar albumes");
            System.out.println("3. Actualizar album");
            System.out.println("4. Eliminar album");
            System.out.println("0. para salir");
            System.out.println("\n ************** CRUD TAYLOR SWIFT ***********");

            opcion = leer.nextInt();
            leer.nextLine(); // limpia el enter que queda despues del numero

            switch (opcion) {
                case 1:
                    OperationsDB.saveAlbumDB(nextAlbum());
                    break;
                case 2:
                    OperationsDB.readAllAlbumsDB();
                    break;
                case 3:
                    System.out.println("Ingrese el ID del album a actualizar");
                    int idActualizar = leer.nextInt();
                    leer.nextLine();
                    Album nuevo = nextAlbum();
                    nuevo.setId(idActualizar);
                    OperationsDB.updateAlbumDB(nuevo);
                    break;
                case 4:
                    System.out.println("Ingrese el ID del album a eliminar");
                    int idEliminar = leer.nextInt();
                    leer.nextLine();
                    OperationsDB.deleteAlbumDB(idEliminar);
                    break;
                case 0:
                    System.out.println("Nos vemos");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);

    }

    // Pide los datos por consola y arma un Album
    public static Album nextAlbum() {
        Album a1 = new Album();

        System.out.println("Ingrese el nombre del album");
        a1.setName(leer.nextLine());

        System.out.println("Ingrese el año de lanzamiento");
        a1.setYear(leer.nextInt());
        leer.nextLine();

        System.out.println("Ingrese los 3 sencillos (uno por linea)");
        String[] tempSingles = new String[3];
        tempSingles[0] = leer.nextLine();
        tempSingles[1] = leer.nextLine();
        tempSingles[2] = leer.nextLine();
        a1.setSingles(tempSingles);

        System.out.println("Tiene Taylor's Version? (true/false)");
        a1.setRerecorded(leer.nextBoolean());
        leer.nextLine();

        System.out.println("Es de mis favoritos? (true/false)");
        a1.setFavorite(leer.nextBoolean());
        leer.nextLine();

        return a1;
    }

}