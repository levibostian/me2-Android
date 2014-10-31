package co.me2app.me2.vo;

import android.os.Parcel;
import android.os.Parcelable;
import co.me2app.me2.enums.Mood;

public class SituationVo implements Parcelable {

    public Mood mood;
    public String username;
    public String date;
    public String situation;
    public int userGender;
    public String location;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.mood);
        dest.writeString(this.username);
        dest.writeString(this.date);
        dest.writeString(this.situation);
        dest.writeInt(this.userGender);
        dest.writeString(this.location);
    }

    public SituationVo() {
    }

    private SituationVo(Parcel in) {
        this.mood = (Mood) in.readSerializable();
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
