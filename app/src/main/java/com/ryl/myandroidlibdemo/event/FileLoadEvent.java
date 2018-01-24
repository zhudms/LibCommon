package com.ryl.myandroidlibdemo.event;

public class FileLoadEvent {
    Object tag;

    public Object getTag() {
        return tag;
    }

    public long getTotal() {
        return total;
    }

    public long getBytesLoaded() {
        return bytesLoaded;
    }

    public FileLoadEvent(Object tag, long total, long bytesLoaded) {

        this.tag = tag;
        this.total = total;
        this.bytesLoaded = bytesLoaded;
    }

    long total;
    long bytesLoaded;


}
