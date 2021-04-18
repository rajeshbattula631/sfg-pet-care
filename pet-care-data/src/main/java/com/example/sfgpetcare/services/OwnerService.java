package com.example.sfgpetcare.services;

import com.example.sfgpetcare.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
