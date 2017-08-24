package com.tallto.card;

import android.databinding.Bindable;
import android.util.Log;

import java.util.List;

public class CardItem extends BankItem {
    public static final int INIT_MARGIN = 2;
    public static final int FINAL_MARGIN = 16;

    @Bindable
    private
    int margin = 2;
    @Bindable
    private
    boolean expanded;

    private String mLimit = "额度50000";
    private String mBalance = "余额50000";
    private String mCharge = "账单50000";
    private String mCardNumber = "1692";
    private String mExpDate = "免息期15天";
    private String mBillDate = "账单日:1日";
    private String mPayDate = "还款日:18日";
    private String mWarningDate = "提醒日:15日";
    private String mBillRecord = "..................";

    //    public CardItem(String bankID, String bankName, String bankIcon, String serviceNumber, String serviceNumber400, String smsNumber, String smsRecvNumber, String smsBillCode, String smsBalanceCode, String limit, String balance) {
    public CardItem(String bankID) {
        initData(bankID);
    }

    public void initData(String bankID) {
        Log.e("CardItem", "bankInfo  bankID  = " + bankID);
        this.mBankID = bankID;
        List<BankItem> bankItems = BanksXmlPullParser.getBankItemsFromFile(MyApplication.getContextObject());
        for (int i = 0; i < bankItems.size(); i++) {
            BankItem curBank = bankItems.get(i);
//            Log.w("CardItem", "bankInfo bankID["+i+"] = "+curBank.getBankID()+" bankItems[" + i + "] = " + curBank.getBankName() + " |  icon = " + curBank.getBankIcon());
            if (curBank.getBankID().equals(bankID)) {
                Log.e("CardItem", "bankInfo  bankItems[" + i + "] = " + curBank.getBankName() + " |  icon = " + curBank.getBankIcon());
                this.mBankName = curBank.getBankName();
                this.mBankIcon = curBank.getBankIcon();
                this.mServiceNumber = curBank.getServiceNumber();
                this.mServiceNumber400 = curBank.getServiceNumber400();
                this.mSmsNumber = curBank.getSmsNumber();
                this.mSmsRecvNumber = curBank.getSmsRecvNumber();
                this.mSmsBillCode = curBank.getSmsBillCode();
                this.mSmsBalanceCode = curBank.getSmsBalanceCode();
            }
        }
    }

    public void setLimit(String limit) {
        this.mLimit = limit;
    }

    public void setBalance(String balance) {
        this.mBalance = balance;
    }

    public void setCharge(String charge) {
        this.mCharge = charge;
    }

    public void setCardNumber(String cardNumber) {
        this.mCardNumber = cardNumber;
    }

    public void setExpDate(String expDate) {
        this.mExpDate = expDate;
    }

    public void setBillDate(String billDate) {
        this.mBillDate = billDate;
    }

    public void setPayDate(String payDate) {
        this.mPayDate = payDate;
    }

    public void setWarningDate(String warningDate) {
        this.mWarningDate = warningDate;
    }

    public void setBillRecord(String billRecord) {
        this.mBillRecord = billRecord;
    }

    public int getMargin() {
        return margin;
    }

    public boolean getExpanded() {
        return expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setMargin(int margin) {
        this.margin = margin;
        notifyPropertyChanged(BR.margin);
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        notifyPropertyChanged(BR.expanded);
    }

    public String getLimit() {
        return mLimit;
    }

    public String getBalance() {
        return mBalance;
    }

    public String getCharge() {
        return mCharge;
    }

    public String getCardNumber() {
        return mCardNumber;
    }

    public String getExpDate() {
        return mExpDate;
    }

    public String getBillDate() {
        return mBillDate;
    }

    public String getPayDate() {
        return mPayDate;
    }

    public String getWarningDate() {
        return mWarningDate;
    }

    public String getBillRecord() {
        return mBillRecord;
    }

    @Override
    public String getServiceNumber400(){
        return "客服电话"+mServiceNumber400;
    }
}