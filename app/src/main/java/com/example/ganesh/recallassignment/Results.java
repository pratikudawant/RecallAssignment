package com.example.ganesh.recallassignment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Ganesh on 2015-04-09.
 */
public class Results extends Activity{
    String y="";
    String a="";
    String b="";
    String c="";
    String d="";
    String f="";
    String g="";
    String h="";
    String j="";
    String year;
    String unitAffect;
    String model;
    String model5;
    String systemtype;
    String notiftype;
    String comments;
    String category;
    String modelname;
    String recallnumber;
    ArrayList modellist = new ArrayList();
    ArrayList categorylist= new ArrayList();
    ArrayList yearlist= new ArrayList();
    ArrayList unitAffectlist= new ArrayList();
    ArrayList systemtypelist= new ArrayList();
    ArrayList  notiftypelist= new ArrayList();
    ArrayList commentslist= new ArrayList();
    ArrayList  recallnumberlist= new ArrayList();
    ArrayList modelarraylist= new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
          model5 = extras.getString("model");

        }
       TextView Carinfo = (TextView) findViewById(R.id.textView2);
        TextView Carmake = (TextView) findViewById(R.id.textView3);
        TextView Carname = (TextView) findViewById(R.id.textView4);
        TextView Caryear = (TextView) findViewById(R.id.textView5);
        TextView Carcategory = (TextView) findViewById(R.id.textView6);
        TextView CarunitA = (TextView) findViewById(R.id.textView7);
        TextView Carsystem = (TextView) findViewById(R.id.textView8);
        TextView CarRecalNumber = (TextView) findViewById(R.id.textView9);
        TextView CarComment= (TextView) findViewById(R.id.textView10);
        TextView CarNotification = (TextView) findViewById(R.id.textView11);


        InputStream inputStream = getResources().openRawResource(
                R.raw.recall2);

       Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder db;

        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(inputStream);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        doc.getDocumentElement().normalize();
        NodeList Sectionelement  = doc.getElementsByTagName("Section");

        int sectionlength = Sectionelement.getLength();

        for (int a = 0; a < 1; a++) {
            NodeList informationElements = doc.getElementsByTagName("Field");

            final int length = informationElements.getLength();

            for (int i = 0; i < length; i++) {
                Element node = (Element) informationElements.item(i);
                NamedNodeMap attributes = node.getAttributes();
                int numAttrs = attributes.getLength();
                 Attr attr = (Attr) attributes.item(0);
               String attrName = attr.getNodeName();
                String attrValue = attr.getNodeValue();

                if (attrValue.equals("MAKENAMENM1")) {

                    Element eElement = (Element) node;

                    model = eElement.getElementsByTagName("FormattedValue").item(0).getTextContent();

                    modellist.add(model);
                }

                if (attrValue.equals("DATEYEARCD1")) {

                    Element mElement = (Element) node;

                    year = mElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                    yearlist.add(year);
                }

                if (attrValue.equals("UNITAFFECTEDNBR1")) {

                    Element mElement = (Element) node;

                    unitAffect = mElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                    unitAffectlist.add(unitAffect);
                }

                if (attrValue.equals("SYSTEMTYPEETXT1")) {

                    Element mElement = (Element) node;

                    systemtype = mElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                    systemtypelist.add(systemtype);
                }
                if (attrValue.equals("NOTIFICATIONTYPEETXT1")) {

                    Element mElement = (Element) node;

                    notiftype = mElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                    notiftypelist.add(notiftype);
               }
                if (attrValue.equals("COMMENTETXT1")) {

                    Element mElement = (Element) node;

                    comments = mElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                    commentslist.add(comments);
               }
                if (attrValue.equals("RECALLNUMBERNUM1")) {

                    Element mElement = (Element) node;

                    recallnumber = mElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                    recallnumberlist.add(recallnumber);

                }
                if (attrValue.equals("CATEGORYETXT1")) {

                    Element mElement = (Element) node;

                    category = mElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                    categorylist.add(category);
                }
                if (attrValue.equals("MODELNAMENM1")) {

                    Element mElement = (Element) node;

                   modelname = mElement.getElementsByTagName("FormattedValue").item(0).getTextContent();
                    modelarraylist.add(modelname);
                }





            }

        }
         if(modellist.contains(model5)){
           int r = modellist.size();

            for (int e = 0; e < r; e++) {

                if(modellist.get(e).equals(model5) ) {

                     a += (String)  modellist.get(e);
                  y += (String)  yearlist.get(e);
                    b += (String)  systemtypelist.get(e);
                    c += (String)  unitAffectlist.get(e);
                     d+= (String)  notiftypelist.get(e);
                    f += (String)  commentslist.get(e);
                    g+= (String)  categorylist.get(e);
                   h += (String)  modelarraylist.get(e);
                    j += (String)  recallnumberlist.get(e);


                }


              Caryear.setText("Year ="+ y);
                Carcategory.setText("Categroy="+g);
                CarComment.setText("Comments="+f);
                Carmake.setText("Car Make="+h);
                Carname.setText("Car Name="+a);
                CarNotification.setText("Car Notification Type="+d);
                CarRecalNumber.setText("Car Recall Number="+j);
                Carsystem.setText("Car System="+b);
                CarunitA.setText("Car Units Affected="+c);
            }
        }

    }
    public static ArrayList<String> removeDuplicates(ArrayList<String> year) {

        // Store unique items in result.
        ArrayList<String> result = new ArrayList<>();

        // Record encountered Strings in HashSet.
        HashSet<String> set = new HashSet<>();

        // Loop over argument list.
        for (String item : year) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }


}



