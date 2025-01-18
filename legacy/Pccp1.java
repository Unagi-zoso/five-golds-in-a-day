class Solution {
    public int getTimeTo10Base(String timeStr) {
        String[] splitedTimeStr = timeStr.split(":");
        return Integer.parseInt(splitedTimeStr[0]) * 60 + Integer.parseInt(splitedTimeStr[1]);
    }
    
    public String parse10BaseToTime(int sec) {
        String mm = String.format("%02d", (int) sec / 60);
        String ss = String.format("%02d", sec % 60);
        return mm + ":" + ss;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = getTimeTo10Base(video_len);
        int posSec = getTimeTo10Base(pos);
        int opStartSec = getTimeTo10Base(op_start);
        int opEndSec = getTimeTo10Base(op_end);
        
        
        if (posSec >= opStartSec && posSec <= opEndSec) {
            posSec = opEndSec;
        }
        
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                posSec -= 10;
                if (posSec < 0) {
                    posSec = 0;
                }
            } else if (cmd.equals("next")) {
                posSec += 10;
                if (posSec > videoLenSec) {
                    posSec = videoLenSec;
                }
            }
            
            if (posSec >= opStartSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }
        return parse10BaseToTime(posSec);
    }
}
