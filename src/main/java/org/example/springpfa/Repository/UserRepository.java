package org.example.springpfa.Repository;


import org.example.springpfa.entities.Demande;
import org.example.springpfa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findById(Long id);
    public User findByEmail(String email);
    public User findByUsername(String userName);
    public User findByusername(String username);
    @Query("SELECT u.demandes FROM User u WHERE u.username = :username")
    List<Demande> findDemandesByUsername(String username);

    @Query("SELECT u.userRole.nomRole FROM User u WHERE u.username = :username")
    String findRoleIdByUsername(String username);
}
