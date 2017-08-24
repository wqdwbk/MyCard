package com.tallto.card;

import android.content.Context;
import android.content.res.AssetManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BanksXmlPullParser {

    private static final String fileName = "xml/BankList.xml";

    private static final String BANK_LIST = "bankList";
    private static final String BANK_ID = "bankID";
    private static final String BANK_NAME = "bankName";
    private static final String BANK_ICON = "bankIcon";
    private static final String SERVICE_NUMBER = "serviceNumber";
    private static final String SERVICE_NUMBER400 = "serviceNumber400";
    private static final String SMS_NUMBER = "smsNumber";
    private static final String SMS_REVCNUMBER = "smsRecvNumber";
    private static final String SMS_BILLCODE = "smsBillCode";
    private static final String SMS_BALANCECODE = "smsBalanceCode";

    public static List<BankItem> getBankItemsFromFile(Context ctx) {

        // List of BankItems that we will return
        List<BankItem> bankItems;
        bankItems = new ArrayList<>();

        // temp holder for current StackSite while parsing
        BankItem curBankItem = null;
        // temp holder for current text value while parsing
        String curText = "";

        try {
            // Get our factory and PullParser
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();

            // Open up InputStream and Reader of our file.
            AssetManager assetManager = ctx.getAssets();
            InputStream fis = assetManager.open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            // point the parser to our file.
            xpp.setInput(reader);

            // get initial eventType
            int eventType = xpp.getEventType();

            // Loop through pull events until we reach END_DOCUMENT
            while (eventType != XmlPullParser.END_DOCUMENT) {
                // Get the current tag
                String tagname = xpp.getName();

                // React to different event types appropriately
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase(BANK_LIST)) {
                            // If we are starting a new <bankList> block we need
                            //a new StackSite object to represent it
                            curBankItem = new BankItem();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        //grab the current text so we can use it in END_TAG event
                        curText = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase(BANK_LIST)) {
                            // if </bankList> then we are done with current Site
                            // add it to the list.
                            bankItems.add(curBankItem);
                        } else if (tagname.equalsIgnoreCase(BANK_ID)) {
                            // if </bankID> use setBankID() on curSite
                            assert curBankItem != null;
                            curBankItem.setBankID(curText);
                        } else if (tagname.equalsIgnoreCase(BANK_NAME)) {
                            // if </bankName> use setBankName() on curSite
                            curBankItem.setBankName(curText);
                        } else if (tagname.equalsIgnoreCase(BANK_ICON)) {
                            // if </bankIcon> use setBankIcon() on curSite
                            curBankItem.setBankIcon(curText);
                        } else if (tagname.equalsIgnoreCase(SERVICE_NUMBER)) {
                            // if </serviceNumber> use setServiceNumber() on curSite
                            curBankItem.setServiceNumber(curText);
                        } else if (tagname.equalsIgnoreCase(SERVICE_NUMBER400)) {
                            // if </serviceNumber400> use setServiceNumber400() on curSite
                            curBankItem.setServiceNumber400(curText);
                        } else if (tagname.equalsIgnoreCase(SMS_NUMBER)) {
                            // if </smsNumber> use setSmsNumber() on curSite
                            curBankItem.setSmsNumber(curText);
                        } else if (tagname.equalsIgnoreCase(SMS_REVCNUMBER)) {
                            // if </smsRecvNumber> use setSmsRecvNumber() on curSite
                            curBankItem.setSmsRecvNumber(curText);
                        } else if (tagname.equalsIgnoreCase(SMS_BILLCODE)) {
                            // if </smsBillCode> use setSmsBillCode() on curSite
                            curBankItem.setSmsBillCode(curText);
                        } else if (tagname.equalsIgnoreCase(SMS_BALANCECODE)) {
                            // if </smsBalanceCode> use setSmsBalanceCode() on curSite
                            curBankItem.setSmsBalanceCode(curText);
                        }
                        break;

                    default:
                        break;
                }
                //move on to next iteration
                eventType = xpp.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // return the populated list.
        return bankItems;
    }

}
