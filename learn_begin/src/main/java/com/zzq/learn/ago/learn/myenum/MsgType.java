package com.zzq.learn.ago.learn.myenum;

public enum MsgType {
    error(-1),
    realTimeAlarm(0),
    reqLoginAlarm(1),
    ackLoginAlarm(2),
    reqSyncAlarmMsg(3),
    ackSyncAlarmMsg(4),
    reqSyncAlarmFile(5),
    ackSyncAlarmFile(6),
    ackSyncAlarmFileResult(7),
    reqHeartBeat(8),
    ackHeartBeat(9),
    closeConnAlarm(10);

    public final int idx;

    MsgType(int idx) {
        this.idx = idx;
    }

}
