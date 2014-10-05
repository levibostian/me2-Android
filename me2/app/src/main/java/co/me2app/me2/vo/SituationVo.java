package co.me2app.me2.vo;

import android.os.Parcel;
import android.os.Parcelable;
import co.me2app.me2.R;

public class SituationVo implements Parcelable {

    public int statusColor = R.color.yellow;
    public String username = "super cheese";
    public String date = "5 hours ago";
    public String situation = "Remain lively hardly needed at do by. Two you fat downs fanny three. True mr gone most at. Dare as name just when with it body. Remain lively hardly needed at do by. Two you fat downs fanny three. True mr gone most at. Dare as name just when with it body. Remain lively hardly needed at do by. Two you fat downs fanny three. True mr gone most at. Dare as name just when with it body. Travelling inquietude she increasing off impossible the. Cottage be noisier looking to we promise on. Disposal to kindness appetite diverted learning of on raptures. Betrayed any may returned now dashwood formerly. Balls way delay shy boy man views. No so instrument discretion unsatiable to in. Repulsive questions contented him few extensive supported. Of remarkably thoroughly he appearance in. Supposing tolerably applauded or of be. Suffering unfeeling so objection agreeable allowance me of. Ask within entire season sex common far who family. As be valley warmth assure on. Park girl they rich hour new well way you. Face ye be me been room we sons fond. ";
    public int userGender = R.drawable.user_male;
    public String location = "Iowa, USA";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.statusColor);
        dest.writeString(this.username);
        dest.writeString(this.date);
        dest.writeString(this.situation);
        dest.writeInt(this.userGender);
        dest.writeString(this.location);
    }

    public SituationVo() {
    }

    private SituationVo(Parcel in) {
        this.statusColor = in.readInt();
        this.username = in.readString();
        this.date = in.readString();
        this.situation = in.readString();
        this.userGender = in.readInt();
        this.location = in.readString();
    }

    public static final Creator<SituationVo> CREATOR = new Creator<SituationVo>() {
        public SituationVo createFromParcel(Parcel source) {
            return new SituationVo(source);
        }

        public SituationVo[] newArray(int size) {
            return new SituationVo[size];
        }
    };
}
