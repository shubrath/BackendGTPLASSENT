package com.gtpl.Assent.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtpl.Assent.Entity.Organization;
import com.gtpl.Assent.Entity.User;
import com.gtpl.Assent.Repository.OrganizationRepository;
import com.gtpl.Assent.Repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public User createUser(User user) {
        Integer organizationId = user.getOrganization().getOrganizationId();
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + organizationId));
        user.setOrganization(organization);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Integer userId, User user) {
        User existingUser = getUserById(userId);

        Integer organizationId = user.getOrganization().getOrganizationId();
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + organizationId));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setOrganization(organization);
        existingUser.setDepartment(user.getDepartment());
        existingUser.setStatus(user.getStatus());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }
}