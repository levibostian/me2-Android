package co.me2app.me2.vo;

import java.util.ArrayList;

public class LoveChoices {

    public static String youDontHaveToGoAlone = "You don't have to go alone.";
    public static String dontGiveUp = "Don't give up.";
    public static String thereIsHope = "There is hope.";
    public static String imHereForYou = "I'm here for you.";
    public static String iHearYourCry = "I hear your cry.";
    public static String ifIWasThereIWouldHugYou = "If I was there I would hug you. ";
    public static String iKnowWhereYoureComingFrom = "I know where you're coming from.";
    public static String iLoveYou = "I love you.";
    public static String stayStrong = "Stay strong.";

    public static ArrayList<String> loveChoices = new ArrayList<String>();

    public static ArrayList<String> getLoveChoices() {
        loveChoices = new ArrayList<String>();

        loveChoices.add(youDontHaveToGoAlone);
        loveChoices.add(dontGiveUp);
        loveChoices.add(thereIsHope);
        loveChoices.add(imHereForYou);
        loveChoices.add(iHearYourCry);
        loveChoices.add(ifIWasThereIWouldHugYou);
        loveChoices.add(iKnowWhereYoureComingFrom);
        loveChoices.add(iLoveYou);
        loveChoices.add(stayStrong);

        return loveChoices;
    }
}
