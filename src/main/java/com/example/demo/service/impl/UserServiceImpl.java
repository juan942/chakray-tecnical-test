package com.example.demo.service.impl;

import com.example.demo.data.UserDataLoader;
import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserPatchRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.helper.UserCriteriaHelper;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.AesEncryptionUtil;
import com.example.demo.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> users = new ArrayList<>();

    public UserServiceImpl() {
        this.users.addAll(UserDataLoader.loadInitialUsers());
    }

    @Override
    public List<UserResponse> getUsers(String sortedBy, String filter) {
        List<User> result = new ArrayList<>(this.users);

        if (filter != null && !filter.isBlank())
            result = UserCriteriaHelper.applyFilter(users, filter);

        if  (sortedBy != null && !sortedBy.isBlank())
            result.sort(UserCriteriaHelper.getComparator(sortedBy));

        return result.stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse createUser(UserCreateRequest request) {
        // Validate unique tax

        User newUser = new User(
                UUID.randomUUID(),
                request.getEmail(),
                request.getName(),
                request.getPhone(),
                AesEncryptionUtil.encrypt(request.getPassword()),
                request.getTaxId(),
                DateTimeUtil.nowInMadagascar(),
                AddressMapper.requestToAddress(request.getAddresses())
        );

        this.users.add(newUser);
        return UserMapper.toResponse(newUser);
    }

    @Override
    public UserResponse updateUser(UUID id, UserPatchRequest request) {
        User user = findUserById(id);

        if (request.getTaxId() != null && !request.getTaxId().isBlank()) {
            // Validate unique tax
            user.setTaxId(request.getTaxId());
        }

        if (request.getEmail() != null && !request.getEmail().isBlank())
            user.setEmail(request.getEmail());

        if (request.getName() != null && !request.getName().isBlank())
            user.setName(request.getName());

        if (request.getPhone() != null && !request.getPhone().isBlank())
            user.setPhone(request.getPhone());

        if (request.getPassword() != null && !request.getPassword().isBlank())
            user.setPassword(AesEncryptionUtil.encrypt(request.getPassword()));

        if (request.getAddresses() != null && !request.getAddresses().isEmpty())
            user.setAddresses(AddressMapper.requestToAddress(request.getAddresses()));

        return UserMapper.toResponse(user);
    }

    @Override
    public void deleteUser(UUID id) {
        User matchUser = this.findUserById(id);
        this.users.remove(matchUser);
    }

    private User findUserById(UUID id) {
        return users.stream()
                .filter((u) -> u.getId().equals(id))
                .findFirst()
                .orElse(new User());
    }
}
