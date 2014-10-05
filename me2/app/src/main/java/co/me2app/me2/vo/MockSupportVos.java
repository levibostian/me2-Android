package co.me2app.me2.vo;

import co.me2app.me2.R;

public class MockSupportVos {

    public static SupportVo support1 = new SupportVo();
    public static SupportVo support2 = new SupportVo();
    public static SupportVo support3 = new SupportVo();
    public static SupportVo support4 = new SupportVo();
    public static SupportVo support5 = new SupportVo();

    public static SupportVo getSupport1() {
        support1.statusColor = R.color.blue;
        support1.username = "amazing rock";
        support1.date = "1 minute ago";
        support1.support = "You don't have to go alone";
        support1.userGender = R.drawable.user_rainbow;
        support1.location = "Chile";

        return support1;
    }

    public static SupportVo getSupport2() {
        support2.statusColor = R.color.pink;
        support2.username = "fast rainbow";
        support2.date = "2 hours ago";
        support2.support = "Don't give up!";
        support2.userGender = R.drawable.user_male;
        support2.location = "Montana, USA";

        return support2;
    }

    public static SupportVo getSupport3() {
        support3.statusColor = R.color.orange;
        support3.username = "speedy basketball";
        support3.date = "1 day ago";
        support3.support = "There is hope.";
        support3.userGender = R.drawable.user_female;
        support3.location = "Canada";

        return support3;
    }

    public static SupportVo getSupport4() {
        support4.statusColor = R.color.green;
        support4.username = "small knight";
        support4.date = "3 days ago";
        support4.support = "I can relate.";
        support4.userGender = R.drawable.user_rainbow;
        support4.location = "Mexico";

        return support4;
    }

    public static SupportVo getSupport5() {
        support5.statusColor = R.color.yellow;
        support5.username = "giant bear";
        support5.date = "3 days ago";
        support5.support = "That happened to me2.";
        support5.userGender = R.drawable.user_neutral;
        support5.location = "Alaska, USA";

        return support5;
    }
}
