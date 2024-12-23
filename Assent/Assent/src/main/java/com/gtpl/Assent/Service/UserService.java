package com.gtpl.Assent.Service;



import java.util.List;

import com.gtpl.Assent.Entity.User;

public interface UserService {

    /**
     * Creates a new user and associates it with an organization.
     *
     * @param user The user to be created.
     * @return The created user.
     */
    User createUser(User user);

    /**
     * Retrieves a user by their ID.
     *
     * @param userId The ID of the user to be retrieved.
     * @return The user with the specified ID.
     */
    User getUserById(Integer userId);

    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    List<User> getAllUsers();

    /**
     * Updates an existing user.
     *
     * @param userId The ID of the user to be updated.
     * @param user   The updated user details.
     * @return The updated user.
     */
    User updateUser(Integer userId, User user);

    /**
     * Deletes a user by their ID.
     *
     * @param userId The ID of the user to be deleted.
     */
    void deleteUser(Integer userId);
}