package com.maharjanworks.cloudvendorapi.controller;

import com.maharjanworks.cloudvendorapi.model.CloudVendor;
import com.maharjanworks.cloudvendorapi.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

   CloudVendorService cloudVendorService;

   public CloudVendorController(CloudVendorService cloudVendorService){
       this.cloudVendorService = cloudVendorService;
   }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return  cloudVendorService.getCloudVendor(vendorId);
                //new CloudVendor("c100","Vendor 1", "address 1", "vendor phone number 1");
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails(){
       return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
       return cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return cloudVendorService.updateCloudVendor(cloudVendor);
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return cloudVendorService.deleteCloudVendor(vendorId);
    }
}
