package co.me2app.me2.vo;

import co.me2app.me2.R;
import co.me2app.me2.enums.Mood;

public class MockSituationVos {

    public static SituationVo situation1 = new SituationVo();
    public static SituationVo situation2 = new SituationVo();
    public static SituationVo situation3 = new SituationVo();
    public static SituationVo situation4 = new SituationVo();
    public static SituationVo situation5 = new SituationVo();

    public static SituationVo getSituation1() {
        situation1.mood = Mood.GOOD;
        situation1.username = "super cheese";
        situation1.date = "5 hours ago";
        situation1.situation = "Attachment apartments in delightful by motionless it no. And now she burst sir learn total. Hearing hearted shewing own ask. Solicitude uncommonly use her motionless not collecting age. The properly servants required mistaken outlived bed and. Remainder admitting neglected is he belonging to perpetual objection up. Has widen too you decay begin which asked equal any.";
        situation1.userGender = R.drawable.user_male;
        situation1.location = "Brazil";

        return situation1;
    }

    public static SituationVo getSituation2() {
        situation2.mood = Mood.ANGRY;
        situation2.username = "jolly penguin";
        situation2.date = "8 hours ago";
        situation2.situation = "Moments its musical age explain. But extremity sex now education concluded earnestly her continual. Oh furniture acuteness suspected continual ye something frankness. Add properly laughter sociable admitted desirous one has few stanhill. Opinion regular in perhaps another enjoyed no engaged he at. It conveying he continual ye suspected as necessary. Separate met packages shy for kindness. ";
        situation2.userGender = R.drawable.user_rainbow;
        situation2.location = "New York, USA";

        return situation2;
    }

    public static SituationVo getSituation3() {
        situation3.mood = Mood.AVERAGE;
        situation3.username = "happy zebra";
        situation3.date = "1 day ago";
        situation3.situation = "Extended kindness trifling remember he confined outlived if. Assistance sentiments yet unpleasing say. Open they an busy they my such high. An active dinner wishes at unable hardly no talked on. Immediate him her resolving his favourite. Wished denote abroad at branch at. ";
        situation3.userGender = R.drawable.user_neutral;
        situation3.location = "China";

        return situation3;
    }

    public static SituationVo getSituation4() {
        situation4.mood = Mood.HURT;
        situation4.username = "big pizza";
        situation4.date = "2 days ago";
        situation4.situation = "Remain valley who mrs uneasy remove wooded him you. Her questions favourite him concealed. We to wife face took he. The taste begin early old why since dried can first. Prepared as or humoured formerly. Evil mrs true get post. Express village evening prudent my as ye hundred forming. Thoughts she why not directly reserved packages you. Winter an silent favour of am tended mutual. ";
        situation4.userGender = R.drawable.user_female;
        situation4.location = "Italy";

        return situation4;
    }

    public static SituationVo getSituation5() {
        situation5.mood = Mood.SCARED;
        situation5.username = "strong pillow";
        situation5.date = "2 days ago";
        situation5.situation = "Can curiosity may end shameless explained. True high on said mr on come. An do mr design at little myself wholly entire though. Attended of on stronger or mr pleasure. Rich four like real yet west get. Felicity in dwelling to drawings. His pleasure new steepest for reserved formerly disposed jennings. ";
        situation5.userGender = R.drawable.user_male;
        situation5.location = "Arkansas, USA";

        return situation5;
    }
}
