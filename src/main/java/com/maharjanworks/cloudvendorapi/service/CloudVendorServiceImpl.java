package com.maharjanworks.cloudvendorapi.service;

import com.maharjanworks.cloudvendorapi.model.CloudVendor;
import com.maharjanworks.cloudvendorapi.repository.CloudVendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{


    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository){
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor Details Saved Successfully.";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor Details Updated Successfully.";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
       cloudVendorRepository.deleteById(vendorId);
        return "Cloud Vendor Details with Id: "+vendorId+" Deleted Successfully.";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        //Optional<CloudVendor> opt = this.cloudVendorRepository.findById(vendorId);
        //return (opt.isPresent())?opt.get():null;
        return cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
