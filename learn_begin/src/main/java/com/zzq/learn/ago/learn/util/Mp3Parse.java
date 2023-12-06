package com.zzq.learn.ago.learn.util;

import com.zzq.learn.ago.learn.bean.Tag;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Mp3Parse {
    String ID3;
    byte ver;
    byte reVision;
    byte flag;
    int size;
    List<Tag> tags;

    String title;
    String author;
    String album;
    int bitRate;
    int sampleRate;
    String MPEG;
    String layer;
    boolean crc;
    String track;
    boolean copyright;
    boolean original;

    int[] v1l1 = {999, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448, -1};
    int[] v1l2 = {999, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, -1};
    int[] v1l3 = {999, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, -1};
    int[] v2l1 = {999, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448, -1};
    int[] v2l2 = {999, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448, -1};
    int[] v2l3 = {999, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448, -1};

    int[] samples1 = {44100, 48000, 32000, -1};
    int[] samples2 = {22050, 24000, 16000, -1};
    int[] samples2_5 = {11025, 12000, 8000, -1};

    public void parse(String filePath) throws Exception {
        File file = new File(filePath);
        int length = (int) file.length();
        FileInputStream fis = new FileInputStream(file);
        FileChannel fileChannel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(length);
        fileChannel.read(byteBuffer);
        fis.close();
        fileChannel.close();
        byteBuffer.flip();

        // Tag Header
        byte[] b3 = new byte[3];
        byteBuffer.get(b3);
        ID3 = new String(b3);
        ver = byteBuffer.get();
        reVision = byteBuffer.get();
        flag = byteBuffer.get();
        size = size(byteBuffer);
        tags = new ArrayList<>();
        Tag tag;
        while ((tag = tagParse(this, byteBuffer)) != null) {
            tags.add(tag);
        }

        byteBuffer.position(size + 10);
        // Frame Header
        int anInt = byteBuffer.getInt();
        System.out.println(Integer.toBinaryString(anInt));

        // MPEG
        int bit_MPEG = anInt >>> 19 & 0b11;
        if (bit_MPEG == 0b00) {
            MPEG = "MPEG2.5";
        } else if (bit_MPEG == 0b10) {
            MPEG = "MPEG2";
        } else if (bit_MPEG == 0b11) {
            MPEG = "MPEG1";
        } else {
            MPEG = "未定义";
        }

        // Layer
        int bit_layer = anInt >>> 17 & 0b11;
        if (bit_layer == 0b01) {
            layer = "layer3";
        } else if (bit_layer == 0b10) {
            layer = "layer2";
        } else if (bit_layer == 0b11) {
            layer = "layer1";
        } else {
            layer = "未定义";
        }

        // crc 效验
        crc = (anInt >>> 16 & 0b1) == 0;

        // 比特率
        int bit_kbps = anInt >>> 12 & 0b1111;
        if (bit_MPEG == 0b00 || bit_MPEG == 0b10) {
            if (bit_layer == 0b01) {
                bitRate = v2l3[bit_kbps];
            } else if (bit_layer == 0b10) {
                bitRate = v2l2[bit_kbps];
            } else if (bit_layer == 0b11) {
                bitRate = v2l1[bit_kbps];
            }
        } else if (bit_MPEG == 0b11) {
            if (bit_layer == 0b01) {
                bitRate = v1l3[bit_kbps];
            } else if (bit_layer == 0b10) {
                bitRate = v1l2[bit_kbps];
            } else if (bit_layer == 0b11) {
                bitRate = v1l1[bit_kbps];
            }
        }

        // 采样率
        int bit_sample = anInt >>> 10 & 0b11;
        if (bit_MPEG == 0b11) { // MPEG 1
            sampleRate = samples1[bit_sample];
        } else if (bit_MPEG == 0b10) { // MPEG 2
            sampleRate = samples2[bit_sample];
        } else if (bit_MPEG == 0b00) { // MPEG 2.5
            sampleRate = samples2_5[bit_sample];
        }

//        int bit_c2 = anInt >>> 9 & 0b1;
//        int bit_c3 = anInt >>> 8 & 0b1;

        // 声道
        int bit_track = anInt >>> 7 & 0b11;
        if (bit_track == 0b00) {
            track = "立体声Stereo";
        } else if (bit_track == 0b01) {
            track = "Joint Stereo";
        } else if (bit_track == 0b10) {
            track = "双声道";
        } else {
            track = "单声道";
        }

//        int bit_c5 = anInt >>> 5 & 0b11;

        // 版权
        copyright = (anInt >>> 3 & 0b1) == 1;
        // 原版
        original = (anInt >>> 2 & 0b1) == 1;
//        int bit_c8 = anInt & 0b11;

        byte[] fake = new byte[32];
        byteBuffer.get(fake);

        // CBR or VBR (Xing Info)
        byte[] con2 = new byte[4];
        byteBuffer.get(con2);
        System.out.println(new String(con2));
        System.out.println(Integer.toHexString(byteBuffer.getInt()));
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getInt());
        byteBuffer.position(byteBuffer.position() + 100);
        System.out.println(byteBuffer.getInt());

//        byteBuffer.position(length-128);

//        byte[] ID1 = new byte[128];
//        byteBuffer.get(ID1);
//        System.out.println(new String(ID1,0,3));
//
//        System.out.println(byteBuffer);
//        System.out.println(this);
    }

    public static Tag tagParse(Mp3Parse mp3, ByteBuffer byteBuffer) {
        Tag tag = new Tag();
        byte[] byte4 = new byte[4];
        byteBuffer.get(byte4);
        tag.setType(new String(byte4));
        int size = size4(byteBuffer);
        tag.setSize(size);
        tag.setFlag(flag2(byteBuffer));
        tag.setEncode(byteBuffer.get());
        if (tag.getType().startsWith("T")) {
            return textTag(mp3, tag, byteBuffer);
        } else if (tag.getType().equals("APIC")) {
            return picTag(tag, byteBuffer);
        } else if (tag.getType().equals("COMM")) {
            return commTag(tag, byteBuffer);
        }
        return null;
    }

    public static Tag textTag(Mp3Parse mp3, Tag tag, ByteBuffer byteBuffer) {
        byte[] con = new byte[tag.getSize() - 1];
        byteBuffer.get(con);
        tag.setText(new String(con, StandardCharsets.UTF_16));
        if (tag.getType().equals("TIT2")) {
            mp3.title = tag.getText();
        } else if (tag.getType().equals("TPE1")) {
            mp3.author = tag.getText();
        } else if (tag.getType().equals("TALB")) {
            mp3.album = tag.getText();
        }
//        System.out.println(tag);
        return tag;
    }

    public static Tag picTag(Tag tag, ByteBuffer byteBuffer) {
        byte[] bytes = new byte[20];
        int i = 0;
        byte b;
        while ((b = byteBuffer.get()) != 0) {
            bytes[i] = b;
            i++;
        }
        tag.setMIMEType(new String(Arrays.copyOf(bytes, i)));
        tag.setPicType(byteBuffer.get()); // picType

        int j = 0;
        while ((b = byteBuffer.get()) != 0) {
            bytes[j] = b;
            j++;
        }

        tag.setDesc(new String(Arrays.copyOf(bytes, j)));

        byte[] pic = new byte[tag.getSize() - 4 - i - j];
        byteBuffer.get(pic);

        try {
            FileOutputStream fos = new FileOutputStream("D:\\03.png");
            fos.write(pic);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(tag);
        return tag;
    }

    public static Tag commTag(Tag tag, ByteBuffer byteBuffer) {
        byte[] con = new byte[tag.getSize() - 1];
        byteBuffer.get(con);
        tag.setText(new String(con, StandardCharsets.UTF_16));
//        System.out.println(tag);
        return tag;
    }

    public static String flag2(ByteBuffer byteBuffer) {
        byte b1 = byteBuffer.get();
        byte b2 = byteBuffer.get();
        return Integer.toBinaryString(((b1 & 0xFF) << 8) + (b2 & 0xFF));
    }

    public static int size(ByteBuffer byteBuffer) {
        byte s1 = byteBuffer.get();
        byte s2 = byteBuffer.get();
        byte s3 = byteBuffer.get();
        byte s4 = byteBuffer.get();
        return s1 << 21 | s2 << 14 | s3 << 7 | s4;
    }

    public static int size4(ByteBuffer byteBuffer) {
        byte s1 = byteBuffer.get();
        byte s2 = byteBuffer.get();
        byte s3 = byteBuffer.get();
        byte s4 = byteBuffer.get();
        return (s1 & 0xFF) << 24 | (s2 & 0xFF) << 16 | (s3 & 0xFF) << 8 | (s4 & 0xFF);
    }

    @Override
    public String toString() {
        return "Mp3Parse: {" + '\n' +
                "\tID3: " + ID3 + '\n' +
                "\tver: " + ver + '\n' +
                "\t歌名: " + title + '\n' +
                "\t歌手: " + author + '\n' +
                "\t专辑: " + album + '\n' +
                "\t比特率: " + bitRate + "kbps\n" +
                "\t采样率: " + (double) sampleRate / 1000 + "khz\n" +
                "\tMPEG: " + MPEG + '\n' +
                "\tLayer: " + layer + '\n' +
                "\t声道: " + track + '\n' +
                "\t版权: " + copyright + '\n' +
                "\t原版: " + original + '\n' +
                '}';
    }
}
