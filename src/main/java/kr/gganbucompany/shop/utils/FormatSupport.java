package kr.gganbucompany.shop.utils;

public class FormatSupport {

    private static final long SECOND = 1000L, MINUTE = 60*SECOND, HOUR = 60*MINUTE, DAY = 24*HOUR;

    public static String leftTimeFormat(long time){
        long days = time / DAY;
        long hours = (time / HOUR) % 24;
        long minutes = (time / MINUTE) % 60;
        long seconds = (time / SECOND) % 60;
        StringBuilder builder = new StringBuilder();
        if (days > 0)
            builder.append(days + "일 ");
        if (hours > 0)
            builder.append(hours + "시간 ");
        if (minutes > 0)
            builder.append(minutes + "분 ");
        if (seconds >= 0)
            builder.append(seconds + "초");
        return builder.toString();
    }
}
