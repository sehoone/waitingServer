package de.jonashackt.springbootvuejs.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="waiting_bot_info")
public class WaitingBotInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bot_info_seq", nullable = false)
    private long botInfoSeq;
    
	@Column(name = "game_name", length = 50, nullable = true)
	private String gameName;

    @Column(name = "create_date", updatable = false)
	private LocalDate createDate;

	@OneToMany
	@JoinColumn(name = "bot_info_seq")
	private List<WaitingBotDetail> botDetails = new ArrayList<WaitingBotDetail>();


    public WaitingBotInfo() {
    }

    public WaitingBotInfo(long botInfoSeq, String gameName, LocalDate createDate, List<WaitingBotDetail> botDetails) {
        this.botInfoSeq = botInfoSeq;
        this.gameName = gameName;
        this.createDate = createDate;
        this.botDetails = botDetails;
    }

    public long getBotInfoSeq() {
        return this.botInfoSeq;
    }

    public void setBotInfoSeq(long botInfoSeq) {
        this.botInfoSeq = botInfoSeq;
    }

    public String getGameName() {
        return this.gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<WaitingBotDetail> getBotDetails() {
        return this.botDetails;
    }

    public void setBotDetails(List<WaitingBotDetail> botDetails) {
        this.botDetails = botDetails;
    }

    public WaitingBotInfo botInfoSeq(long botInfoSeq) {
        this.botInfoSeq = botInfoSeq;
        return this;
    }

    public WaitingBotInfo gameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public WaitingBotInfo createDate(LocalDate createDate) {
        this.createDate = createDate;
        return this;
    }

    public WaitingBotInfo botDetails(List<WaitingBotDetail> botDetails) {
        this.botDetails = botDetails;
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
        return botInfoSeq == waitingBotInfo.botInfoSeq && Objects.equals(gameName, waitingBotInfo.gameName) && Objects.equals(createDate, waitingBotInfo.createDate) && Objects.equals(botDetails, waitingBotInfo.botDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(botInfoSeq, gameName, createDate, botDetails);
    }

    @Override
    public String toString() {
        return "{" +
            " botInfoSeq='" + getBotInfoSeq() + "'" +
            ", gameName='" + getGameName() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", botDetails='" + getBotDetails() + "'" +
            "}";
    }

}
