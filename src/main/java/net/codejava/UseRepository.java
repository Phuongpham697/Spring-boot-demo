package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UseRepository extends JpaRepository<Use, Long> {
    @Query("SELECT p FROM Use p WHERE CONCAT(p.name, ' ', p.age, ' ', p.address,' ', p.date) LIKE %?1%")
    public List<Use> search(String keyword);
}
