package com.brightspotinnovations.me2.vo;

import java.util.ArrayList;

public class MockHotlineVos {

    public static HotlineVo hotline1 = new HotlineVo();
    public static HotlineVo hotline2 = new HotlineVo();
    public static HotlineVo hotline3 = new HotlineVo();

    public static ArrayList<HotlineVo> hotlines = new ArrayList<HotlineVo>();

    public static ArrayList<HotlineVo> getHotlines() {
        hotline1.name = "Thursday’s Child National Youth Advocacy Hotline";
        hotline1.phone = 8008725437L;
        hotline1.description = "Twenty-four hours a day, seven days a week";
        hotline1.website = "http://www.thursdayschild.org";

        hotline2.name = "Your Life Iowa: Bullying Support and Suicide Prevention";
        hotline2.phone = 8555818111L;
        hotline2.description = "(855) 581-8111 (24/7) or text TALK to 85511 (4–8 PM every day)\n" + "Chat is available Mondays–Thursdays from 7:30 PM–12:00 AM";
        hotline2.website = "";

        hotline3.name = "Tragedy Assistance Program for Survivors (TAPS)";
        hotline3.phone = 8009598277L;
        hotline3.description = "Twenty-four hours a day, seven days a week";
        hotline3.website = "http://www.taps.org";

        hotlines = new ArrayList<HotlineVo>();
        hotlines.add(hotline1);
        hotlines.add(hotline2);
        hotlines.add(hotline3);

        return hotlines;
    }
}
