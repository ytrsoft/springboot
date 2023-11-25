package com.ytrsoft.util;

import com.ytrsoft.entity.Chinese;
import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.*;

public final class PinyinKit {

    private PinyinKit() {
        throw new UnsupportedOperationException();
    }

    public static List<Chinese> getAllChineseList() {
        List<Chinese> list = new ArrayList<>();
        for (char ch = 0x4E00; ch <= 0x9FA5; ch++) {
            Chinese chinese = buildChinese(ch);
            if (!Objects.isNull(chinese)) {
                list.add(chinese);
            }
        }
        return list;
    }

    public static Chinese buildChinese(char text) {
        Chinese chinese = new Chinese();
        String[] target = PinyinHelper.toHanyuPinyinStringArray(text);
        if (target == null) {
            return null;
        }
        for (String item: target) {
            if (!Objects.isNull(item)) {
                int tone = Integer.parseInt(item.substring(item.length() - 1));
                String pinYin = item.substring(0, item.length() - 1);
                chinese.setText(text);
                chinese.setTone(tone);
                chinese.setPinYin(pinYin);
            }
        }
        return chinese;
    }
}
