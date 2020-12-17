package oksana.java.exercises.first.services;


import oksana.java.exercises.first.config.SystemConfiguration;
import oksana.java.exercises.first.entities.AddressEntity;
import oksana.java.exercises.first.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

public class AddressServiceTest {
    private SystemConfiguration systemConfiguration;
    private AddressRepository addressRepository;
    private AddressService addressService;

    @Before
    public void setEnvironment() {
        System.setProperty("environment-profile", "test");
        systemConfiguration = new SystemConfiguration();
        addressRepository = new AddressRepository(systemConfiguration);
        addressService = new AddressService(addressRepository);

    }

    @Test
    public void saveAddress() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertTrue(result);
    }


    @Test
    public void search() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        addressService.saveAddress(addressEntity);
        addressEntity = new AddressEntity("Tarun2",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        addressService.saveAddress(addressEntity);
        addressEntity = new AddressEntity("Tarun3",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        addressService.saveAddress(addressEntity);
        addressEntity = new AddressEntity("Tarun4",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        addressService.saveAddress(addressEntity);
        addressEntity = new AddressEntity("Tarun5",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        addressService.saveAddress(addressEntity);

        String firstName = "Tarun";
        List<AddressEntity> adresses = addressService.search(firstName);
        Assert.assertEquals(adresses.size(), 5);

        firstName = "Tarun1";
        adresses = addressService.search(firstName);
        Assert.assertEquals(adresses.size(), 0);

        firstName = "Tarun2";
        adresses = addressService.search(firstName);
        Assert.assertEquals(adresses.size(), 1);


        firstName = "Tarun3";
        adresses = addressService.search(firstName);
        Assert.assertEquals(adresses.size(), 1);

        firstName = "Tarun4";
        adresses = addressService.search(firstName);
        Assert.assertEquals(adresses.size(), 1);

        firstName = "Tarun5";
        adresses = addressService.search(firstName);
        Assert.assertEquals(adresses.size(), 1);
    }
}
