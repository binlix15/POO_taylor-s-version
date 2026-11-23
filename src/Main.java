import models.Hero;
import operations.OperationCSV;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
     Scanner leer = new Scanner(System.in);
        //

        //Operation.saveHero(h1);


        //Operation.readHeroes();
        //GUI JAVA SWING
        //.saveHero()

        int opcion;

        do {
            System.out.println("\n ************** CRUD MARVEL ***********");
            System.out.println("1. Crear Heroe");
            System.out.println("2. Mostrar heroes");
            //TODO the rest of the operations
            System.out.println("0. para salir");
            System.out.println("\n ************** CRUD MARVEL ***********");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    OperationCSV.saveHero(nextHero());
                    break;
                case 2:
                    OperationCSV.readHeroes();
                    break;
                case 0:
                    System.out.println("Nos vemos");
                    break;

            }
        } while (opcion!=0);






    }

    public static Hero nextHero()
    {
        Scanner leer = new Scanner(System.in);
        Hero h1 = new Hero();

        //Ingresar datos con los getter y setter
        System.out.println("Ingrese el nombre del Hero");
        h1.setName(leer.nextLine());

        System.out.println("Ingrese el nombre secreto");
        h1.setSecretName(leer.nextLine());

        System.out.println("Ingrese el ID");
        h1.setId(leer.nextInt());

        System.out.println("Ingrese los poderes");
        String [] tempPowers = new String[3];
        tempPowers[0]= leer.nextLine();
        tempPowers[1]= leer.nextLine();
        tempPowers[2]= leer.nextLine();
        h1.setPowers(tempPowers);

        h1.setTeam(true);
        return h1;
    }

}
