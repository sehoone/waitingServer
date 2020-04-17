package de.jonashackt.springbootvuejs.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="waiting_bot_datail")
public class WaitingBotDetail implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
	@Column(name = "bot_info_seq", length = 11, nullable = false)
    private long bot_info_seq;
    
	@Column(name = "server_name", length = 50, nullable = false)
    private String server_name;
    
	@Column(name = "wait_cnt", length = 50, nullable = true)
    private long wait_cnt;
    
    @Column(name = "create_date", updatable = false)
	private LocalDate create_date;

    protected WaitingBotDetail() {
    }

    public WaitingBotDetail(long bot_info_seq, String server_name, long wait_cnt, LocalDate create_date) {
        this.bot_info_seq = bot_info_seq;
        this.server_name = server_name;
        this.wait_cnt = wait_cnt;
        this.create_date = create_date;
    }

    public long getBot_info_seq() {
        return this.bot_info_seq;
    }

    public void setBot_info_seq(long bot_info_seq) {
        this.bot_info_seq = bot_info_seq;
    }

    public String getServer_name() {
        return this.server_name;
    }

    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }

    public long getWait_cnt() {
        return this.wait_cnt;
    }

    public void setWait_cnt(long wait_cnt) {
        this.wait_cnt = wait_cnt;
    }

    public LocalDate getCreate_date() {
        return this.create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public WaitingBotDetail bot_info_seq(long bot_info_seq) {
        this.bot_info_seq = bot_info_seq;
        return this;
    }

    public WaitingBotDetail server_name(String server_name) {
        this.server_name = server_name;
        return this;
    }

    public WaitingBotDetail wait_cnt(long wait_cnt) {
        this.wait_cnt = wait_cnt;
        return this;
    }

    public WaitingBotDetail create_date(LocalDate create_date) {
        this.create_date = create_date;
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
        return bot_info_seq == waitingBotDetail.bot_info_seq && Objects.equals(server_name, waitingBotDetail.server_name) && wait_cnt == waitingBotDetail.wait_cnt && Objects.equals(create_date, waitingBotDetail.create_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bot_info_seq, server_name, wait_cnt, create_date);
    }

    @Override
    public String toString() {
        return "{" +
            " bot_info_seq='" + getBot_info_seq() + "'" +
            ", server_name='" + getServer_name() + "'" +
            ", wait_cnt='" + getWait_cnt() + "'" +
            ", create_date='" + getCreate_date() + "'" +
            "}";
    }
 
}
