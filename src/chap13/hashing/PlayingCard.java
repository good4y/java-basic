package chap13.hashing;

public class PlayingCard {

    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
        this.internalHash = (suit.equals("Hearts"))? 11 : 12;
    }

    @Override
    public String toString(){
        return face + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;

        if (!suit.equals(that.suit)) return false;
        return face.equals(that.face);
    }

    // 해시코드는 다음과 같은 규칙이 적용되어야 한다.
    // 1. 계산 비용이 적어야 한다.
    // 2. 호출 시 마다 같은 값을 반환해야 한다.
    // 3. equals 메서드가 true를 반환하는 각 객체는 같은 해시코드를 반환해야 한다.
    // 4. 계산에 사용되는 각 필드 값은 변경되어서는 안된다.
    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + face.hashCode();
        return result;
    }
}
