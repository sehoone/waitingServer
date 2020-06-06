package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.domain.WaitingBotInfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WaitingBotInfoRepository extends JpaRepository<WaitingBotInfo, Long> {
 
    @Query(nativeQuery = true, value = "SELECT bot_info_seq, create_date, game_name FROM waiting_bot_info m ORDER BY bot_info_seq DESC LIMIT 1")
    WaitingBotInfo findByLastRow();

    WaitingBotInfo findById(long bot_info_seq);
}
