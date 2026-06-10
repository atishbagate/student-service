package com.testOne.userService;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Transactional
    public Address createAddress(Address address){
        return addressRepository.save(address);
    }
    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }
    public Address getAddressById(Long id){
        return addressRepository.findById(id).orElseThrow(()-> new RuntimeException("Address not found by given Id."+id));
    }
    
    @Transactional
    public Address updateAddress(Long id, Address addressDetails){
        Address existingAddress = getAddressById(id);
        existingAddress.setStreet(addressDetails.getStreet());
        existingAddress.setCity(addressDetails.getCity());
        existingAddress.setZipCode(addressDetails.getZipCode());
        return addressRepository.save(existingAddress);
    }
    
    @Transactional
    public void deleteAddress(Long id){
        Address existingAddress = getAddressById(id);
        addressRepository.delete(existingAddress);
    }
}
