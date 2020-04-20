package de.jonashackt.springbootvuejs.domain;

import java.io.Serializable;
import java.util.Objects;

public class WaitingBotDetailId implements Serializable{

    private static final long serialVersionUID = 1L;

    private long bot_info_seq;
    
    private String server_name;
    

    public WaitingBotDetailId() {
    }

    public WaitingBotDetailId(long bot_info_seq, String server_name) {
        this.bot_info_seq = bot_info_seq;
        this.server_name = server_name;
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

    public WaitingBotDetailId bot_info_seq(long bot_info_seq) {
        this.bot_info_seq = bot_info_seq;
        return this;
    }

    public WaitingBotDetailId server_name(String server_name) {
        this.server_name = server_name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WaitingBotDetailId)) {
            return false;
        }
        WaitingBotDetailId waitingBotDetailId = (WaitingBotDetailId) o;
        return bot_info_seq == waitingBotDetailId.bot_info_seq && Objects.equals(server_name, waitingBotDetailId.server_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bot_info_seq, server_name);
    }

    @Override
    public String toString() {
        return "{" +
            " bot_info_seq='" + getBot_info_seq() + "'" +
            ", server_name='" + getServer_name() + "'" +
            "}";
    }

 
}
