package com.example.exercisejparelation.Service;

import com.example.exercisejparelation.Api.ApiException;
import com.example.exercisejparelation.DTO.AddressDTO;
import com.example.exercisejparelation.Model.Address;
import com.example.exercisejparelation.Model.Teacher;
import com.example.exercisejparelation.Repository.AddressRepository;
import com.example.exercisejparelation.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public void addTeacherAddress(AddressDTO addressDTO) {
        Teacher t = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (t==null){
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),t);
        addressRepository.save(address);
    }

    public void updateTeacherAddress(AddressDTO addressDTO) {

        Address a = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (a==null){
            throw new ApiException("Teacher Address not found");
        }

        a.setArea(addressDTO.getArea());
        a.setStreet(addressDTO.getStreet());
        a.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(a);
    }

    public void deleteTeacherAddress(int teacherAddress_id) {
        Address a = addressRepository.findAddressById(teacherAddress_id);
        if (a==null){
            throw new ApiException("Teacher Address not found");
        }
        Teacher t = teacherRepository.findTeacherById(a.getId());
        if (t==null){
            throw new ApiException("Teacher not found");
        }
        t.setAddress(null);
        addressRepository.deleteById(a.getId());

    }
}

