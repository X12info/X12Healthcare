package com.xiaoerge.x12.control;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class TransactionTest {

    @Test
    public void testParseTransaction() {
        //need to escape *
        String x12 = "ST***~BHT\\*\\*\\*\\*\\*\\*~SE**~";
        Transaction transaction = new Transaction(x12);

        Assert.assertFalse(transaction.validate());
        Assert.assertFalse(transaction.isEmpty());
        Assert.assertNotEquals(x12, transaction.toX12String());
    }

    @Test
    public void testCreateTransaction() {
        String x12 = "ST***~BHT******~SE**~";
        Transaction transaction = new Transaction();

        Assert.assertTrue(transaction.validate());
        Assert.assertTrue(transaction.isEmpty());
        Assert.assertEquals("", transaction.toX12String());
    }
}