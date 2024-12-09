import java.util.List;

public abstract class Capture{
    protected List<Card> choosenCards;
    
    public Capture(List<Card> choosenCards) {
    	this.choosenCards = choosenCards;
    };

    public String getCaptureName() {
    	return GameRule.classify(this.choosenCards);
    };
    
    public List<Card> getChoosenCard(){
    	return this.choosenCards;
    };
}