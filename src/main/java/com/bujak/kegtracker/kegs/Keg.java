package com.bujak.kegtracker.kegs;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Keg {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;

    public Keg() {
    }

    public Keg(List<Card> cards) {
        assignCards(cards);
      }

    public Integer getKegId() {
        return id.intValue();
    }

    public List<Card> getCards() {
        return Arrays.asList(card1, card2, card3, card4, card5);
    }

    public void setCards(List<Card> cards) {
        assignCards(cards);
    }

    private void assignCards(List<Card> cards) {
        this.card1 = cards.get(0);
        this.card2 = cards.get(1);
        this.card3 = cards.get(2);
        this.card4 = cards.get(3);
        this.card5 = cards.get(4);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keg keg = (Keg) o;

        if (id != null ? !id.equals(keg.id) : keg.id != null) return false;
        if (card1 != keg.card1) return false;
        if (card2 != keg.card2) return false;
        if (card3 != keg.card3) return false;
        if (card4 != keg.card4) return false;
        return card5 == keg.card5;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (card1 != null ? card1.hashCode() : 0);
        result = 31 * result + (card2 != null ? card2.hashCode() : 0);
        result = 31 * result + (card3 != null ? card3.hashCode() : 0);
        result = 31 * result + (card4 != null ? card4.hashCode() : 0);
        result = 31 * result + (card5 != null ? card5.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Keg{" +
                "id=" + id +
                ", card1=" + card1 +
                ", card2=" + card2 +
                ", card3=" + card3 +
                ", card4=" + card4 +
                ", card5=" + card5 +
                '}';
    }
}
