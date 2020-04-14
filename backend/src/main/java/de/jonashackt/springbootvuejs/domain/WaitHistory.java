package de.jonashackt.springbootvuejs.domain;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="wait_history")
public class WaitHistory {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    private String server_name;
    private String wait_cnt;
    private String create_date;

    protected WaitHistory() {
    }

    public WaitHistory(long seq, String server_name, String wait_cnt, String create_date) {
        this.seq = seq;
        this.server_name = server_name;
        this.wait_cnt = wait_cnt;
        this.create_date = create_date;
    }

    public long getSeq() {
        return this.seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getServer_name() {
        return this.server_name;
    }

    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }

    public String getWait_cnt() {
        return this.wait_cnt;
    }

    public void setWait_cnt(String wait_cnt) {
        this.wait_cnt = wait_cnt;
    }

    public String getCreate_date() {
        return this.create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public WaitHistory seq(long seq) {
        this.seq = seq;
        return this;
    }

    public WaitHistory server_name(String server_name) {
        this.server_name = server_name;
        return this;
    }

    public WaitHistory wait_cnt(String wait_cnt) {
        this.wait_cnt = wait_cnt;
        return this;
    }

    public WaitHistory create_date(String create_date) {
        this.create_date = create_date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WaitHistory)) {
            return false;
        }
        WaitHistory waitHistory = (WaitHistory) o;
        return seq == waitHistory.seq && Objects.equals(server_name, waitHistory.server_name) && Objects.equals(wait_cnt, waitHistory.wait_cnt) && Objects.equals(create_date, waitHistory.create_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq, server_name, wait_cnt, create_date);
    }

    @Override
    public String toString() {
        return "{" +
            " seq='" + getSeq() + "'" +
            ", server_name='" + getServer_name() + "'" +
            ", wait_cnt='" + getWait_cnt() + "'" +
            ", create_date='" + getCreate_date() + "'" +
            "}";
    }
    
}
