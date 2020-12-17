package oksana.java.exercises.first.services;

import oksana.java.exercises.first.entities.AddressEntity;
import oksana.java.exercises.first.repository.AddressRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public boolean saveAddress(AddressEntity addressEntity) {
        try {
            addressRepository.save(addressEntity);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<AddressEntity> search(String searchQuery) {
        List<AddressEntity> result = new ArrayList<>();
        try {
            List<AddressEntity> allAddresses = addressRepository.getAllAddresses();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
