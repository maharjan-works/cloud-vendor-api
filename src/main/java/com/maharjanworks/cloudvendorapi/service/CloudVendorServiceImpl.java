package com.maharjanworks.cloudvendorapi.service;

import com.maharjanworks.cloudvendorapi.exception.CloudVendorNotFoundException;
import com.maharjanworks.cloudvendorapi.model.CloudVendor;
import com.maharjanworks.cloudvendorapi.repository.CloudVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        this.cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        this.cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        //Optional<CloudVendor> opt = this.cloudVendorRepository.findById(vendorId);
        //return (opt.isPresent())?opt.get():null;

        if (this.cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Request Cloud Vendor DOES NOT exists.");
        return this.cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return this.cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> findByVendorName(String vendorName) {
        return this.cloudVendorRepository.findByVendorName(vendorName);
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        this.cloudVendorRepository.deleteById(vendorId);
        return "Success";
    }
}
