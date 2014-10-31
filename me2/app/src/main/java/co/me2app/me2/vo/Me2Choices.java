package co.me2app.me2.vo;

import java.util.ArrayList;

public class Me2Choices {
    public static final String youAreNotAlone = "You are not alone.";
    public static final String iCanRelate = "I can relate.";
    public static final String iveBeenThere = "I've been there.";
    public static final String imThereWithYou = "I'm there with you.";
    public static final String wereInThisTogether = "We're in this together.";
    public static final String thatHappenedToMe2 = "That happened to me2.";
    public static final String weCanDoThisTogether = "We can do this together";
    public static final String iFeelYou = "I feel you.";

    public static ArrayList<String> me2Choices = new ArrayList<String>();

    public static ArrayList<String> getMe2Choices() {
        me2Choices = new ArrayList<String>();

        me2Choices.add(youAreNotAlone);
        me2Choices.add(iCanRelate);
        me2Choices.add(iveBeenThere);
        me2Choices.add(imThereWithYou);
        me2Choices.add(wereInThisTogether);
        me2Choices.add(thatHappenedToMe2);
        me2Choices.add(weCanDoThisTogether);
        me2Choices.add(iFeelYou);

        return me2Choices;
    }
}
