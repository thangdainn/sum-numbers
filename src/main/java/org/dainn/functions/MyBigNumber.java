package org.dainn.functions;

import java.util.logging.Logger;

public class MyBigNumber {
    private static final Logger logger = Logger.getLogger(MyBigNumber.class.getName());

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

            int sumWithoutCarry = digit1 + digit2;
            int totalSum = sumWithoutCarry + carry;
            int digit = totalSum % 10;
            int newCarry = totalSum / 10;
            result.append(digit);

            StringBuilder msg = new StringBuilder();
            msg.append("Step ").append(step).append(": Take ")
                    .append(digit1).append(" plus ").append(digit2)
                    .append(" equals ").append(sumWithoutCarry).append(". ");

            if (carry > 0) {
                msg.append("Plus and carry over ").append(carry)
                        .append(" equals ").append(totalSum).append(" ");
            }

            msg.append("Save ").append(digit).append(" to result");

            if (newCarry > 0) {
                msg.append(" and carry over ").append(newCarry);
            }

            logger.info(msg.toString());

            carry = newCarry;
            step++;
        }

        String sumResult = result.reverse().toString();

        if (sumResult.isEmpty()) {
            return "0";
        }
        int start = 0;
        while (start < sumResult.length() - 1 && sumResult.charAt(start) == '0') {
            start++;
        }
        return sumResult.substring(start);
    }
}
