package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.domain.WaitHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitRepository extends JpaRepository<WaitHistory, Long> {

}
