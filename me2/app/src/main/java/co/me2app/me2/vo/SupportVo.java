package co.me2app.me2.vo;

import android.os.Parcel;
import android.os.Parcelable;
import co.me2app.me2.R;

public class SupportVo implements Parcelable {

    public int statusColor = R.color.red;
    public String username = "super cheese";
    public String date = "5 hours ago";
    public String support = "I feel ya.";
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
        dest.writeString(this.support);
        dest.writeInt(this.userGender);
        dest.writeString(this.location);
    }

    public SupportVo() {
    }

    private SupportVo(Parcel in) {
        this.statusColor = in.readInt();
        this.username = in.readString();
        this.date = in.readString();
        this.support = in.readString();
        this.userGender = in.readInt();
        this.location = in.readString();
    }

    public static final Creator<SupportVo> CREATOR = new Creator<SupportVo>() {
        public SupportVo createFromParcel(Parcel source) {
            return new SupportVo(source);
        }

        public SupportVo[] newArray(int size) {
            return new SupportVo[size];
        }
    };
}
