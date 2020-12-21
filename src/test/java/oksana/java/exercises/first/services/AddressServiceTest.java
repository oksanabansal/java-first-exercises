package oksana.java.exercises.first.services;


import oksana.java.exercises.first.config.SystemConfiguration;
import oksana.java.exercises.first.entities.AddressEntity;
import oksana.java.exercises.first.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

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
    public void saveAddress_firstNameNumeric() {
        AddressEntity addressEntity = new AddressEntity("T4run",
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
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_firstNameBlank() {
        AddressEntity addressEntity = new AddressEntity(" ",
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
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_firstNameBlank_2nd() {
        AddressEntity addressEntity = new AddressEntity("",
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
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_firstNameNull() {
        AddressEntity addressEntity = new AddressEntity(null,
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
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_lastNameNumeric() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "B@nsal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_lastNameBlank() {
        AddressEntity addressEntity = new AddressEntity(" ",
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
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_lastNameBlank_2nd() {
        AddressEntity addressEntity = new AddressEntity("",
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
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_lastNameNull() {
        AddressEntity addressEntity = new AddressEntity(null,
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
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_streetNameNumeric() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Tr6ffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_streetNameBlank() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                " ",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_streetNameBlank_2nd() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_streetNameNull() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                null,
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_cityNumeric() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Al=ere",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_cityBlank() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                " ",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_cityBlank_2nd() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "",
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_cityNull() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                null,
                "1325Ps",
                "Nl");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_countryNumeric() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "N)");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_countryBlank() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                " ");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_countryBlank_2nd() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                "");
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }

    @Test
    public void saveAddress_countryNull() {
        AddressEntity addressEntity = new AddressEntity("Tarun",
                "",
                "Bansal",
                "Truffautstraat",
                "53",
                "A",
                "Filmwijk",
                "Almere",
                "1325Ps",
                null);
        boolean result = addressService.saveAddress(addressEntity);
        Assert.assertFalse(result);
    }


    //    @Test
    public void searchTest() {
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
        Assert.assertEquals(5, adresses.size());

        firstName = "Tarun1";
        adresses = addressService.search(firstName);
        Assert.assertEquals(0, adresses.size());

        firstName = "Tarun2";
        adresses = addressService.search(firstName);
        Assert.assertEquals(1, adresses.size());


        firstName = "Tarun3";
        adresses = addressService.search(firstName);
        Assert.assertEquals(1, adresses.size());

        firstName = "Tarun4";
        adresses = addressService.search(firstName);
        Assert.assertEquals(1, adresses.size());

        firstName = "Tarun5";
        adresses = addressService.search(firstName);
        Assert.assertEquals(1, adresses.size());

    }


}
