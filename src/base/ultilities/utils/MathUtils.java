/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.ultilities.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Khang
 */
public class MathUtils {

    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            }else if (value instanceof Integer){
                ret = new BigDecimal((Integer) value);
            }else if (value instanceof Double){
                ret = new BigDecimal((Double) value);
            }
            else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }

    public static int getInt(Object value) {
        int ret = 0;
        if (value == null) {
            ret = 0;
        } else if (value instanceof BigDecimal) {
            ret = ((BigDecimal) value).intValue();
        } else if (value instanceof String) {
            ret = Integer.parseInt((String) value);
        } else if (value instanceof BigInteger) {
            ret = ((BigInteger) value).intValue();
        } else if (value instanceof Number) {
            ret = ((Number) value).intValue();
        } else if (value instanceof Long) {
            ret = ((Long) value).intValue();
        } else {
            throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
        }
        return ret;
    }
}
