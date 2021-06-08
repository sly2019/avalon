package com.sly.supos.history.demo1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author by wj on 2021/6/8 16:59
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) {
        long[] ds = {1619009217500L,1619016323500L,
                1619501255500L,1619501335500L,
                1619980569500L,1619980625500L,
                1620685322500L,1620685396500L,
                1620685349500L,1620685377500L,
                1620685585500L,1620685625500L,
                1620685713500L,1620685800500L,
                1621357982500L,1621358005500L,
                1621358076500L,1621358115500L,
                1621368876500L,1621368980500L,
                1621369110500L,1621369182500L} ;
            for(long d : ds){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cd = Calendar.getInstance();
            cd.setTimeInMillis(d);
            System.out.println(sdf.format(cd.getTime()));
        }

    }
}
