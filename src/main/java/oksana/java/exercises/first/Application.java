package oksana.java.exercises.first;

import oksana.java.exercises.first.config.SystemConfiguration;
import oksana.java.exercises.first.entities.AddressEntity;
import oksana.java.exercises.first.repository.AddressRepository;
import oksana.java.exercises.first.services.AddressService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.setProperty("environment-profile", "prod");
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the address");
        System.out.println("Enter the First Name");
        final String firstName = scanner.nextLine();

        System.out.println("Enter the Middle Name");
        final String middleName = scanner.nextLine();

        System.out.println("Enter the Last Name");
        final String lastName = scanner.nextLine();

        System.out.println("Enter the Street Name");
        final String streetName = scanner.nextLine();

        System.out.println("Enter the House Number");
        final String houseNumber = scanner.nextLine();

        System.out.println("Enter the house number addition");
        final String addition = scanner.nextLine();

        System.out.println("Enter the District Name");
        final String district = scanner.nextLine();

        System.out.println("Enter the City Name");
        final String city = scanner.nextLine();

        System.out.println("Enter the PostalCode ");
        final String postalCode = scanner.nextLine();

        System.out.println("Enter the Country ");
        final String country = scanner.nextLine();

        final AddressEntity addressEntity = new AddressEntity(firstName, middleName, lastName, streetName, houseNumber, addition, district, city, postalCode, country);
        SystemConfiguration systemConfiguration = new SystemConfiguration();
        AddressRepository addressRepository = new AddressRepository(systemConfiguration);
        AddressService addressService = new AddressService(addressRepository);
        addressService.saveAddress(addressEntity);


        SystemConfiguration configs = new SystemConfiguration();

    }
}
