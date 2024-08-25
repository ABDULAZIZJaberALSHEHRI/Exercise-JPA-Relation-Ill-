package com.example.exercisejparelation.Controller;

import com.example.exercisejparelation.DTO.AddressDTO;
import com.example.exercisejparelation.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor

public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get-all-address")
    private ResponseEntity getAllAddress() {
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }

    @PostMapping("/add-address")
    private ResponseEntity addAddress(@Valid @RequestBody AddressDTO address) {
        addressService.addTeacherAddress(address);
        return ResponseEntity.status(200).body("address added successfully");
    }

    @PutMapping("/update-address")
    private ResponseEntity updateAddress(@Valid @RequestBody AddressDTO address) {
        addressService.updateTeacherAddress(address);
        return ResponseEntity.status(200).body("address updated successfully");
    }

    @PutMapping("/delete-address/{teacheraddressid}")
    private ResponseEntity deleteAddress(@PathVariable int teacheraddressid) {
        addressService.deleteTeacherAddress(teacheraddressid);
        return ResponseEntity.status(200).body("address deleted successfully");
    }


}
