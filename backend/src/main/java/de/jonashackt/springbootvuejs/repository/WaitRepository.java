package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.domain.WaitHistory;

import org.springframework.data.repository.CrudRepository;

public interface WaitRepository extends CrudRepository<WaitHistory, Long> {

}
