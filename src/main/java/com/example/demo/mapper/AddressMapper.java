package com.example.demo.mapper;

import com.example.demo.dto.request.AddressRequest;
import com.example.demo.model.Address;

import java.util.List;

public final class AddressMapper {
    public static List<Address> requestToAddress(List<AddressRequest> addressRequests) {
        return addressRequests.stream()
                .map(request -> {
                    return new Address(
                            request.getId(),
                            request.getName(),
                            request.getStreet(),
                            request.getCountryCode()
                    );
                })
                .toList();
    }
}
