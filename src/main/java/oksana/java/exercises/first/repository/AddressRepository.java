package oksana.java.exercises.first.repository;

import oksana.java.exercises.first.config.SystemConfiguration;
import oksana.java.exercises.first.entities.AddressEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class AddressRepository {

    private final SystemConfiguration systemConfiguration;

    public AddressRepository(SystemConfiguration systemConfiguration) {
        this.systemConfiguration = systemConfiguration;
    }


    public void save(AddressEntity addressEntity) throws IOException {
        final String addressAsCSVLine = convertAddressEntityToCSVLine(addressEntity);
        this.addAddressToFile(addressAsCSVLine);
    }

    private String convertAddressEntityToCSVLine(AddressEntity addressEntity) {
        return String.join(",", addressEntity.getFirstName(),
                addressEntity.getMiddleName(),
                addressEntity.getLastName(),
                addressEntity.getStreetName(),
                addressEntity.getHouseNumber(),
                addressEntity.getAddition(),
                addressEntity.getDistrictName(),
                addressEntity.getCity(),
                addressEntity.getPostalCode(),
                addressEntity.getCountry());
    }

    private AddressEntity convertCSVLineToAddressEntity(String addressLine) {
        String[] addressLineArray = addressLine.split(",");
        return new AddressEntity(addressLineArray[0],
                addressLineArray[1],
                addressLineArray[2],
                addressLineArray[3],
                addressLineArray[4],
                addressLineArray[5],
                addressLineArray[6],
                addressLineArray[7],
                addressLineArray[8],
                addressLineArray[9]);
    }


    private void addAddressToFile(String addressEntity) throws IOException {
        try {
            final String newLine = System.getProperty("line.separator");
            Files.writeString(Paths.get(systemConfiguration.getProperty("oksana.exercise.first.db.file.path")),
                    addressEntity+newLine,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw e;
        }
    }

    public List<AddressEntity> getAllAddresses() throws IOException {
        return Files.readAllLines(Paths.get(systemConfiguration.getProperty("oksana.exercise.first.db.file.path"))).stream().map(this::convertCSVLineToAddressEntity).collect(Collectors.toList());
    }
}
