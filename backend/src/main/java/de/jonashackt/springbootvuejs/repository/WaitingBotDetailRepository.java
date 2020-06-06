package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.domain.WaitingBotDetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WaitingBotDetailRepository extends JpaRepository<WaitingBotDetail, Long> {

    @Query(nativeQuery = true, value = "SELECT server_name, wait_cnt, create_date FROM waiting_bot_detail WHERE bot_info_seq=:seq")
    List<WaitingBotDetail> selectSeqList(@Param("seq") long seq);

}
