package br.ufg.inf.backend.StpDourados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.backend.StpDourados.domain.user.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByEmail(String email);
}
