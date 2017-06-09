package moizest89.geronimostudios.test.data.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by moizest89 on 6/9/17.
 */

public class Article implements Parcelable {

    private String name;
    private String description;
    private String category;
    private String banner;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.category);
        dest.writeString(this.banner);
    }

    public Article() {
    }

    public Article(String name, String description, String category, String banner) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.banner = banner;
    }

    protected Article(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.category = in.readString();
        this.banner = in.readString();
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
