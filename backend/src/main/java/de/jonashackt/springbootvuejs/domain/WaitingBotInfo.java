package de.jonashackt.springbootvuejs.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="waiting_bot_info")
public class WaitingBotInfo {

    @Id
	@Column(name = "bot_info_seq", length = 20, nullable = false)
	private long bot_info_seq;
	@Column(name = "game_name", length = 50, nullable = true)
	private String game_name;

    @Column(name = "create_date", updatable = false)
	private LocalDate create_date;

    protected WaitingBotInfo() {
    }

    public WaitingBotInfo(long bot_info_seq, String game_name, LocalDate create_date) {
        this.bot_info_seq = bot_info_seq;
        this.game_name = game_name;
        this.create_date = create_date;
    }

    public long getBot_info_seq() {
        return this.bot_info_seq;
    }

    public void setBot_info_seq(long bot_info_seq) {
        this.bot_info_seq = bot_info_seq;
    }

    public String getGame_name() {
        return this.game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public LocalDate getCreate_date() {
        return this.create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public WaitingBotInfo bot_info_seq(long bot_info_seq) {
        this.bot_info_seq = bot_info_seq;
        return this;
    }

    public WaitingBotInfo game_name(String game_name) {
        this.game_name = game_name;
        return this;
    }

    public WaitingBotInfo create_date(LocalDate create_date) {
        this.create_date = create_date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WaitingBotInfo)) {
            return false;
        }
        WaitingBotInfo waitingBotInfo = (WaitingBotInfo) o;
        return bot_info_seq == waitingBotInfo.bot_info_seq && Objects.equals(game_name, waitingBotInfo.game_name) && Objects.equals(create_date, waitingBotInfo.create_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bot_info_seq, game_name, create_date);
    }

    @Override
    public String toString() {
        return "{" +
            " bot_info_seq='" + getBot_info_seq() + "'" +
            ", game_name='" + getGame_name() + "'" +
            ", create_date='" + getCreate_date() + "'" +
            "}";
    }


}
