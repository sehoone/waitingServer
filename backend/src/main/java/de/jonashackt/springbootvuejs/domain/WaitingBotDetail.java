package de.jonashackt.springbootvuejs.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="waiting_bot_detail")
public class WaitingBotDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bot_detail_seq")
    private Long botDetailSeq;
    
	@Column(name = "server_name", length = 50, nullable = false)
    private String serverName;
    
	@Column(name = "wait_cnt", length = 50, nullable = true)
    private long waitCnt;
    
    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;
    
    @Column(name = "bot_info_seq")
    private Integer bot_info_seq;


    public WaitingBotDetail() {
    }

    public WaitingBotDetail(Long botDetailSeq, String serverName, long waitCnt, LocalDate createDate, Integer bot_info_seq) {
        this.botDetailSeq = botDetailSeq;
        this.serverName = serverName;
        this.waitCnt = waitCnt;
        this.createDate = createDate;
        this.bot_info_seq = bot_info_seq;
    }

    public Long getBotDetailSeq() {
        return this.botDetailSeq;
    }

    public void setBotDetailSeq(Long botDetailSeq) {
        this.botDetailSeq = botDetailSeq;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public long getWaitCnt() {
        return this.waitCnt;
    }

    public void setWaitCnt(long waitCnt) {
        this.waitCnt = waitCnt;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Integer getBot_info_seq() {
        return this.bot_info_seq;
    }

    public void setBot_info_seq(Integer bot_info_seq) {
        this.bot_info_seq = bot_info_seq;
    }

    public WaitingBotDetail botDetailSeq(Long botDetailSeq) {
        this.botDetailSeq = botDetailSeq;
        return this;
    }

    public WaitingBotDetail serverName(String serverName) {
        this.serverName = serverName;
        return this;
    }

    public WaitingBotDetail waitCnt(long waitCnt) {
        this.waitCnt = waitCnt;
        return this;
    }

    public WaitingBotDetail createDate(LocalDate createDate) {
        this.createDate = createDate;
        return this;
    }

    public WaitingBotDetail bot_info_seq(Integer bot_info_seq) {
        this.bot_info_seq = bot_info_seq;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WaitingBotDetail)) {
            return false;
        }
        WaitingBotDetail waitingBotDetail = (WaitingBotDetail) o;
        return Objects.equals(botDetailSeq, waitingBotDetail.botDetailSeq) && Objects.equals(serverName, waitingBotDetail.serverName) && waitCnt == waitingBotDetail.waitCnt && Objects.equals(createDate, waitingBotDetail.createDate) && Objects.equals(bot_info_seq, waitingBotDetail.bot_info_seq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(botDetailSeq, serverName, waitCnt, createDate, bot_info_seq);
    }

    @Override
    public String toString() {
        return "{" +
            " botDetailSeq='" + getBotDetailSeq() + "'" +
            ", serverName='" + getServerName() + "'" +
            ", waitCnt='" + getWaitCnt() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", bot_info_seq='" + getBot_info_seq() + "'" +
            "}";
    }


}
