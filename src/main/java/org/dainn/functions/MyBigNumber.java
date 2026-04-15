package org.dainn.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyBigNumber {
    private static final Logger logger = Logger.getLogger(MyBigNumber.class.getName());
    public List<String> steps = new ArrayList<>();

    public String sum(String a, String b) {
        if(a == null) a = "0";
        if(b == null) b = "0";

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int step = 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? b.charAt(j--) - '0' : 0;

            int total = digit1 + digit2 + carry;
            result.append(total % 10);

            steps.add(log(step++, digit1, digit2, carry, total));
            carry = total / 10;
        }

        return result.length() == 0 ? "0" : stripLeadingZeros(result.reverse().toString());
    }

    public SumResult sumWithSteps(String a, String b) {
        return new SumResult(sum(a, b), steps);
    }

    private static String stripLeadingZeros(String s) {
        int start = 0;
        while (start < s.length() - 1 && s.charAt(start) == '0') start++;
        return s.substring(start);
    }

    private static String log(int step, int d1, int d2, int carry, int total) {
        StringBuilder msg = new StringBuilder(64)
                .append("Step ").append(step).append(": ")
                .append(d1).append(" + ").append(d2);

        if (carry > 0) msg.append(" + carry ").append(carry);
        msg.append(" = ").append(total);

        carry = total / 10;
        if (carry > 0) msg.append(", get ").append(total % 10).append(" carry ").append(carry);

        logger.info(msg.toString());
        return msg.toString();
    }
}
