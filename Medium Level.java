import java.util.*;
class CardCollection {
 private static Map<String, List<String>> cardMap = new HashMap<>();

 public static void main(String[] args) {
 addCard("SPADE", "Ace of Spades");
 addCard("SPADE", "King of Spades");
 addCard("HEART", "Queen of Hearts");
 addCard("DIAMOND", "Jack of Diamonds");
 addCard("CLUB", "10 of Clubs");
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter card type (SPADE, HEART, DIAMOND, CLUB): ");
 String type = scanner.next().toUpperCase(); // Convert input to uppercase
 List<String> cards = cardMap.get(type);
 if (cards != null) {
 System.out.println("Cards found: " + cards);
 } else {
 System.out.println("No cards found for this type.");
 }
 scanner.close();
 }
 private static void addCard(String type, String card) {
 cardMap.computeIfAbsent(type, k -> new ArrayList<>()).add(card);
 }
}
