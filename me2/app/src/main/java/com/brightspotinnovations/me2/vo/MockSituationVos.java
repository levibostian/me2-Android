package com.brightspotinnovations.me2.vo;

import com.brightspotinnovations.me2.R;
import com.brightspotinnovations.me2.enums.Mood;

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
        situation1.situation = "Proin mi erat, fringilla eget bibendum quis, euismod quis augue. Vestibulum eros nulla, elementum mollis mi sit amet, auctor pulvinar dui. Mauris lacinia vulputate nunc in interdum. Sed laoreet sapien urna, ac volutpat elit pulvinar eget. Suspendisse potenti. Integer porta placerat metus in tincidunt. Duis vestibulum risus ut consectetur lacinia. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tempor accumsan diam nec porttitor. Nullam hendrerit euismod sodales. Nunc velit sem, porttitor nec dapibus in, imperdiet ut velit. Vestibulum consectetur iaculis nibh, ut gravida orci aliquam at. Pellentesque erat urna, egestas nec volutpat sed, maximus sed neque. Praesent molestie enim a felis porttitor consectetur.";
        situation1.userGender = R.drawable.user_male;
        situation1.location = "Brazil";

        return situation1;
    }

    public static SituationVo getSituation2() {
        situation2.mood = Mood.ANGRY;
        situation2.username = "jolly penguin";
        situation2.date = "8 hours ago";
        situation2.situation = "Nullam eleifend ex id arcu dictum, non facilisis erat tempor. Phasellus eget tortor nec tortor pretium tincidunt vitae ac enim. Phasellus vulputate nulla eu nulla placerat sollicitudin. Mauris augue purus, finibus eget cursus eu, accumsan a lectus. Vivamus non magna neque. Suspendisse in fermentum ipsum. Vivamus sed odio vel sapien tincidunt malesuada. Aliquam erat volutpat. Integer sodales orci diam, et tincidunt justo lacinia id. Quisque dictum, lacus quis posuere mollis, felis nulla mollis dui, sit amet condimentum est eros aliquet justo.";
        situation2.userGender = R.drawable.user_rainbow;
        situation2.location = "New York, USA";

        return situation2;
    }

    public static SituationVo getSituation3() {
        situation3.mood = Mood.AVERAGE;
        situation3.username = "happy zebra";
        situation3.date = "1 day ago";
        situation3.situation = "Nulla placerat lorem fermentum elit interdum lacinia. Vestibulum pharetra arcu sit amet orci interdum tincidunt et a elit. In sodales tincidunt molestie. Vestibulum viverra quis tortor nec tempor. Donec placerat elementum augue a interdum. Maecenas vel maximus justo. Nulla cursus bibendum dui et ornare. Quisque nibh diam, euismod quis sem ultricies, placerat feugiat quam. Sed ultricies varius mollis. In mollis mi non varius vehicula. Quisque sed hendrerit risus. Phasellus convallis, sem a rhoncus aliquam, metus urna laoreet lacus, eu mollis turpis felis eu mi. Sed eget sapien tortor.";
        situation3.userGender = R.drawable.user_neutral;
        situation3.location = "China";

        return situation3;
    }

    public static SituationVo getSituation4() {
        situation4.mood = Mood.HURT;
        situation4.username = "big pizza";
        situation4.date = "2 days ago";
        situation4.situation = "Proin maximus eleifend iaculis. Pellentesque gravida bibendum lorem, a bibendum nulla volutpat id. Cras eget nibh non lectus rhoncus dignissim molestie a diam. Curabitur suscipit velit posuere elit porttitor, ac posuere odio rutrum. Integer sit amet sem nec felis bibendum cursus mollis vitae metus. Phasellus pellentesque mauris mi, id finibus nisi commodo in. Nunc vestibulum turpis at scelerisque commodo. Nunc massa augue, facilisis nec condimentum eu, eleifend nec erat.";
        situation4.userGender = R.drawable.user_female;
        situation4.location = "Italy";

        return situation4;
    }

    public static SituationVo getSituation5() {
        situation5.mood = Mood.SCARED;
        situation5.username = "strong pillow";
        situation5.date = "2 days ago";
        situation5.situation = "Nulla arcu tortor, ornare et est ac, porttitor convallis justo. Nam ut arcu quis eros consequat tincidunt. Donec convallis nulla eget congue dignissim. In hendrerit magna at velit hendrerit, in porttitor nunc tempor. Aliquam vel elit vitae elit ultricies lacinia. Aliquam erat volutpat. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Integer eleifend metus urna. Aenean viverra libero ex, sed cursus metus gravida maximus. Praesent euismod mi et malesuada facilisis. In hac habitasse platea dictumst. Integer neque justo, posuere sit amet pretium ut, commodo non metus. Mauris at venenatis est. Mauris hendrerit mi efficitur mollis hendrerit. Aenean semper non nunc nec venenatis.";
        situation5.userGender = R.drawable.user_male;
        situation5.location = "Arkansas, USA";

        return situation5;
    }
}
