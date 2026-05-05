package com.example.demo.mapper;

import com.example.demo.dto.response.AddressResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.utils.DateTimeUtil;

import java.util.List;

public final class UserMapper {

    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setPhone(user.getPhone());
        response.setTaxId(user.getTaxId());
        response.setCreatedAt(DateTimeUtil.format(user.getCreatedAt()));
        response.setAddresses(toAddressResponses(user.getAddresses()));

        return response;
    }

    private static List<AddressResponse> toAddressResponses(List<Address> addresses) {
        if (addresses == null || addresses.isEmpty())
            return List.of();

        return addresses.stream()
                .map(UserMapper::toAddressResponse)
                .toList();
    }

    private static AddressResponse toAddressResponse(Address address) {
        AddressResponse response = new AddressResponse();

        response.setId(address.getId());
        response.setName(address.getName());
        response.setStreet(address.getStreet());
        response.setCountryCode(address.getCountryCode());

        return response;
    }
}
