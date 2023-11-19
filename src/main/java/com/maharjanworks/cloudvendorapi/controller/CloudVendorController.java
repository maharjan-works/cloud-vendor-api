package com.maharjanworks.cloudvendorapi.controller;

import com.maharjanworks.cloudvendorapi.model.CloudVendor;
import com.maharjanworks.cloudvendorapi.response.ResponseHandler;
import com.maharjanworks.cloudvendorapi.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    @Autowired
    private CloudVendorService cloudVendorService;

    @GetMapping("/{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
      return  ResponseHandler.responseBuilder("Cloud Vendor Found",HttpStatus.OK,this.cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails() {
        return this.cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        return this.cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
         this.cloudVendorService.updateCloudVendor(cloudVendor);
         return "Cloud Vendor updated successfully.";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return this.cloudVendorService.deleteCloudVendor(vendorId);
    }

//    @GetMapping("{vendorName}")
//    public List<CloudVendor> getCloudVendorsByName(@PathVariable("vendorName") String vendorName){
//        return this.cloudVendorService.findByVendorName(vendorName);
//    }
}
