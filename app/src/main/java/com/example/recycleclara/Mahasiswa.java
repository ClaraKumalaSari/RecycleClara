package com.example.recycleclara;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    private String nama;
    private String nim;
    private String nohp;

    public Mahasiswa (String nama,String nim, String nohp) {
        this.nama = nama;
        this.nim  = nim;
        this.nohp= nohp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nim);
        dest.writeString(this.nohp);
    }

    protected Mahasiswa(Parcel in) {
        this.nama = in.readString();
        this.nim = in.readString();
        this.nohp = in.readString();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {

            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
