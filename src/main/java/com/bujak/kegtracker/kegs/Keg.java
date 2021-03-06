package com.bujak.kegtracker.kegs;

import com.bujak.kegtracker.players.Player;

import javax.persistence.*;
import java.util.List;

@Entity
public class Keg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType. STRING)
    private List<Card> cards;

    @ManyToOne
    private Player owner;

    public Keg() {
    }

    public Keg(List<Card> cards) {
        this.cards = cards;
    }

    public Keg(Player owner, List<Card> cards) {
        this.cards = cards;
        this.owner = owner;
    }

    public Integer getKegId() {
        return id.intValue();
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keg keg = (Keg) o;

        if (id != null ? !id.equals(keg.id) : keg.id != null) return false;
        return cards != null ? cards.equals(keg.cards) : keg.cards == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Keg{" +
                "id=" + id +
                ", cards=" + cards +
                ", owner=" + owner +
                '}';
    }
}
