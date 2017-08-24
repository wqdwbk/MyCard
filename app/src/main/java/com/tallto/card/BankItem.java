package com.tallto.card;

import android.databinding.BaseObservable;

class BankItem extends BaseObservable {

    public String mBankID;
    public String mBankName;
    public String mServiceNumber;
    public String mServiceNumber400;
    public String mSmsNumber;
    public String mSmsRecvNumber;
    public String mSmsBillCode;
    public String mSmsBalanceCode;
    public String mBankIcon;

    public void setBankID(String bankID) {
        this.mBankID = bankID;
    }

    public void setBankName(String bankName) {
        this.mBankName = bankName;
    }

    public void setBankIcon(String bankIcon) {
        this.mBankIcon = bankIcon;
    }

    public void setServiceNumber(String serviceNumber) {
        this.mServiceNumber = serviceNumber;
    }

    public void setServiceNumber400(String serviceNumber400) {
        this.mServiceNumber400 = serviceNumber400;
    }

    public void setSmsNumber(String smsNumber) {
        this.mSmsNumber = smsNumber;
    }

    public void setSmsRecvNumber(String smsRecvNumber) {
        this.mSmsRecvNumber = smsRecvNumber;
    }

    public void setSmsBillCode(String smsBillCode) {
        this.mSmsBillCode = smsBillCode;
    }

    public void setSmsBalanceCode(String smsBalanceCode) {
        this.mSmsBalanceCode = smsBalanceCode;
    }

    public String getBankID() {
        return mBankID;
    }

    public String getBankName() {
        return mBankName;
    }

    public String getBankIcon() {
        return mBankIcon;
    }

    public String getServiceNumber() {
        return mServiceNumber;
    }

    public String getServiceNumber400() {
        return mServiceNumber400;
    }

    public String getSmsNumber() {
        return mSmsNumber;
    }

    public String getSmsRecvNumber() {
        return mSmsRecvNumber;
    }

    public String getSmsBillCode() {
        return mSmsBillCode;
    }

    public String getSmsBalanceCode() {
        return mSmsBalanceCode;
    }

}