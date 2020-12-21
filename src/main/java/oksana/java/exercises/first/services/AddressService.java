package oksana.java.exercises.first.services;

import oksana.java.exercises.first.config.SystemConfiguration;
import oksana.java.exercises.first.entities.AddressEntity;
import oksana.java.exercises.first.repository.AddressRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressService {

    private final AddressRepository addressRepository;
    private SystemConfiguration systemConfiguration;


    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public boolean saveAddress(AddressEntity addressEntity) {
        if (validateAddressEntity(addressEntity)) {
            try {
                addressRepository.save(addressEntity);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean validateAddressEntity(AddressEntity addressEntity) {
        if (validateAddressField(addressEntity.getFirstName())
                || validateAddressField(addressEntity.getLastName())
                || validateAddressField(addressEntity.getStreetName())
                || validateAddressField(addressEntity.getCity())
                || validateAddressField(addressEntity.getCountry())) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAddressField(String someInputString) {
        return null == someInputString || someInputString.isBlank() || !someInputString.matches("^[A-Za-z]+$");
    }

    public List<AddressEntity> search(String searchQuery) {
        List<AddressEntity> result = new ArrayList<AddressEntity>();
        try {
            List<AddressEntity> allAddresses = addressRepository.getAllAddresses();
            for (AddressEntity addressEntity : allAddresses) {
                if (addressEntity.getFirstName().contains(searchQuery)) {
                    result.add(addressEntity);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}






