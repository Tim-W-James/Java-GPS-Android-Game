package com.nbt.comp2100_bunker_survival.model.items;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

// an Item that is used in combat
public class Weapon extends Item {
    // rawPower indicates the base strength this item has in combat
    private int rawPower;

    public Weapon(String name, String description, int tradingValue, int rawPower) {
        super(name, description, tradingValue);
        this.rawPower = rawPower;
    }

    public int getRawPower() {
        return rawPower;
    }

    @Override
    public List<String> getDetails() {
        ArrayList<String> details = new ArrayList<String>();
        details.add("Description: "+getDescription());
        details.add("Trading Value: "+getTradingValue());
        details.add("Raw Power: "+getRawPower());
        return details;
    }

    // equal if properties are equal
    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Weapon) {
            return (getName().equals(((Weapon) obj).getName()) &&
                    getDescription().equals(((Weapon) obj).getDescription()) &&
                    getTradingValue() == ((Weapon) obj).getTradingValue() &&
                    rawPower == ((Weapon) obj).rawPower);
        }
        else
            return false;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString()+
                "\nRaw Power: "+rawPower;
    }

    // parcel methods

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeString(getDescription());
        parcel.writeInt(getTradingValue());
        parcel.writeInt(getRawPower());
    }

    public static final Parcelable.Creator<Weapon> CREATOR
            = new Parcelable.Creator<Weapon>() {
        public Weapon createFromParcel(Parcel in) {
            return new Weapon(in);
        }

        public Weapon[] newArray(int size) {
            return new Weapon[size];
        }
    };

    private Weapon(Parcel in) {
        this (in.readString(), in.readString(), in.readInt(), in.readInt());
    }
}
