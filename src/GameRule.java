import java.util.*;

public class GameRule{

	// Phân loại bài: rác, đôi, bộ ba, tứ quý, dây
    public static String classify(List<Card> cards) {
    	if (cards.size() == 1) return "Normal";
        if (isPair(cards)) return "Pair";
        if (isTriple(cards)) return "Triple";
        if (isFourOfAKind(cards)) return "FourOfAKind";
        if (isStraight(cards)) return "Straight";
        return "Not Available";
    }

    private static boolean isPair(List<Card> cards) {
        return cards.size() == 2 &&
               cards.get(0).getRankValue() == cards.get(1).getRankValue();
    }

    private static boolean isTriple(List<Card> cards) {
        return cards.size() == 3 &&
               cards.get(0).getRankValue() == cards.get(1).getRankValue() &&
               cards.get(1).getRankValue() == cards.get(2).getRankValue();
    }

    private static boolean isFourOfAKind(List<Card> cards) {
        return cards.size() == 4 &&
               cards.get(0).getRankValue() == cards.get(1).getRankValue() &&
               cards.get(1).getRankValue() == cards.get(2).getRankValue() &&
               cards.get(2).getRankValue() == cards.get(3).getRankValue();
    }

    private static boolean isStraight(List<Card> cards) {
        if (cards.size() < 3) return false;
        cards.sort(Comparator.naturalOrder());
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRankValue() + 1 != cards.get(i + 1).getRankValue()) {
                return false;
            }
        }
        return true;
    }
    
    // So sánh hai bộ bài
    public static boolean isStronger(List<Card> hand1, List<Card> hand2) {
       String type1 = classify(hand1);
       String type2 = classify(hand2);
       	if (hand2.isEmpty() && !type1.equals("Not Available")) return true;
       	if (type1.equals("Straight") && type2.equals("Straight") && hand1.size() != hand2.size()) return false;
        if (!type1.equals(type2) || type1.equals("Not Available") || type2.equals("Not Available")) return false; // Khác loại không thể so sánh
        return hand1.get(hand1.size() - 1).compareTo(hand2.get(hand2.size() - 1)) > 0;
    }
}

