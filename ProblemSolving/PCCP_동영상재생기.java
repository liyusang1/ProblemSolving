public class PCCP_동영상재생기 {
    public static void main(String[] args) {

        PCCP_동영상재생기 sol = new PCCP_동영상재생기();
        sol.solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"});
        sol.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"});
        sol.solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"});
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len;
        int pos2;
        int opstart;
        int opend;

        len = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        pos2 = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        opstart = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        opend = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);

        if (pos2 >= opstart && pos2 <= opend) {
            pos2 = opend;
        }

        for (String curCommand : commands) {
            if (curCommand.equals("prev")) {
                if (pos2 < 10) {
                    pos2 = 0;
                } else {
                    pos2 -= 10;
                }
            } else if (curCommand.equals("next")) {
                if (pos2 + 10 >= len) {
                    pos2 = len;
                } else {
                    pos2 += 10;
                }
            }
            if (pos2 >= opstart && pos2 <= opend) {
                pos2 = opend;
            }
        }

        String ans = "";
        String min = Integer.toString(pos2 / 60);
        String sec = Integer.toString(pos2 % 60);

        if (min.length() == 1) {
            min = "0" + min;
        }
        if (sec.length() == 1) {
            sec = "0" + sec;
        }

        ans = min + ":" + sec;
        return ans;
    }
}
